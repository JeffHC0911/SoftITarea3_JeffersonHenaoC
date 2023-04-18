package model;

public class Producto {
    private String nombre;
    private int edadRecomendada;
    private double precioBase;
    private String proveedor;

    public Producto(String nombre, int edadRecomendada, double precioBase, String proveedor) {
        this.nombre = nombre;
        this.edadRecomendada = edadRecomendada;
        this.precioBase = precioBase;
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getProveedor(){
        return this.proveedor;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", edadRecomendada=" + edadRecomendada + ", precioBase=" + precioBase
                + ", Proveedor=" + proveedor + " ]";
    }

}
