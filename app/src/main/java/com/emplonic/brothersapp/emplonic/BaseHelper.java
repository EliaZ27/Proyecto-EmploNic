package com.emplonic.brothersapp.emplonic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by usuario on 28/11/2016.
 */

public class BaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="EmploNic.db";
    private static final int DATABASE_VERSION=1;
    private static final String TEXT_TYPE="TEXT";
    private static final String INTEGER_TYPE="INTEGER";

    private static final String SQL_CREATE_EMPLOFIND=
            "CREATE TABLE " + ContratoEmplofind.TABLA +
                    "(" + ContratoEmplofind._ID +" "+ INTEGER_TYPE + " PRIMARY KEY ,"
                    + ContratoEmplofind.NOMBRE +" "+ TEXT_TYPE + ","
                    + ContratoEmplofind.APELLIDO +" "+ TEXT_TYPE + ","
                    + ContratoEmplofind.SEXO +" "+ TEXT_TYPE + ","
                    + ContratoEmplofind.EMAIL +" "+ TEXT_TYPE + ","
                    + ContratoEmplofind.PASS +" "+ TEXT_TYPE + ","
                    + ContratoEmplofind.DESEMPEÑA +" "+ TEXT_TYPE +  ","
                    +ContratoEmplofind.DIRRECCION +" "+ TEXT_TYPE + ","
                    + ContratoEmplofind.PROFECCION +" "+ TEXT_TYPE +")";

    private static final String SQL_CREATE_PYMES=
            "CREATE TABLE " + ContratoPymes.TABLA +
                    "(" + ContratoPymes._ID +" "+ INTEGER_TYPE + " PRIMARY KEY ,"
                    + ContratoPymes.NOMBRE +" "+ TEXT_TYPE + ","
                    + ContratoPymes.DIRRECCION +" "+ TEXT_TYPE + ","
                    + ContratoPymes.EMAIL +" "+ TEXT_TYPE + ","
                    + ContratoPymes.PASS +" "+ TEXT_TYPE + ","
                    + ContratoPymes.CATEGORIA +" "+ TEXT_TYPE +")";

    private static final String SQL_CREATE_EMPLEO=
            "CREATE TABLE " + ContratoEmpleo.TABLA +
                    "(" + ContratoEmpleo._ID +" "+ INTEGER_TYPE + " PRIMARY KEY ,"
                    + ContratoEmpleo.NOMBRE +" "+ TEXT_TYPE + ","
                    + ContratoEmpleo.EMPLEO +" "+ TEXT_TYPE + ","
                    + ContratoEmpleo.TIPOCONTRATO +" "+ TEXT_TYPE + ","
                    + ContratoEmpleo.DIRRECION +" "+ TEXT_TYPE + ","
                    + ContratoEmpleo.SUELDO +" "+ TEXT_TYPE + ","
                    + ContratoEmpleo.REQUISITOS +" "+ TEXT_TYPE +")";

    private static final String SQL_CREATE_EMPLEADOR=
            "CREATE TABLE " + ContratoEmpleador.TABLA +
                    "(" + ContratoEmpleador._ID +" "+ INTEGER_TYPE + " PRIMARY KEY ,"
                    + ContratoEmpleador.NOMBRE +" "+ TEXT_TYPE + ","
                    + ContratoEmpleador.DIRRECCION +" "+ TEXT_TYPE + ","
                    + ContratoEmpleador.EMAIL +" "+ TEXT_TYPE + ","
                    + ContratoEmpleador.PASS +" "+ TEXT_TYPE + ","
                    + ContratoEmpleador.DESCRPICCION +" "+ TEXT_TYPE +")";

    public BaseHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_EMPLOFIND);
        db.execSQL(SQL_CREATE_PYMES);
        db.execSQL(SQL_CREATE_EMPLEO);
        db.execSQL(SQL_CREATE_EMPLEADOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertarRegistroEmplofind (String Nombre, String Apellido, String Sexo, String Email, String Pass, String Desempeña, String Direccion, String Profeccion){
        ContentValues values = new ContentValues();
        values.put(ContratoEmplofind.NOMBRE,Nombre);
        values.put(ContratoEmplofind.APELLIDO,Apellido);
        values.put(ContratoEmplofind.SEXO,Sexo);
        values.put(ContratoEmplofind.EMAIL,Email);
        values.put(ContratoEmplofind.PASS,Pass);
        values.put(ContratoEmplofind.DESEMPEÑA,Desempeña);
        values.put(ContratoEmplofind.DIRRECCION,Direccion);
        values.put(ContratoEmplofind.PROFECCION,Profeccion);

        Long result = this.getWritableDatabase().insert(ContratoEmplofind.TABLA, null,values);

        return  result != -1;
    }

    public boolean insertarRegistroPymes (String Nombre, String Direccion, String Email, String Pass, String Categoria){
        ContentValues values = new ContentValues();
        values.put(ContratoPymes.NOMBRE,Nombre);
        values.put(ContratoPymes.DIRRECCION,Direccion);
        values.put(ContratoPymes.EMAIL,Email);
        values.put(ContratoPymes.PASS,Pass);
        values.put(ContratoPymes.CATEGORIA,Categoria);
        Long result = this.getWritableDatabase().insert(ContratoPymes.TABLA, null,values);
        return  result != -1;
    }

    public boolean insertarRegistroEmpleo (String Nombre, String Empleo, String tipocontrato, String Direccion, String Sueldo, String Requisitos){
        ContentValues values = new ContentValues();
        values.put(ContratoEmpleo.NOMBRE,Nombre);
        values.put(ContratoEmpleo.EMPLEO,Empleo);
        values.put(ContratoEmpleo.TIPOCONTRATO,tipocontrato);
        values.put(ContratoEmpleo.DIRRECION,Direccion);
        values.put(ContratoEmpleo.SUELDO,Sueldo);
        values.put(ContratoEmpleo.REQUISITOS,Requisitos);
        Long result = this.getWritableDatabase().insert(ContratoEmpleo.TABLA, null,values);
        return  result != -1;
    }

    public boolean insertarRegistroEmpleador (String Nombre, String Direccion, String Email, String Pass, String Descripccion){
        ContentValues values = new ContentValues();
        values.put(ContratoEmpleador.NOMBRE,Nombre);
        values.put(ContratoEmpleador.DIRRECCION,Direccion);
        values.put(ContratoEmpleador.EMAIL,Email);
        values.put(ContratoEmpleador.PASS,Pass);
        values.put(ContratoEmpleador.DESCRPICCION,Descripccion);
        Long result = this.getWritableDatabase().insert(ContratoEmpleador.TABLA, null,values);
        return  result != -1;
    }

    public void listarRegistrosEmplofind(){
        String[] projection = {ContratoEmplofind._ID, ContratoEmplofind.NOMBRE,ContratoEmplofind.APELLIDO,ContratoEmplofind.SEXO,ContratoEmplofind.EMAIL,ContratoEmplofind.PASS,ContratoEmplofind.DESEMPEÑA,ContratoEmplofind.DIRRECCION,ContratoEmplofind.PROFECCION };
        SQLiteDatabase  database = this.getReadableDatabase();
        Cursor cursor =  database.query(ContratoEmplofind.TABLA, projection,null,null,null,null, null);
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

    public void listarRegistrosPymes(){
        String[] projection = {ContratoPymes._ID, ContratoPymes.NOMBRE, ContratoPymes.DIRRECCION, ContratoPymes.EMAIL, ContratoPymes.PASS, ContratoPymes.CATEGORIA};
        SQLiteDatabase  database = this.getReadableDatabase();
        Cursor cursor =  database.query(ContratoPymes.TABLA, projection,null,null,null,null,null);
        while (cursor.moveToNext()){
            String nombre = cursor.getString(1);
            String dirrecion = cursor.getString(2);
            String email = cursor.getString(3);
            String pass = cursor.getString(4);
            String categoria = cursor.getString(5);
            Log.d("listarRegistros", "listarRegistros: " + nombre + dirrecion + email + pass + categoria);
        }
        cursor.close();
    }

    public void listarRegistrosEmpleo(){
        String[] projection = {ContratoEmpleo._ID, ContratoEmpleo.NOMBRE, ContratoEmpleo.EMPLEO, ContratoEmpleo.TIPOCONTRATO, ContratoEmpleo.DIRRECION, ContratoEmpleo.SUELDO, ContratoEmpleo.REQUISITOS};
        SQLiteDatabase  database = this.getReadableDatabase();
        Cursor cursor =  database.query(ContratoEmpleo.TABLA, projection,null,null,null,null,null);
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

    public void listarRegistrosEmpleador(){
        String[] projection = {ContratoEmpleador._ID, ContratoEmpleador.NOMBRE, ContratoEmpleador.DIRRECCION, ContratoEmpleador.EMAIL, ContratoEmpleador.PASS, ContratoEmpleador.DESCRPICCION};
        SQLiteDatabase  database = this.getReadableDatabase();
        Cursor cursor =  database.query(ContratoEmpleador.TABLA, projection,null,null,null,null,null);
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



    private class ContratoEmplofind implements BaseColumns {

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

    private class ContratoPymes implements BaseColumns {
        static final String TABLA="Pymes";
        static final String NOMBRE="nombre";
        static final String DIRRECCION="direccion";
        static final String EMAIL="email";
        static final String PASS="pass";
        static final String CATEGORIA="categoria";
    }

    private class ContratoEmpleo implements BaseColumns {
        static final String TABLA="Empleo";
        static final String NOMBRE="nombre";
        static final String EMPLEO="empleo";
        static final String TIPOCONTRATO="tipocontrato";
        static final String DIRRECION="direccion";
        static final String SUELDO="sueldo";
        static final String REQUISITOS="requisitos";

    }

    private class ContratoEmpleador implements BaseColumns {
        static final String TABLA="Empleador";
        static final String NOMBRE="nombre";
        static final String DIRRECCION="direccion";
        static final String EMAIL="email";
        static final String PASS="pass";
        static final String DESCRPICCION="categoria";
    }
}
