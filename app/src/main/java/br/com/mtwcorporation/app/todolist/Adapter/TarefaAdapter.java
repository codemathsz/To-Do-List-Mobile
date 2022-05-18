package br.com.mtwcorporation.app.todolist.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>{

    // variável para a lista de tarefas
    private List<Tarefa> tarefas;
    // variável para Context
    private Context context;
    // VARIAVEL PARA O LISTENER
    private  OnTarefaClickListener listenerTarefa;

    // contrutor que recebe os parâmetros para o adapter
    public TarefaAdapter(List<Tarefa> lista, Context contexto, OnTarefaClickListener listenerTarefa){

        this.tarefas = lista;
        this.context = contexto;
        this.listenerTarefa = listenerTarefa;
    }



    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // inflar  a View do ViewHolder
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_tarefas,parent,false);


        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        // pegar  a Tarefa e transformar em um ViewHolder

        // obter a tarefa através da position
        Tarefa t = tarefas.get(position);
        // transportar as informações da tarefa para o ViewHolder
        holder.tvTitulo.setText(t.getTitulo());
        // formatar a data
        SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        holder.tvData.setText(simpleDateFormat.format(t.getDataPrevista()));


        // verifica se
        if (t.isConcluida()){
            holder.tvStatus.setText("Finalizada");
            holder.tvStatus.setBackgroundColor(context.getResources().getColor(R.color.limao_claro));
        }else if(t.isAtraso()){
            holder.tvStatus.setText("Em Atraso");
        }
        else{
            holder.tvStatus.setText("Em aberto");
        }

        // IMPLEMENTA O CLICK NA TAREFA
        holder.itemView.setOnClickListener(v -> {
            Log.w("CLICOU", "CLICOU NA POSIÇÃO "+position);
            listenerTarefa.onClick(v,t);
        });

    }

    @Override
    public int getItemCount() {
        if (tarefas != null) {
            return tarefas.size();
        }
        return 0;
    }

    // classe interna
    class TarefaViewHolder extends RecyclerView.ViewHolder {

        // variáveis para os componentes do layout
        TextView tvTitulo,tvStatus,tvData;
        ImageView imgTarefa;

        public TarefaViewHolder(@NonNull View itemView) {
            super(itemView);

            // passar da view para os componentes
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            imgTarefa = itemView.findViewById(R.id.img_tarefa);
            tvData = itemView.findViewById(R.id.tvData);
        }
    }

    // INTERFACE PARA O CLICK DA TAREFA
    public interface OnTarefaClickListener{

        void onClick(View v, Tarefa t);
    }
}
