package br.com.mtwcorporation.app.todolist.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Calendar;

import lombok.Data;

@Data
@Entity
public class Tarefa implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private Long idTarefa;
    private String titulo;
    private String descricao;
    private long dataCriacao;
    private long dataPrevista;
    private long dataFinalizada;

    public Long getIdTarefa() {
        return idTarefa;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public long getDataCriacao() {
        return dataCriacao;
    }

    public long getDataPrevista() {
        return dataPrevista;
    }

    public long getDataFinalizada() {
        return dataFinalizada;
    }

    public void setIdTarefa(Long idTarefa) {
        this.idTarefa = idTarefa;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataCriacao(long dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataPrevista(long dataPrevista) {
        this.dataPrevista = dataPrevista;
    }

    public void setDataFinalizada(long dataFinalizada) {
        this.dataFinalizada = dataFinalizada;
    }

    public boolean isConcluida(){
        return dataFinalizada != 0;
    }

    public boolean isAtraso(){

        return Calendar.getInstance().getTimeInMillis() > getDataPrevista();
    }
}
