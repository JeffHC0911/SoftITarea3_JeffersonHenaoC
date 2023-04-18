package model;

import java.util.List;

public class Proveedor {
    private String nombre;
    private double precioEnvio;
    private List<Producto> productos;

    public Proveedor(String nombre, double precioEnvio, List<Producto> productos) {
        this.nombre = nombre;
        this.precioEnvio = precioEnvio;
        this.productos = productos;
    }

    // getters y setters

    public String getNombre(){
        return this.nombre;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Proveedor [nombre=" + nombre +  "precioEnvio=" + precioEnvio
                + "]";
    }
}

