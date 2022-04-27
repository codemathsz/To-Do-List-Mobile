package br.com.mtwcorporation.app.todolist.Dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.com.mtwcorporation.app.todolist.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDao extends RoomDatabase {

    // variável para acessar a dataBase
    private static  AppDao dataBase;
    // método para tarefa dao
    public abstract TarefaDao getTarefaDao();

    // método para instanciar dataBase
    public static AppDao getDataBase(Context context){

        // verifica se a dataBase é nula
        if (dataBase == null){
            // instancia a dataBase
            dataBase = Room.databaseBuilder
                    (context.getApplicationContext(),AppDao.class,"todolist").build();// criar a conexao da dataBase
        }
        // retorna dataBase
        return dataBase;
    }

}
