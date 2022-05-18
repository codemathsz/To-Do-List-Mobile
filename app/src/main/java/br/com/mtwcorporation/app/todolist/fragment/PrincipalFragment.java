package br.com.mtwcorporation.app.todolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.io.Serializable;
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

        // INSTANCIA A DATA BASE, PARA ACESSAR O BD
        dao = AppDao.getDataBase(getContext());

        // DEFINE O LAYOUT MANAGER DO RECYCLER
        binding.recyclerTarefas.setLayoutManager(new LinearLayoutManager(getContext()));// PARA AS TAREFAS APARECEREM EM FORMA DE LISTA, UM EM BAIXO DO OUTRO

        new ReadTarefas().execute();

        // RETORNA A VIEW RAIZ(root) DO BINDING
        return binding.getRoot();
    }

    // classe que busca as tarefas
    class ReadTarefas extends AsyncTask<Void,Void, List<Tarefa>> {

        @Override              //   buscar os dados no banco de dados
        protected List<Tarefa> doInBackground(Void... voids) {

            // BUSCAR AS TAREFAS E GUARDAR NA VARIAVEL TAREFA
            tarefas = dao.getTarefaDao().getTarefaAll();

            return tarefas;
        }

        @Override      //   recebe a busca do doInBackground
        protected void onPostExecute(List<Tarefa> tarefas) {

            // INSTACIA O ADAPTER
            adapter = new TarefaAdapter(tarefas,getContext(), listenerClick);
            // APLICAR O ADAPTER NO RECLYCER VIEW
            binding.recyclerTarefas.setAdapter(adapter);

            super.onPostExecute(tarefas);
        }
    }

    // LISTENER PARA CLICK NAS TAREFAS
    private TarefaAdapter.OnTarefaClickListener listenerClick = (view, tarefa) ->{

        // VARIÁVEL PARA PENDURAR A TAREFA
        Bundle bundle = new Bundle();

        // "pendura"  A TAREFA NO BUNDLE
        bundle.putSerializable("tarefa", tarefa);
        // navega para o fragment de detalhes
        NavHostFragment.findNavController(PrincipalFragment.this).navigate(R.id.action_principalFragment_to_infoTarefaFragment, bundle);
    };
}