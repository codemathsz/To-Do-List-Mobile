package br.com.mtwcorporation.app.todolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

import br.com.mtwcorporation.app.todolist.Adapter.TarefaAdapter;
import br.com.mtwcorporation.app.todolist.Dao.AppDao;
import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.FragmentPrincipalBinding;
import br.com.mtwcorporation.app.todolist.model.Tarefa;


public class PrincipalFragment extends Fragment {

    private FragmentPrincipalBinding binding;
    // variavel para a lista
    private List<Tarefa> tarefas;
    // variavel para o adapter
    private TarefaAdapter adapter;
    // variável para database
    private AppDao dao;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        // INSTANCIAR O BINDING
        binding = FragmentPrincipalBinding.inflate(getLayoutInflater(), container, false);

        binding.btNovaTarefa.setOnClickListener(v ->{
            NavHostFragment.findNavController(PrincipalFragment.this).navigate( R.id.action_principalFragment_to_cadastroTarefaFragment);
        });

        // RETORNA A VIEW RAIZ(root) DO BINDING
        return binding.getRoot();
    }

    // classe que busca as tarefas
    class ReadTarefas extends AsyncTask<Void,Void, List<Tarefa>> {

        @Override              //   buscar os dados no banco de dados
        protected List<Tarefa> doInBackground(Void... voids) {
            return null;
        }

        @Override      //   recebe a busca do doInBackground
        protected void onPostExecute(List<Tarefa> tarefas) {
            super.onPostExecute(tarefas);
        }
    }
}