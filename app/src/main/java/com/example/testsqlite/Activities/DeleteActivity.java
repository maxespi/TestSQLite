package com.example.testsqlite.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testsqlite.Data;
import com.example.testsqlite.R;

public class DeleteActivity extends AppCompatActivity {

    EditText idBorrar;
    Button borrar;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        idBorrar = findViewById(R.id.id);
        borrar = findViewById(R.id.borrar);

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idBorrar.getText().toString();
                data = new Data(getApplicationContext());
                data.deleteUser(id);
                Toast.makeText(DeleteActivity.this, "Se ha eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
