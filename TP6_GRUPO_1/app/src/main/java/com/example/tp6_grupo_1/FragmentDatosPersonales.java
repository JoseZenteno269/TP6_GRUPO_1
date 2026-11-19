package com.example.tp6_grupo_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Entidad.Contacto;
import Entidad.Tipo;

public class FragmentDatosPersonales extends Fragment {

    private EditText txtNombre, txtApellido, txtTelefono, txtMail, txtDireccion, txtFechaNacimiento;
    private Spinner spinnerTelefono, spinnerMail;
    private TextView txvError;
    private ArrayList<Tipo> listaTipos;

    private Button btn_continuar;

    private RadioGroup radioGroup;

    private CheckBox chkDeporte;
    private CheckBox chkMusica;
    private CheckBox chkArte;
    private CheckBox chkTecnologia;
    private Switch Info;


    DateTimeFormatter formato;

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
        btn_continuar = view.findViewById(R.id.btn_continuar);

        listaTipos = new ArrayList<>();
        listaTipos.add(new Tipo("Casa"));
        listaTipos.add(new Tipo("Trabajo"));
        listaTipos.add(new Tipo("Móvil"));

        btn_continuar = view.findViewById(R.id.btn_continuar);

        ArrayAdapter<Tipo> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, listaTipos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerTelefono.setAdapter(adapter);
        spinnerMail.setAdapter(adapter);

        btn_continuar.setOnClickListener(v -> continuar());

        return view;
    }

    private boolean validaciones(){
        boolean estado = true;
        txtNombre.setError(null);
        txtApellido.setError(null);
        txtTelefono.setError(null);
        txtMail.setError(null);
        txtDireccion.setError(null);
        txtFechaNacimiento.setError(null);

        String nombre = txtNombre.getText().toString().trim();
        String apellido = txtApellido.getText().toString().trim();
        String telefono = txtTelefono.getText().toString().trim();
        String mail = txtMail.getText().toString().trim();
        String direccion = txtDireccion.getText().toString().trim();
        String fecha = txtFechaNacimiento.getText().toString().trim();

        if (nombre.isEmpty()){
            txtNombre.setError(getString(R.string.error_campo_requerido));
            estado = false;
        }
        else if(nombre.length() < 3){
            txtNombre.setError("Minimo de 3 caracteres");
            estado = false;
        }
        else if(!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")){
            txtNombre.setError("Solo se permiten letras");
            estado = false;
        }


        if (apellido.isEmpty()){
            txtApellido.setError(getString(R.string.error_campo_requerido));
            estado = false;
        }
        else if(apellido.length() < 3){
            txtApellido.setError("Minimo de 3 caracteres");
            estado = false;
        }
        else if(!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")){
            txtApellido.setError("Solo se permiten letras");
            estado = false;
        }


        if (telefono.isEmpty()){
            txtTelefono.setError(getString(R.string.error_campo_requerido));
            estado = false;
        }
        else if(!telefono.matches("[0-9-]+")){
            txtTelefono.setError("Solo numeros y guion");
            estado = false;
        }
        else if(telefono.replace("-", "").length() != 10){
            txtTelefono.setError("Debe de contener 10 digitos");
            estado = false;
        }

        if (mail.isEmpty()){
            txtMail.setError(getString(R.string.error_campo_requerido));
            estado = false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            txtMail.setError(getString(R.string.error_mail_invalido));
            estado = false;
        }

        if (direccion.isEmpty()){
            txtDireccion.setError(getString(R.string.error_campo_requerido));
            estado = false;
        }

        if (fecha.isEmpty()){
            txtFechaNacimiento.setError(getString(R.string.error_campo_requerido));
            estado = false;
        } else {
            formato = DateTimeFormatter
                    .ofPattern(getString(R.string.formato_fecha))
                    .withResolverStyle(ResolverStyle.STRICT);
            try {
                LocalDate fechaNac = LocalDate.parse(fecha, formato);
                if (fechaNac.isAfter(LocalDate.now())){
                    txtFechaNacimiento.setError(getString(R.string.error_fecha_futura));
                    estado = false;
                }
            } catch (DateTimeParseException e) {
                txtFechaNacimiento.setError(getString(R.string.error_fecha_formato));
                estado = false;
            }
        }

        return estado;
    }

    public void continuar() {
        if(!validaciones()){
            return;
        }

        Contacto contacto = new Contacto();
        contacto.setNombre(txtNombre.getText().toString().trim());
        contacto.setApellido(txtApellido.getText().toString().trim());
        contacto.setTelefono(txtTelefono.getText().toString().trim());
        contacto.setTipo_telefono(spinnerTelefono.getSelectedItem().toString().trim());
        contacto.setEmail(txtMail.getText().toString().trim());
        contacto.setTipo_mail(spinnerMail.getSelectedItem().toString().trim());
        contacto.setDireccion(txtDireccion.getText().toString().trim());
        contacto.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText().toString().trim(), formato));

        Bundle datos = new Bundle();
        datos.putSerializable("contacto", contacto);

        FragmentInteresEstudio fragment2 = new FragmentInteresEstudio();
        fragment2.setArguments(datos);

        getParentFragmentManager().beginTransaction().replace(R.id.main, fragment2).addToBackStack(null).commit();
    }


    private boolean ValidarIntereses()
    {
        boolean Estado = true;

        int IdSeleccionado = radioGroup.getCheckedRadioButtonId();

        if(IdSeleccionado == -1)
        {
            Toast.makeText(requireContext(), "Debe Seleccionar una opcion", Toast.LENGTH_LONG).show();
            Estado = false;
        }

        if(!chkDeporte.isChecked() && chkArte.isChecked() && chkMusica.isChecked() && chkTecnologia.isChecked())
        {
            Toast.makeText(requireContext(), "Debe Seleccionar una Opcion", Toast.LENGTH_LONG).show();
            Estado = false;
        }

        return Estado;
    }

    public void Guardar(View view) {


        if(!ValidarIntereses())
        {
            return;
        }

        Contacto contacto = new Contacto();
        List<String> Intereses = new ArrayList<>();

        chkDeporte = view.findViewById(R.id.cb_Deporte);
        chkMusica = view.findViewById(R.id.cb_Musica);
        chkArte = view.findViewById(R.id.cb_Arte);
        chkTecnologia = view.findViewById(R.id.cb_Tecnologia);
        radioGroup = view.findViewById(R.id.Group_Niveles_Estudio);
        Info = view.findViewById(R.id.sw_Notificacion);

        Info.setOnCheckedChangeListener((buttonView, isChecked) -> {

            if(isChecked)
            {
                Info.setText("Si");
            }
            else
            {
                Info.setText("No");
            }

            Intereses.add(Info.getText().toString());

        });

        if(chkDeporte.isChecked())
        {
            Intereses.add(chkDeporte.getText().toString());
        }
        if(chkArte.isChecked())
        {
            Intereses.add(chkArte.getText().toString());
        }
        if(chkMusica.isChecked())
        {
            Intereses.add(chkMusica.getText().toString());
        }
        if(chkTecnologia.isChecked())
        {
            Intereses.add(chkTecnologia.getText().toString());
        }

        int IdSeleccionado = radioGroup.getCheckedRadioButtonId();

        if(IdSeleccionado != -1)
        {
            RadioButton RB = view.findViewById(IdSeleccionado);
            Intereses.add(RB.getText().toString());
        }

        contacto.setInteres(Intereses);

    }
}