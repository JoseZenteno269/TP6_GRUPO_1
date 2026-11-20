package Entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contacto implements Serializable {

    public Contacto()
    {
        ///Constructor Vacio
    }
    private String nombre;
    private String apellido;
    private String telefono;
    private String tipo_telefono;
    private String email;
    private String tipo_mail;
    private String direccion;
    private LocalDate fechaNacimiento;
    private String estudios;
    private String interes;
    private boolean informacion;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipo_telefono() {
        return tipo_telefono;
    }

    public void setTipo_telefono(String tipo_telefono) {
        this.tipo_telefono = tipo_telefono;
    }

    public String getTipo_mail() {
        return tipo_mail;
    }

    public void setTipo_mail(String tipo_mail) {
        this.tipo_mail = tipo_mail;
    }

    public String getEstudios() {
        return estudios;
    }

    public void setEstudios(String estudios) {
        this.estudios = estudios;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public boolean getInformacion() {
        return informacion;
    }

    public void setInformacion(boolean informacion) {
        this.informacion = informacion;
    }
}
