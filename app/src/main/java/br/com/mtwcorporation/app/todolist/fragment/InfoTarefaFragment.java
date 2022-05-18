package br.com.mtwcorporation.app.todolist.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.text.SimpleDateFormat;

import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.FragmentInfoTarefaBinding;
import br.com.mtwcorporation.app.todolist.model.Tarefa;


public class InfoTarefaFragment extends Fragment {

    private FragmentInfoTarefaBinding binding;
    // VARIAVEL PARA TAREFA
    private Tarefa tarefa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // instanciando o binding
        binding = FragmentInfoTarefaBinding.inflate(getLayoutInflater(), container, false);

        // VERIFICA SE FOI PASSADO ALGO NO BUNDLE
        if (getArguments() != null){
            // RECUPERA A TAREFA DO BUNDLE
            tarefa = (Tarefa) getArguments().getSerializable("tarefa");



            // popular as informações da tarefa
            binding.tvTituloTarefa.setText(tarefa.getTitulo());
            binding.tvDescricaoTarefa.setText(tarefa.getDescricao());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            binding.tvData.setText(simpleDateFormat.format(tarefa.getDataCriacao()));

        }

        binding.btSubTarefa.setOnClickListener(v-> {

            // VARIÁVEL PARA PENDURAR A TAREFA
            Bundle bundle = new Bundle();

            // "pendura"  A TAREFA NO BUNDLE
            bundle.putSerializable("tarefa", tarefa);
            NavHostFragment.findNavController(InfoTarefaFragment.this).navigate(R.id.action_infoFragment_to_cadastrarSubTarefaFragment);
        });

        // retorna a raiz do binding
        return binding.getRoot();
    }
}