package com.emplonic.brothersapp.emplonic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by usuario on 27/11/2016.
 */

public class EmpleadorHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="EmploNic.db";
    private static final int DATABASE_VERSION=3;
    private static final String TEXT_TYPE="TEXT";
    private static final String INTEGER_TYPE="INTEGER";


    private static final String SQL_CREATE_EMPLEADOR=
            "CREATE TABLE " + Contrato.TABLA +
                    "(" + Contrato._ID +" "+ INTEGER_TYPE + " PRIMARY KEY ,"
                    + Contrato.NOMBRE +" "+ TEXT_TYPE + ","
                    + Contrato.DIRRECCION +" "+ TEXT_TYPE + ","
                    + Contrato.EMAIL +" "+ TEXT_TYPE + ","
                    + Contrato.PASS +" "+ TEXT_TYPE + ","
                    + Contrato.DESCRPICCION +" "+ TEXT_TYPE +")";

    public EmpleadorHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EMPLEADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertarRegistro (String Nombre, String Direccion, String Email, String Pass, String Descripccion){
        ContentValues values = new ContentValues();
        values.put(Contrato.NOMBRE,Nombre);
        values.put(Contrato.DIRRECCION,Direccion);
        values.put(Contrato.EMAIL,Email);
        values.put(Contrato.PASS,Pass);
        values.put(Contrato.DESCRPICCION,Descripccion);
        Long result = this.getWritableDatabase().insert(Contrato.TABLA, null,values);
        return  result != -1;
    }

    public void listarRegistros(){
        String[] projection = {Contrato._ID, Contrato.NOMBRE, Contrato.DIRRECCION, Contrato.EMAIL, Contrato.PASS, Contrato.DESCRPICCION};
        SQLiteDatabase  database = this.getReadableDatabase();
        Cursor cursor =  database.query(Contrato.TABLA, projection,null,null,null,null,null);
        while (cursor.moveToNext()){
            String nombre = cursor.getString(1);
            String dirrecion = cursor.getString(2);
            String email = cursor.getString(3);
            String pass = cursor.getString(4);
            String Descripccion = cursor.getString(5);
            Log.d("listarRegistros", "listarRegistros: " + nombre + dirrecion + email + pass + Descripccion);
        }
        cursor.close();
    }


    private class Contrato implements BaseColumns {
        static final String TABLA="Empleador";
        static final String NOMBRE="nombre";
        static final String DIRRECCION="direccion";
        static final String EMAIL="email";
        static final String PASS="pass";
        static final String DESCRPICCION="categoria";
    }
}
