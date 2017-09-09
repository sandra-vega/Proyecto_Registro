package com.example.sandra.proyecto_registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
    Button btnGuardar;
    EditText txtUsuario;
    EditText txtEmail;
    EditText txtTwitter;
    EditText txtTel ;
    EditText txtFechN ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtTwitter = (EditText) findViewById(R.id.txtTwitter);
        txtTel = (EditText) findViewById(R.id.txtTel);
        txtFechN = (EditText) findViewById(R.id.txtFechaN);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pojos ob=new pojos(txtUsuario.getText().toString(),txtEmail.getText().toString(),txtTwitter.getText().toString(),
                        txtTel.getText().toString(),txtFechN.getText().toString());

                Intent i = new Intent();
                i.putExtra("clave",ob);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
