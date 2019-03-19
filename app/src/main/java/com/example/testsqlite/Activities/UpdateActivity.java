package com.example.testsqlite.Activities;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testsqlite.Data;
import com.example.testsqlite.POJOs.Usuario;
import com.example.testsqlite.R;
import com.example.testsqlite.SQLConstants;

public class UpdateActivity extends AppCompatActivity {

    Button update, obtener;
    EditText id, nombre, edad, correo;
    Data data;
    Usuario usuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        update = findViewById(R.id.update);
        obtener = findViewById(R.id.obtener);
        id = findViewById(R.id.id);
        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        correo = findViewById(R.id.correo);

        obtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                String idBuscar = id.getText().toString();
                data = new Data(getApplicationContext());
                data.open();
                usuario = data.getUsuario(idBuscar);
                nombre.setText(usuario.getNombre());
                edad.setText(String.valueOf(usuario.getEdad()));
                correo.setText(usuario.getCorreo());
                data.close();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idBuscar = id.getText().toString();
                ContentValues contentValues = new ContentValues(4);
                contentValues.put(
                        SQLConstants.COLUMN_NOMBRE,
                        nombre.getText().toString());
                contentValues.put(
                        SQLConstants.COLUMN_EDAD,
                        Integer.valueOf(edad.getText().toString()));
                contentValues.put(
                        SQLConstants.COLUMN_CORREO,
                        correo.getText().toString());

                data = new Data(getApplicationContext());
                data.open();
                data.updateUser(idBuscar,contentValues);
                Toast.makeText(
                        UpdateActivity.this,
                        "Se actualizaron los datos",
                        Toast.LENGTH_SHORT).show();
                data.close();
            }
        });



    }
}
