package com.example.sandra.mysqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import modelo.Contacto;
import modelo.DAOContactos;

public class InsertarContactos extends AppCompatActivity {

    Button btnGuardar;
    Button btnRegresar;
    EditText txtUsuario;
    EditText txtEmail;
    EditText txtTwitter;
    EditText txtTel ;
    EditText txtFechN ;
    DAOContactos objetoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_contactos);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnRegresar=(Button) findViewById(R.id.btnRegresar);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtTwitter = (EditText) findViewById(R.id.txtTwitter);
        txtTel = (EditText) findViewById(R.id.txtTel);
        txtFechN = (EditText) findViewById(R.id.txtFechaN);
        objetoDAO = new DAOContactos(this);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modelo.Contacto ob=new Contacto(txtUsuario.getText().toString(),txtEmail.getText().toString(),txtTwitter.getText().toString(),
                        txtTel.getText().toString(),txtFechN.getText().toString());
                objetoDAO.insert(ob);
                Confirmacion();
                Limpiar();

            }
        });
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),MainActivity.class);
                startActivityForResult(i,100);
            }
        });
    }


    public void Confirmacion(){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Se ha agregado exitosamente!");
        dlgAlert.setTitle("Agregar Persona");
        dlgAlert.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    public void Limpiar(){
        txtUsuario.setText("");
        txtEmail.setText("");
        txtTwitter.setText("");
        txtTel.setText("");
        txtFechN.setText("");
    }
}
