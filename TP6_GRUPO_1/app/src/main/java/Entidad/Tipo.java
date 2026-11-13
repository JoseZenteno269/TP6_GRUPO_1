package Entidad;

public class Tipo {

    private String descripcion;

    public Tipo()
    {
        ///Constructor Vacio
    }

    public Tipo(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
