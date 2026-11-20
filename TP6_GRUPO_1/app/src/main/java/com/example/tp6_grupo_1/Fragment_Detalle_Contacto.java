package com.example.tp6_grupo_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment__detalle__contacto, container, false);
    }

    private void SetTexto(View view, int IdTextView, String Texto)
    {
        TextView txt = view.findViewById(IdTextView);
        txt.setText(Texto);
    }
}
