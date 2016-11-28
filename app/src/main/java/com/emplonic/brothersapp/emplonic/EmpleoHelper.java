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

public class EmpleoHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="EmploNic.db";
    private static final int DATABASE_VERSION=4;
    private static final String TEXT_TYPE="TEXT";
    private static final String INTEGER_TYPE="INTEGER";

    private static final String SQL_CREATE_EMPLEO=
            "CREATE TABLE " + Contrato.TABLA +
                    "(" + Contrato._ID +" "+ INTEGER_TYPE + " PRIMARY KEY ,"
                    + Contrato.NOMBRE +" "+ TEXT_TYPE + ","
                    + Contrato.EMPLEO +" "+ TEXT_TYPE + ","
                    + Contrato.TIPOCONTRATO +" "+ TEXT_TYPE + ","
                    + Contrato.DIRRECION +" "+ TEXT_TYPE + ","
                    + Contrato.SUELDO +" "+ TEXT_TYPE + ","
                    + Contrato.REQUISITOS +" "+ TEXT_TYPE +")";

    public EmpleoHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EMPLEO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertarRegistro (String Nombre, String Empleo, String tipocontrato, String Direccion, String Sueldo, String Requisitos){
        ContentValues values = new ContentValues();
        values.put(Contrato.NOMBRE,Nombre);
        values.put(Contrato.EMPLEO,Empleo);
        values.put(Contrato.TIPOCONTRATO,tipocontrato);
        values.put(Contrato.DIRRECION,Direccion);
        values.put(Contrato.SUELDO,Sueldo);
        values.put(Contrato.REQUISITOS,Requisitos);
        Long result = this.getWritableDatabase().insert(Contrato.TABLA, null,values);
        return  result != -1;
    }

    public void listarRegistros(){
        String[] projection = {Contrato._ID, Contrato.NOMBRE, Contrato.EMPLEO, Contrato.TIPOCONTRATO, Contrato.DIRRECION, Contrato.SUELDO, Contrato.REQUISITOS};
        SQLiteDatabase  database = this.getReadableDatabase();
        Cursor cursor =  database.query(Contrato.TABLA, projection,null,null,null,null,null);
        while (cursor.moveToNext()){
            String nombre = cursor.getString(1);
            String empleo = cursor.getString(2);
            String tipocontrato = cursor.getString(3);
            String dirrecion = cursor.getString(4);
            String sueldo = cursor.getString(5);
            String requisitos = cursor.getString(6);
            Log.d("listarRegistros", "listarRegistros: " + nombre + empleo + tipocontrato + dirrecion + sueldo +requisitos);
        }
        cursor.close();
    }

    private class Contrato implements BaseColumns {
        static final String TABLA="Empleo";
        static final String NOMBRE="nombre";
        static final String EMPLEO="empleo";
        static final String TIPOCONTRATO="tipocontrato";
        static final String DIRRECION="direccion";
        static final String SUELDO="sueldo";
        static final String REQUISITOS="requisitos";

    }

}
