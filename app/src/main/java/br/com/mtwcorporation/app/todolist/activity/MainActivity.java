package br.com.mtwcorporation.app.todolist.activity;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import br.com.mtwcorporation.app.todolist.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // instanciando binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // seta na contentView a raiz (root) do binding
        setContentView(binding.getRoot());


    }




}