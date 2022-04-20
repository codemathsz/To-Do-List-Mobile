package br.com.mtwcorporation.app.todolist.model;

import lombok.Data;

@Data
public class Tarefa {

    private Long idTarefa;
    private String titulo;
    private String descricao;
    private long dataCriacao;
    private long dataPrevista;
    private long dataFinalizada;



}
