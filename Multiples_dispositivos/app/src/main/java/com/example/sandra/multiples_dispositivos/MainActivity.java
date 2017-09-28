package com.example.sandra.multiples_dispositivos;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Fragment2 fragment2 =
                (Fragment2) getSupportFragmentManager()
                        .findFragmentById(R.id.fragment2);
        if(fragment2 !=null){

        }else{
            Fragment2 fragment =new Fragment2();
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction= manager.beginTransaction();
            transaction.add(R.id.Contenedor_fragment,fragment,"");
            transaction.commit();
        }


    }
}
