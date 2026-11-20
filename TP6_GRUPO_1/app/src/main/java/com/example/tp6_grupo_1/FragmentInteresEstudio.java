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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Entidad.Contacto;
import Negocio.NegocioContacto;


public class FragmentInteresEstudio extends Fragment {

    private Contacto contacto;
    private NegocioContacto negocioContacto;
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

        negocioContacto = new NegocioContacto(requireContext());

        cbDeporte = view.findViewById(R.id.cb_Deporte);
        cbMusica = view.findViewById(R.id.cb_Musica);
        cbArte = view.findViewById(R.id.cb_Arte);
        cbTecnologia = view.findViewById(R.id.cb_Tecnologia);

        swNotificacion = view.findViewById(R.id.sw_Notificacion);
        btnGuardar = view.findViewById(R.id.btn_Guardar);
        btnGuardar.setOnClickListener(v -> Guardar());

        swNotificacion.setText(swNotificacion.isChecked() ? "Si" : "No");
        swNotificacion.setOnCheckedChangeListener((buttonView, isChecked) -> swNotificacion.setText(isChecked ? "Si" : "No"));

        return view;
    }

    private boolean ValidarIntereses()
    {
        boolean Estado = true;

        int IdSeleccionado = groupNivelesEstudio.getCheckedRadioButtonId();

        if(IdSeleccionado == -1)
        {
            Toast.makeText(requireContext(), "Debe Seleccionar una opcion", Toast.LENGTH_LONG).show();
            Estado = false;
        }

        if(!cbDeporte.isChecked() && !cbArte.isChecked() && !cbMusica.isChecked() && !cbTecnologia.isChecked())
        {
            Toast.makeText(requireContext(), "Debe Seleccionar una Opcion", Toast.LENGTH_LONG).show();
            Estado = false;
        }

        return Estado;
    }

    public void Guardar() {

        if(!ValidarIntereses())
        {
            return;
        }

        ArrayList<String> lista = new ArrayList<>();
        if (cbDeporte.isChecked())    lista.add(cbDeporte.getText().toString());
        if (cbArte.isChecked())       lista.add(cbArte.getText().toString());
        if (cbMusica.isChecked())     lista.add(cbMusica.getText().toString());
        if (cbTecnologia.isChecked()) lista.add(cbTecnologia.getText().toString());
        contacto.setInteres(String.join(", ", lista));


        RadioButton rbSeleccionado = requireView().findViewById(groupNivelesEstudio.getCheckedRadioButtonId());
        contacto.setEstudios(rbSeleccionado.getText().toString());

        contacto.setInformacion(swNotificacion.isChecked());

        if (negocioContacto.agregar(contacto)) {
            Toast.makeText(getContext(), "Contacto guardado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Error al guardar", Toast.LENGTH_SHORT).show();
        }
    }
}