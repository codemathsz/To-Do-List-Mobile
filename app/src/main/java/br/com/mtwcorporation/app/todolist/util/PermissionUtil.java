package br.com.mtwcorporation.app.todolist.util;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil  {

    public static  boolean checarPermissao(Activity activity, int requestCode, String... permissoes){
        List<String> negadas = new ArrayList<>();

        // PERCORRER AS PERMISSÕES, PROCURANDO AS NEGADAS
        for (String permissao : permissoes){
            // verifica se esta negada
            if (ContextCompat.checkSelfPermission(activity, permissao) != PackageManager.PERMISSION_GRANTED){
                negadas.add(permissao);
            }
        }
        // se a lista de negadas vazia, return true
        if (negadas.isEmpty()){
            return true;
        }

        // CONVERTE A LISTA EM VETOR, convertendo uma lista para String
        String[] permisssoesNegadas = new String[negadas.size()];
        negadas.toArray(permisssoesNegadas);

        ActivityCompat.requestPermissions(activity, permisssoesNegadas, requestCode);
        return  false;
    }
}
