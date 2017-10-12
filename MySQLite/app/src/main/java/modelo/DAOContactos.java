package modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sandra on 11/10/2017.
 */

public class DAOContactos {
    Context _contexto;
    SQLiteDatabase _midb;

    public DAOContactos(Context contexto){
        _contexto = contexto;
        _midb =
                new MiSQLiteOpenHelper(contexto)
                        .getWritableDatabase();
    }

    public long insert(Contacto c){
        ContentValues cv = new ContentValues();

        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[1], c.getNombre());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[2], c.getCorreo_electronico());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[3], c.getTwitter());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[4], c.getTelefono());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[5], c.getFecha_nacimiento());

        return  _midb.insert(MiSQLiteOpenHelper.TABLE_CONTACTOS_NAME,null,cv);
    }

    public long update(Contacto c){
        ContentValues cv = new ContentValues();

        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[1], c.getNombre());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[2], c.getCorreo_electronico());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[3], c.getTwitter());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[4], c.getTelefono());
        cv.put(MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS[5], c.getFecha_nacimiento());

        return _midb.update(MiSQLiteOpenHelper.TABLE_CONTACTOS_NAME,
                cv,
                "_id=?",
                new String[]{String.valueOf(c.getId())}
        );
    }

    public List<Contacto> getAll(){
        List<Contacto> lstC=null;

        Cursor cursor = _midb.query(MiSQLiteOpenHelper.TABLE_CONTACTOS_NAME,
                MiSQLiteOpenHelper.COLUMNS_NAME_TABLE_CONTACTOS,
                null, null, null,null,null);


        if(cursor.moveToFirst()){
            lstC = new ArrayList<Contacto>();
            do{
                Contacto c = new Contacto();

                c.setId(cursor.getLong(0));
                c.setNombre(cursor.getString (1));
                c.setCorreo_electronico(cursor.getString (2));


                lstC.add(c);

            }while (cursor.moveToNext());
        }

        return lstC;
    }

}
