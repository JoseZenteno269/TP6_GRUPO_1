package Datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Entidad.Contacto;

public class DAOContacto {
    private final DatosDBHelper datos;

    public DAOContacto(Context contexto) {
        this.datos = new DatosDBHelper(contexto);
    }

    public long insertar(Contacto contacto) {
        Objects.requireNonNull(contacto);

        LocalDate fechaNacimiento = contacto.getFechaNacimiento();
        ContentValues valores = new ContentValues();
        valores.put(DatosDBHelper.COLUMNA_NOMBRE, contacto.getNombre());
        valores.put(DatosDBHelper.COLUMNA_APELLIDO, contacto.getApellido());
        valores.put(DatosDBHelper.COLUMNA_TELEFONO, contacto.getTelefono());
        valores.put(DatosDBHelper.COLUMNA_TIPO_TELEFONO, contacto.getTipo_telefono());
        valores.put(DatosDBHelper.COLUMNA_EMAIL, contacto.getEmail());
        valores.put(DatosDBHelper.COLUMNA_TIPO_MAIL, contacto.getTipo_mail());
        valores.put(DatosDBHelper.COLUMNA_DIRECCION, contacto.getDireccion());
        valores.put(DatosDBHelper.COLUMNA_FECHA_NACIMIENTO, fechaNacimiento == null ? null : fechaNacimiento.toString());
        valores.put(DatosDBHelper.COLUMNA_ESTUDIOS, contacto.getEstudios());
        valores.put(DatosDBHelper.COLUMNA_INTERES, contacto.getInteres());
        valores.put(DatosDBHelper.COLUMNA_INFORMACION, contacto.getInformacion() ? 1 : 0);

        return datos.getWritableDatabase().insert(DatosDBHelper.TABLA_CONTACTOS, null, valores);
    }

    public ArrayList<Contacto> listado() {
        ArrayList<Contacto> lista = new ArrayList<>();

        SQLiteDatabase db = datos.getReadableDatabase();

        Cursor filas = db.rawQuery("SELECT * FROM " + DatosDBHelper.TABLA_CONTACTOS, null);

        if (filas.moveToFirst()) {
            do {
                Contacto c = new Contacto();
                c.setNombre(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_NOMBRE)));
                c.setApellido(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_APELLIDO)));
                c.setTelefono(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_TELEFONO)));
                c.setTipo_telefono(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_TIPO_TELEFONO)));
                c.setEmail(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_EMAIL)));
                c.setTipo_mail(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_TIPO_MAIL)));
                c.setDireccion(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_DIRECCION)));
                c.setFechaNacimiento(LocalDate.parse(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_FECHA_NACIMIENTO))));
                c.setEstudios(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_ESTUDIOS)));
                c.setInteres(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_INTERES)));
                c.setInformacion(Boolean.parseBoolean(filas.getString(filas.getColumnIndexOrThrow(DatosDBHelper.COLUMNA_INFORMACION))));

                lista.add(c);
            } while (filas.moveToNext());
        }

        filas.close();
        db.close();

        return lista;
    }
}
