package br.com.mtwcorporation.app.todolist.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.FragmentCadastroTarefaBinding;


public class CadastroTarefaFragment extends Fragment {

    private FragmentCadastroTarefaBinding binding;
    // VARIAVEL PARA O DATEPICKER
    private DatePickerDialog datePickerDialog;
    // VARIAVEL PARA ANO, MES ,DIA
    int year, month, day;
    // VARIAVEL PARA OBTER A DATA ATUAL
    Calendar dataAtual;
    // VARIAVEL PARA A DATA FORMATADA
    String dataFormatada;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // INSTANCIANDO BINDING
        binding = FragmentCadastroTarefaBinding.inflate(getLayoutInflater(), container, false);

        // INSTANCIAR A DATA ATUAL
        dataAtual = Calendar.getInstance();
        // OBTER ANO, MES E DIA DA DATA ATUAL
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        // instanciar o datepicker
        datePickerDialog = new DatePickerDialog(getContext(), (datePicker, ano, mes ,dia) ->{

        }, year, month, day);

        // ação do clique de seleção da data
        binding.btData.setOnClickListener(v -> {
            datePickerDialog.show();
        });


        // retorna a raiz do binding
        return binding.getRoot();
    }
}