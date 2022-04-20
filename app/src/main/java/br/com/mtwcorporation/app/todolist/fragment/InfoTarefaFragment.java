package br.com.mtwcorporation.app.todolist.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.FragmentInfoTarefaBinding;


public class InfoTarefaFragment extends Fragment {

    private FragmentInfoTarefaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // instanciando o binding
        binding = FragmentInfoTarefaBinding.inflate(getLayoutInflater(), container, false);

        // retorna a raiz do binding
        return binding.getRoot();
    }
}