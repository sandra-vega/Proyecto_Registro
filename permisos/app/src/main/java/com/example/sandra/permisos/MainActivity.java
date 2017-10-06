package com.example.sandra.permisos;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private View vista;
    private static final int SOLICITUD_PERMISO_WRITE_CALL_LOG = 0;
    private static final int SOLICITUD_PERMISO_CAMERA = 0;
    ImageButton Camara;
    private static final int SOLICITUD_PERMISO_SEND_SMS = 0;
    ImageButton Mensajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vista = findViewById(R.id.content_main);
        Camara= (ImageButton) findViewById(R.id.btnCamara);
        Mensajes=(ImageButton) findViewById(R.id.btnMensaje);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });

        Mensajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirMensajes();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                borrarLlamada();
            }
        });
    }
    void abrirMensajes() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                == PackageManager.PERMISSION_GRANTED) {
        }
        else {
            solicitarPermisosMesajes();
        }
    }
    public void solicitarPermisosMesajes() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.SEND_SMS)){
           /* new AlertDialog.Builder(this)
                    .setTitle("Solicitud de permiso")
                    .setMessage("Sin Permiso para administar llamadas no puedo borrar" +
                            "llamadas del registro")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.WRITE_CALL_LOG},
                                    SOLICITUD_PERMISO_WRITE_CALL_LOG);
                        }})
                    .show();*/
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    SOLICITUD_PERMISO_SEND_SMS);
        }
    }

    void abrirCamara() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
        }
        else {
            solicitarPermisoCamara();
        }
    }
    public void solicitarPermisoCamara() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.CAMERA)){
           /* new AlertDialog.Builder(this)
                    .setTitle("Solicitud de permiso")
                    .setMessage("Sin Permiso para administar llamadas no puedo borrar" +
                            "llamadas del registro")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.WRITE_CALL_LOG},
                                    SOLICITUD_PERMISO_WRITE_CALL_LOG);
                        }})
                    .show();*/
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    SOLICITUD_PERMISO_CAMERA);
        }
    }

    void borrarLlamada() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_CALL_LOG)
                == PackageManager.PERMISSION_GRANTED) {
            /*getContentResolver().delete(CallLog.Calls.CONTENT_URI,
                    "number='555555555'", null);*/
        }
        else {
            solicitarPermisoBorrarLlamada();

        }
    }
    public void solicitarPermisoBorrarLlamada() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this, Manifest.permission.WRITE_CALL_LOG)){
           /* new AlertDialog.Builder(this)
                    .setTitle("Solicitud de permiso")
                    .setMessage("Sin Permiso para administar llamadas no puedo borrar" +
                            "llamadas del registro")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog, int whichButton) {
                            ActivityCompat.requestPermissions(this,
                                    new String[]{Manifest.permission.WRITE_CALL_LOG},
                                    SOLICITUD_PERMISO_WRITE_CALL_LOG);
                        }})
                    .show();*/
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_CALL_LOG},
                    SOLICITUD_PERMISO_WRITE_CALL_LOG);
        }
    }


    @Override public void onRequestPermissionsResult(int requestCode,
                                                     String[] permissions, int[] grantResults) {
        if (requestCode == SOLICITUD_PERMISO_WRITE_CALL_LOG) {
            if (grantResults.length== 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                borrarLlamada();
            } else {
                Toast.makeText(this, "Sin el permiso, no puedo realizar la " +
                        "acción", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == SOLICITUD_PERMISO_CAMERA) {
            if (grantResults.length== 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                abrirCamara();
            } else {
                Toast.makeText(this, "Sin el permiso, no puedo realizar la " +
                        "acción de camara", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == SOLICITUD_PERMISO_SEND_SMS) {
            if (grantResults.length== 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                abrirMensajes();
            } else {
                Toast.makeText(this, "Sin el permiso, no puedo realizar la " +
                        "acción de mensajes", Toast.LENGTH_SHORT).show();
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
