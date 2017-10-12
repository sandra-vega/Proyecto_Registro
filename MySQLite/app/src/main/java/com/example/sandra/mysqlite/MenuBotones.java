package com.example.sandra.mysqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuBotones extends Fragment {

    public MenuBotones() {
        // Required empty public constructor
    }
    Button btnInsertar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View layout=inflater.inflate(R.layout.fragment_botones, container, false);

        btnInsertar=layout.findViewById(R.id.btnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),InsertarContactos.class);
                startActivityForResult(i,100);
            }
        });

        return layout;
    }

}
