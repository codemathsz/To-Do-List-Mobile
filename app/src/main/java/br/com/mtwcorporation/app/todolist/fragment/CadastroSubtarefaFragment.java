package br.com.mtwcorporation.app.todolist.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.FragmentCadastroSubtarefaBinding;


public class CadastroSubtarefaFragment extends Fragment {


    private FragmentCadastroSubtarefaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // instanciando binding
        binding = FragmentCadastroSubtarefaBinding.inflate(getLayoutInflater(),container,false);

        // retorna a raiz do binding
        return binding.getRoot();
    }
}