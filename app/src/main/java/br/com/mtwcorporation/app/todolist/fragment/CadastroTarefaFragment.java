package br.com.mtwcorporation.app.todolist.fragment;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.Calendar;

import br.com.mtwcorporation.app.todolist.Dao.AppDao;
import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.FragmentCadastroTarefaBinding;
import br.com.mtwcorporation.app.todolist.model.Tarefa;


public class CadastroTarefaFragment extends Fragment {

    private FragmentCadastroTarefaBinding binding;
    // VARIÁVEL PARA O DATEPICKER
    private DatePickerDialog datePickerDialog;
    // VARIÁVEL PARA ANO, MES ,DIA
    int year, month, day;
    // VARIÁVEL PARA OBTER A DATA ATUAL
    Calendar dataAtual;
    // VARIÁVEL PARA A DATA FORMATADA
    String dataFormatada = "";
    // variável para a dataBase
    AppDao dataBase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // INSTANCIA A DATABASE
        dataBase = AppDao.getDataBase(getContext());

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

            // AO ESCOLHER UMA DATA NO DATEPICKER E CLICAR OK, ELE CAI AQUI!
            // PASSANDO A DATA ESCOLHIDA PARA AS VARIAVEIS GLOBAL
            year = ano;
            month = mes;
            day = dia;

            // FORMATA A DATA
            dataFormatada = String.format("%02d/%02d/%4d", day, month+1, year);
            // APLICA A DATA FORMATADA NO BOTÃO
            binding.btData.setText(dataFormatada);

        }, year, month, day);

        // ação do clique de seleção da data
        binding.btData.setOnClickListener(v -> {
            datePickerDialog.show();
        });

        // listerner do botão salvar
        binding.btSalvar.setOnClickListener(v -> {


            // SE TITULO DA TAREFA VAZIO
            if(binding.editTitulo.getText().toString().isEmpty()) {

                Toast.makeText(getContext(), R.string.titulo_tarefa_vazio, Toast.LENGTH_LONG).show();

            }// SE A DATA FORMATADA ESTÁ VAZIA
            else if(dataFormatada.isEmpty()) {

                Toast.makeText(getContext(), R.string.data_prevista_vazia, Toast.LENGTH_LONG).show();
            }else {

                // CRIA TAREFA
                Tarefa tarefa = new Tarefa();

                // popular o objeto tarefa
                tarefa.setTitulo(binding.editTitulo.getText().toString());
                tarefa.setDescricao(binding.editDescricao.getText().toString());
                tarefa.setDataCriacao(dataAtual.getTimeInMillis());
                // criar um Calendar
                Calendar dataPrevista = Calendar.getInstance();
                // muda a data para a data escolhida no datePicker
                dataPrevista.set(year, month,day);
                // passa os milisegundos da data para a data prevista
                tarefa.setDataPrevista(dataPrevista.getTimeInMillis());

                // salvar a Tarefa
                new InsertTarefa().execute(tarefa);
            }

        });

        // retorna a raiz do binding
        return binding.getRoot();
    }

    // AsyncTask para inserir Tarefa
    private class InsertTarefa  extends AsyncTask<Tarefa, Void, String > {


        @Override
        protected String doInBackground(Tarefa... tarefas) { // tres pontinhos indica numero variavel da parâmetros

            // pegar a tarefa a partir do vetor
            Tarefa t = tarefas[0];

            try {
                // chamar a metodo para salvar a tarefa
                dataBase.getTarefaDao().insert(t);

                // retornar
                return "salvo";
            }catch (Exception e){

                e.printStackTrace();
                // retorna a mensagem de erro
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {// mandar menagens para o usuario, sucesso, erro...
            super.onPostExecute(result);

            if (result.equals("salvo")){
                Log.w("result", "Blzzzz Tarefa Inserida com sucesso");
                Toast.makeText(getContext(), "nova tarefa salva com sucesso", Toast.LENGTH_LONG).show();
                // voltar ao fragment anterior
                getActivity().onBackPressed();// envocando o botão de voltar
            }else{
                Log.w("result", result);
                Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
            }

            binding.editTitulo.setText("");
            binding.editDescricao.setText("");
            binding.btData.setText("Data Prevista");
        }
    }
}