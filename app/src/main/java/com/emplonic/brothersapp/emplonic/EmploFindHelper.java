package com.emplonic.brothersapp.emplonic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by usuario on 25/11/2016.
 */

public class EmploFindHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="EmploNic.db";
    private static final int DATABASE_VERSION=1;
    private static final String TEXT_TYPE="TEXT";
    private static final String INTEGER_TYPE="INTEGER";

    private static final String SQL_CREATE_EMPLOFIND=
            "CREATE TABLE " + Contrato.TABLA +
                    "(" + Contrato._ID +" "+ INTEGER_TYPE + " PRIMARY KEY ,"
                    + Contrato.NOMBRE +" "+ TEXT_TYPE + ","
                    + Contrato.APELLIDO +" "+ TEXT_TYPE + ","
                    + Contrato.SEXO +" "+ TEXT_TYPE + ","
                    + Contrato.EMAIL +" "+ TEXT_TYPE + ","
                    + Contrato.PASS +" "+ TEXT_TYPE + ","
                    + Contrato.DESEMPEÑA +" "+ TEXT_TYPE +  ","
                    + Contrato.DIRRECCION +" "+ TEXT_TYPE + ","
                    + Contrato.PROFECCION +" "+ TEXT_TYPE +")";

    public EmploFindHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EMPLOFIND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertarRegistro (String Nombre, String Apellido, String Sexo, String Email, String Pass, String Desempeña, String Direccion, String Profeccion){
        ContentValues values = new ContentValues();
        values.put(Contrato.NOMBRE,Nombre);
        values.put(Contrato.APELLIDO,Apellido);
        values.put(Contrato.SEXO,Sexo);
        values.put(Contrato.EMAIL,Email);
        values.put(Contrato.PASS,Pass);
        values.put(Contrato.DESEMPEÑA,Desempeña);
        values.put(Contrato.DIRRECCION,Direccion);
        values.put(Contrato.PROFECCION,Profeccion);

        Long result = this.getWritableDatabase().insert(Contrato.TABLA, null,values);

        return  result != -1;
    }

    public void listarRegistros(){
        String[] projection = {Contrato._ID, Contrato.NOMBRE,Contrato.APELLIDO,Contrato.SEXO,Contrato.EMAIL,Contrato.PASS,Contrato.DESEMPEÑA,Contrato.DIRRECCION,Contrato.PROFECCION };
        SQLiteDatabase  database = this.getReadableDatabase();
        Cursor cursor =  database.query(Contrato.TABLA, projection,null,null,null,null, null);
        while (cursor.moveToNext()){
            String nombre = cursor.getString(1);
            String apelledio = cursor.getString(2);
            String sexo = cursor.getString(3);
            String email = cursor.getString(4);
            String pass = cursor.getString(5);
            String desempeña = cursor.getString(6);
            String dirrecion = cursor.getString(7);
            String profeccion = cursor.getString(8);
            Log.d("listarRegistros", "listarRegistros: " + nombre + apelledio +sexo + email + pass + desempeña + dirrecion + profeccion );
        }
        cursor.close();
    }

    private class Contrato implements BaseColumns {

        static final String NOMBRE="nombre";
        static final String APELLIDO="apellido";
        static final String SEXO="sexo";
        static final String EMAIL="email";
        static final String PASS="pass";
        static final String DESEMPEÑA="desempeña";
        static final String DIRRECCION="direccion";
        static final String PROFECCION="profeccion";
        static final String TABLA="EmploFind";
    }

}
