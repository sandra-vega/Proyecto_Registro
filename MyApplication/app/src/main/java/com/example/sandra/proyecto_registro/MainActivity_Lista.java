package com.example.sandra.proyecto_registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity_Lista extends AppCompatActivity {
    Button btnAceptar;
    ListView lsv;
    ArrayList<pojos> arreglo=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__lista);
        btnAceptar =(Button) findViewById(R.id.btnAceptar);
        lsv = (ListView) findViewById(R.id.lstRegistro);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Registro.class);
                startActivityForResult(i,100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100&&resultCode==RESULT_OK){
            arreglo.add((pojos)data.getSerializableExtra("clave"));
            String[]arr=new String[arreglo.size()];
            for(int i= 0; i<arreglo.size(); i++){
                arr[i]=arreglo.get(i).toString();
            }
            ArrayAdapter<String> a=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arr);
            lsv.setAdapter(a);


        }
    }
}
