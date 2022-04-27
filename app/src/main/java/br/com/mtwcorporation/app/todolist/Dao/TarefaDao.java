package br.com.mtwcorporation.app.todolist.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.com.mtwcorporation.app.todolist.model.Tarefa;

@Dao // Mapeando essa classe como um DAO
public interface TarefaDao {

    @Insert
    void insert(Tarefa tarefa);

    @Update
    void update(Tarefa tarefa);

    @Delete
    void delete(Tarefa tarefa);

    @Query("SELECT * FROM tarefa")
    List<Tarefa> getTarefaAll();
}
