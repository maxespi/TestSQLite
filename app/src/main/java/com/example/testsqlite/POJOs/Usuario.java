package com.example.testsqlite.POJOs;

import android.content.ContentValues;

import com.example.testsqlite.SQLConstants;

public class Usuario {

    private String id;
    private String nombre;
    private int edad;
    private String correo;

    public Usuario() {

    }

    public Usuario(String id, String nombre, Integer edad, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(4);
        contentValues.put(SQLConstants.COLUMN_ID,id);
        contentValues.put(SQLConstants.COLUMN_NOMBRE,nombre);
        contentValues.put(SQLConstants.COLUMN_EDAD,edad);
        contentValues.put(SQLConstants.COLUMN_CORREO,correo);
        return contentValues;
    }

}
