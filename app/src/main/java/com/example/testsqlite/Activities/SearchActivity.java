package com.example.testsqlite.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testsqlite.Data;
import com.example.testsqlite.POJOs.Usuario;
import com.example.testsqlite.R;

public class SearchActivity extends AppCompatActivity {

    EditText id;
    private Button buscar;
    Data data;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        usuario = new Usuario();
        id = findViewById(R.id.id);
        buscar = findViewById(R.id.buscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idBuscar = id.getText().toString();
                data = new Data(getApplicationContext());
                data.open();
                usuario = data.getUsuario(idBuscar);
                Log.e("RESULTADO: ",usuario.getNombre());

            }
        });
    }
}
