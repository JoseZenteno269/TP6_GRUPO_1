package Datos;

import android.content.ContentValues;
import android.content.Context;

import org.json.JSONArray;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import Entidad.Contacto;

public class DAOContacto {
    private final Context contexto;

    public DAOContacto(Context contexto) {
        this.contexto = contexto;
    }

    public long insertar(Contacto contacto) {
        Objects.requireNonNull(contacto);

        LocalDate fechaNacimiento = contacto.getFechaNacimiento();
        List<String> intereses = contacto.getInteres();
        ContentValues valores = new ContentValues();
        valores.put(DatosDBHelper.COLUMNA_NOMBRE, contacto.getNombre());
        valores.put(DatosDBHelper.COLUMNA_APELLIDO, contacto.getApellido());
        valores.put(DatosDBHelper.COLUMNA_TELEFONO, contacto.getTelefono());
        valores.put(DatosDBHelper.COLUMNA_TIPO_TELEFONO, contacto.getTipo_telefono());
        valores.put(DatosDBHelper.COLUMNA_EMAIL, contacto.getEmail());
        valores.put(DatosDBHelper.COLUMNA_TIPO_MAIL, contacto.getTipo_mail());
        valores.put(DatosDBHelper.COLUMNA_DIRECCION, contacto.getDireccion());
        valores.put(DatosDBHelper.COLUMNA_FECHA_NACIMIENTO,
                fechaNacimiento == null ? null : fechaNacimiento.toString());
        valores.put(DatosDBHelper.COLUMNA_ESTUDIOS, contacto.getEstudios());
        valores.put(DatosDBHelper.COLUMNA_INTERES,
                intereses == null ? null : new JSONArray(intereses).toString());
        valores.put(DatosDBHelper.COLUMNA_INFORMACION, contacto.isInformacion() ? 1 : 0);

        try (DatosDBHelper helper = new DatosDBHelper(contexto)) {
            return helper.getWritableDatabase().insert(DatosDBHelper.TABLA_CONTACTOS, null, valores);
        }
    }
}
