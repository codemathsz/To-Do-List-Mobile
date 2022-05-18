package br.com.mtwcorporation.app.todolist.fragment;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.FragmentCadastroSubtarefaBinding;
import br.com.mtwcorporation.app.todolist.model.Tarefa;


public class CadastroSubtarefaFragment extends Fragment {


    private FragmentCadastroSubtarefaBinding binding;
    // VARIAVEL PARA TAREFA
    private Tarefa tarefa;
    // VARIAVEL PARA O DIALOG DA FOTO
    private AlertDialog dialogFoto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // instanciando binding
        binding = FragmentCadastroSubtarefaBinding.inflate(getLayoutInflater(),container,false);

        if (getArguments() != null){

            tarefa = (Tarefa) getArguments().getSerializable("tarefa");

            binding.tvTituloSub.setText(tarefa.getTitulo());
            binding.tvDescricaoSub.setText(tarefa.getDescricao());

        }

        // HABILITA O  MENU
        setHasOptionsMenu(true);

        // INSTANCIA O DIALOG
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.origem_imagem);
        String[] opcoes = {getString(R.string.camera), getString(R.string.galeria)};
        builder.setItems(opcoes,listenerDialog);
        dialogFoto = builder.create();


        // LISTENER DO CLICK DA IMAGEM
        binding.imageFoto.setOnClickListener(v ->{
            dialogFoto.show();
        });

        // retorna a raiz do binding
        return binding.getRoot();
    }

    // LISTENER DISPARADO AO ESCOLHER UMA OPÇÃO NO DIALOG
    private DialogInterface.OnClickListener listenerDialog =  (dialog, i )->{


    };

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_subtarefa, menu);
    }
}