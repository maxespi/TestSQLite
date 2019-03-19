package com.example.testsqlite;

public class SQLConstants {

    public static final String DB = "bdusuarios.db";

    public static final String tableUsuarios = "usuarios";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_EDAD = "edad";
    public static final String COLUMN_CORREO = "correo";

    public static final String SQL_CREATE_TABLE_USUARIOS =
            "CREATE TABLE "+ tableUsuarios + "(" +
                    COLUMN_ID + " TEXT PRIMARY KEY," +
                    COLUMN_NOMBRE + " TEXT," +
                    COLUMN_EDAD + " INT," +
                    COLUMN_CORREO + " TEXT" + ");";

    public static final String SEARCH_BY_ID = "id=?";
    public static final String WHEREID_CLAUSE = "id=?";


    public static final String SQL_DELETE =
            "DROP TABLE " + tableUsuarios;

    public static final String[] ALL_COLUMNS = {COLUMN_ID,COLUMN_NOMBRE,COLUMN_EDAD,COLUMN_CORREO};
}
