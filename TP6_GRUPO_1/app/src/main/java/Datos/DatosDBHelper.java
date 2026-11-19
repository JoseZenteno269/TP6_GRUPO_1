package Datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DatosDBHelper extends SQLiteOpenHelper {
    private static final String BASE_DE_DATOS = "contactos.db";
    private static final int VERSION = 1;

    static final String TABLA_CONTACTOS = "contactos";
    static final String COLUMNA_ID = "_id";
    static final String COLUMNA_NOMBRE = "nombre";
    static final String COLUMNA_APELLIDO = "apellido";
    static final String COLUMNA_TELEFONO = "telefono";
    static final String COLUMNA_TIPO_TELEFONO = "tipo_telefono";
    static final String COLUMNA_EMAIL = "email";
    static final String COLUMNA_TIPO_MAIL = "tipo_mail";
    static final String COLUMNA_DIRECCION = "direccion";
    static final String COLUMNA_FECHA_NACIMIENTO = "fecha_nacimiento"; // ISO-8601 date
    static final String COLUMNA_ESTUDIOS = "estudios";
    static final String COLUMNA_INTERES = "interes"; // JSON array of interest labels
    static final String COLUMNA_INFORMACION = "informacion";

    private static final String CREAR_CONTACTOS = "CREATE TABLE " + TABLA_CONTACTOS + " ("
            + COLUMNA_ID + " INTEGER PRIMARY KEY, "
            + COLUMNA_NOMBRE + " TEXT NOT NULL, "
            + COLUMNA_APELLIDO + " TEXT NOT NULL, "
            + COLUMNA_TELEFONO + " TEXT NOT NULL, "
            + COLUMNA_TIPO_TELEFONO + " TEXT NOT NULL, "
            + COLUMNA_EMAIL + " TEXT NOT NULL, "
            + COLUMNA_TIPO_MAIL + " TEXT NOT NULL, "
            + COLUMNA_DIRECCION + " TEXT NOT NULL, "
            + COLUMNA_FECHA_NACIMIENTO + " TEXT NOT NULL, "
            + COLUMNA_ESTUDIOS + " TEXT NOT NULL, "
            + COLUMNA_INTERES + " TEXT NOT NULL, "
            + COLUMNA_INFORMACION + " INTEGER NOT NULL DEFAULT 0 CHECK ("
            + COLUMNA_INFORMACION + " IN (0, 1)))";

    public DatosDBHelper(Context context) {
        super(context, BASE_DE_DATOS, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_CONTACTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        throw new SQLiteException("Falta la migración de la base de datos de la versión " + oldVersion
                + " a la versión " + newVersion);
    }
}
