package com.example.tp6_grupo_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Entidad.Contacto;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Detalle_Contacto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Detalle_Contacto extends Fragment {

    public Fragment_Detalle_Contacto() { }
    public static Fragment_Detalle_Contacto newInstance(String param1, String param2) {
        Fragment_Detalle_Contacto fragment = new Fragment_Detalle_Contacto();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    @SuppressWarnings("deprecation")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__detalle__contacto, container, false);

        Contacto contacto = (Contacto) getArguments().getSerializable("CONTACTO");

        SetTexto(view, R.id.txt_nombre, contacto.getNombre());
        SetTexto(view, R.id.txt_apellido, contacto.getApellido());
        SetTexto(view, R.id.txt_tipo_telefono, contacto.getTipo_telefono());
        SetTexto(view, R.id.txt_telefono, contacto.getTelefono());
        SetTexto(view, R.id.txt_tipo_mail, contacto.getTipo_mail());
        SetTexto(view, R.id.txt_mail, contacto.getEmail());
        SetTexto(view, R.id.txt_direccion, contacto.getDireccion());
        SetTexto(view, R.id.txt_fecha_nacimiento, contacto.getFechaNacimiento() == null ? "" : contacto.getFechaNacimiento().toString());
        SetTexto(view, R.id.txt_estudios, contacto.getEstudios());
        SetTexto(view, R.id.txt_Intereses, contacto.getInteres());
        SetTexto(view, R.id.txt_Info, contacto.getInformacion() ? "Si" : "No");

        return view;
    }

    private void SetTexto(View view, int IdTextView, String Texto)
    {
        TextView txt = view.findViewById(IdTextView);
        txt.setText(Texto);
    }
}
