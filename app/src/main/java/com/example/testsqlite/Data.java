package com.example.testsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testsqlite.Helpers.DBHelper;
import com.example.testsqlite.POJOs.Usuario;

public class Data {

    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    private SQLiteOpenHelper sqLiteOpenHelper;

    public Data(Context context) {
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        sqLiteOpenHelper.close();
    }

    public void insertUsuario(Usuario usuario){
        ContentValues values = usuario.toValues();
        sqLiteDatabase.insert(SQLConstants.tableUsuarios,null,values);
    }

    public Usuario getUsuario(String id){
        Usuario usuario = new Usuario();
        String[] whereArgs = new String[]{id};
        Cursor cursor = sqLiteDatabase.query(SQLConstants.tableUsuarios,
                SQLConstants.ALL_COLUMNS,
                SQLConstants.SEARCH_BY_ID,
                whereArgs,
                null,null,null);

        while (cursor.moveToNext()){

            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                usuario.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
                usuario.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
                usuario.setEdad(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_EDAD)));
                usuario.setCorreo(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_CORREO)));
            }
        }
        return usuario;
    }

    public void deleteUser(String id){
        String[] whereArgs = new String[] {String.valueOf(id)};
        sqLiteDatabase.delete(
                SQLConstants.tableUsuarios,
                SQLConstants.WHEREID_CLAUSE,
                whereArgs);
    }

    public void updateUser(String id, ContentValues contentValues){
        String[] whereArgs = new String[] {String.valueOf(id)};
        sqLiteDatabase.update(
                SQLConstants.tableUsuarios,
                contentValues,
                SQLConstants.SEARCH_BY_ID,
                whereArgs);


    }
}
