package br.com.mtwcorporation.app.todolist.model;

import lombok.Data;

@Data
public class SubTarefa {

    private Long idSubTarefa;
    private String descricao;
    private String foto;
    private boolean concluida;
    private Long idTarefa;

}
