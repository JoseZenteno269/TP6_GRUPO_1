package com.example.tp6_grupo_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import Entidad.Tipo;

public class FragmentDatosPersonales extends Fragment {

    private EditText txtNombre, txtApellido, txtTelefono, txtMail, txtDireccion, txtFechaNacimiento;
    private Spinner spinnerTelefono, spinnerMail;
    private Button btnContinuar;
    public FragmentDatosPersonales() {

    }
    public static FragmentDatosPersonales newInstance(String param1, String param2) {
        FragmentDatosPersonales fragment = new FragmentDatosPersonales();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_datos_personales, container, false);

        txtNombre = view.findViewById(R.id.txt_nombre);
        txtApellido = view.findViewById(R.id.txt_apellido);
        txtTelefono = view.findViewById(R.id.txt_telefono);
        txtMail = view.findViewById(R.id.txt_mail);
        txtDireccion = view.findViewById(R.id.txt_direccion);
        txtFechaNacimiento = view.findViewById(R.id.txt_fecha_nacimiento);
        spinnerTelefono = view.findViewById(R.id.spinner_telefono);
        spinnerMail = view.findViewById(R.id.spinner_mail);
        btnContinuar = view.findViewById(R.id.btn_continuar);

        listaTipos = new ArrayList<>();
        listaTipos.add(new Tipo("Casa"));
        listaTipos.add(new Tipo("Trabajo"));
        listaTipos.add(new Tipo("Móvil"));

        ArrayAdapter<Tipo> adapterTelefono = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_item, listaTipos);
        adapterTelefono.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTelefono.setAdapter(adapterTelefono);

        ArrayAdapter<Tipo> adapterMail = new ArrayAdapter<>(
                requireContext(), android.R.layout.simple_spinner_item, listaTipos);
        adapterMail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMail.setAdapter(adapterMail);

        return view;
    }
}