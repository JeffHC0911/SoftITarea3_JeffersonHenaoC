package model;



public class Regalo {
    private String nombre;
    private double precioBase;
    private double precioEnvio;
    private double precioTotal;

    public Regalo(String nombre, double precioBase, double precioEnvio, double precioTotal) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.precioTotal = precioTotal;
        this.precioEnvio = precioEnvio;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioEnvo(){
        return this.precioEnvio;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    @Override
    public String toString() {
        return nombre + " - precio base: " + precioBase + " - precio envio: " + precioEnvio
                + " - precio total: " + precioTotal ;
    }

    }


