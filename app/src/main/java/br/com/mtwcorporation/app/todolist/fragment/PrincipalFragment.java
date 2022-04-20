package br.com.mtwcorporation.app.todolist.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.FragmentPrincipalBinding;


public class PrincipalFragment extends Fragment {

    private FragmentPrincipalBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {


        // INSTANCIAR O BINDING
        binding = FragmentPrincipalBinding.inflate(getLayoutInflater(), container, false);

        // RETORNA A VIEW RAIZ(root) DO BINDING
        return binding.getRoot();
    }
}