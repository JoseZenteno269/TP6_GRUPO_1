package com.example.tp6_grupo_1;

import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import Entidad.Contacto;


public class FragmentInteresEstudio extends Fragment {

    private Contacto contacto;

    private RadioGroup groupNivelesEstudio;
    private RadioButton rbPrimIncompleto, rbPrimCompleto, rbSecuIncompleto, rbSecuCompleto, rbOtros;
    private CheckBox cbDeporte, cbMusica, cbArte, cbTecnologia;
    private SwitchCompat swNotificacion;
    private Button btnGuardar;

    public FragmentInteresEstudio() {

    }

    public static FragmentInteresEstudio newInstance(String param1, String param2) {
        FragmentInteresEstudio fragment = new FragmentInteresEstudio();
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
        View view = inflater.inflate(R.layout.fragment_intereses_estudio, container, false);

        contacto = (Contacto) getArguments().getSerializable("contacto");

        groupNivelesEstudio = view.findViewById(R.id.Group_Niveles_Estudio);
        rbPrimIncompleto = view.findViewById(R.id.rb_PrimIncompleto);
        rbPrimCompleto = view.findViewById(R.id.rb_PrimCompleto);
        rbSecuIncompleto = view.findViewById(R.id.rb_SecuIncompleto);
        rbSecuCompleto = view.findViewById(R.id.rb_SecuCompleto);
        rbOtros = view.findViewById(R.id.rb_Otros);

        cbDeporte = view.findViewById(R.id.cb_Deporte);
        cbMusica = view.findViewById(R.id.cb_Musica);
        cbArte = view.findViewById(R.id.cb_Arte);
        cbTecnologia = view.findViewById(R.id.cb_Tecnologia);

        swNotificacion = view.findViewById(R.id.sw_Notificacion);
        btnGuardar = view.findViewById(R.id.btn_Guardar);

        return view;
    }
}