package Negocio;

import android.content.Context;
import Datos.DAOContacto;
import Entidad.Contacto;

public class NegocioContacto {

    private final DAOContacto dao;

    public NegocioContacto(Context contexto) {
        dao = new DAOContacto(contexto);
    }

    public boolean agregar(Contacto contacto) {

        if (contacto == null) {
            return false;
        }

        return dao.insertar(contacto) != -1;
    }
}