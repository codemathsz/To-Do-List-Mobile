package br.com.mtwcorporation.app.todolist.activity;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import br.com.mtwcorporation.app.todolist.R;
import br.com.mtwcorporation.app.todolist.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    // VARIAVEIS PARA CONFIGURAR A NAVEGAÇÃO
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // instanciando binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        // seta na contentView a raiz (root) do binding
        setContentView(binding.getRoot());

        // CONFIGURANDO A NAVIGATION COM A APP BAR
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }
}