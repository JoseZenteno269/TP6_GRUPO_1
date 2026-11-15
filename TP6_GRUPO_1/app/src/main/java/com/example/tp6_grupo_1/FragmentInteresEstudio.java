package com.example.tp6_grupo_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Entidad.Contacto;


public class FragmentInteresEstudio extends Fragment {

    private Contacto contacto;

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

        return view;
    }
}