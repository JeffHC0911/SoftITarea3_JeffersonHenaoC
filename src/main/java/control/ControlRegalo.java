package control;

import java.util.ArrayList;
import java.util.List;

import interfaceControl.IBuscarRegalo;
import interfaceControl.ICalcularPrecio;
import io.GestorArchivos;
import model.Producto;
import model.Proveedor;
import model.Regalo;

public class ControlRegalo implements IBuscarRegalo, ICalcularPrecio {

    private List<Producto> productos;
    private List<Proveedor> proveedores;
    private List<Regalo> regalos;

    public ControlRegalo() {
        this.productos = new ArrayList<>();
        this.proveedores = new ArrayList<>();
        this.regalos = new ArrayList<>();
    }

    /**
     * Permite llamar a los métodos de cargar proveedores en formato JSON y cargar productos en formato JSON.
     */
    public void cargarDatos() {
        GestorArchivos gestorArchivos = new GestorArchivos();
        this.proveedores = gestorArchivos.cargarProveedoresJSON(
                "E:\\ESTUDIO 2023\\2023-1\\Software I\\Tareas\\Tarea3\\appregalo\\src\\main\\java\\data\\proveedores.json",
                "E:\\ESTUDIO 2023\\2023-1\\Software I\\Tareas\\Tarea3\\appregalo\\src\\main\\java\\data\\productos.json");
        this.productos = gestorArchivos.cargarProductosJSON(
                "E:\\ESTUDIO 2023\\2023-1\\Software I\\Tareas\\Tarea3\\appregalo\\src\\main\\java\\data\\productos.json");
    }

    /**
     * Permite mostrar la lista de regalos que cumplen con las condiciones dadas.
     * Si la lista de regalos es vacía, se muestra un mensaje donde se valida que no se tienen
     * productos para esa edad o precio dado.
     */
    public void mostrarRegalos() {
        if(regalos.isEmpty()){
            System.out.println("No se tiene productos para esa edad o precio");
        }
        for (Regalo r : regalos) {
            System.out.println(r.toString());
        }
    }

    @Override
    /**
     * Calcula el precio total sumando el precio base del producto con el precio de envio dado por el proveedor
     */
    public double calculaPrecio(Producto producto, Proveedor proveedor) {
        return producto.getPrecioBase() + proveedor.getPrecioEnvio();
    }

    @Override
    /**
     * Permite buscar los regalos dada una edad y un presupuesto.
     * Recorre una lista de productos donde e filtra si la edad es igual a la recomendada.
     * Luego se recorre la lista de proveedores donde se obtiene el precio total, luego se verifica
     * que el proveedor del producto sea igual al nombre del proveedor y por último verificar que el precio total sea menor
     * o igual al presupuesto dado por el usuario. Por ultimo se agregan los regalos a una lista y creando el objeto regalo 
     * para al final ser retornados.
     */
    public List<Regalo> buscarRegalo(int edad, double presupuesto) {
        for (Producto producto : productos) {
            if (edad == producto.getEdadRecomendada()) {
                for (Proveedor proveedor : proveedores) {
                    double precioTotal = calculaPrecio(producto, proveedor);
                    if (producto.getProveedor().equalsIgnoreCase(proveedor.getNombre())) {
                        if (precioTotal <= presupuesto) {
                            regalos.add(new Regalo(producto.getNombre(), producto.getPrecioBase(),
                                    proveedor.getPrecioEnvio(), precioTotal));
                        }
                    }
                }
            }
        }

        return regalos;
    }

    public static void main(String[] args) {
        ControlRegalo controlRegalo = new ControlRegalo();
        controlRegalo.cargarDatos();

        //Prueba 1
        int edad = 5;
        double presupuesto = 90000;

        //Prueba 2
        // int edad = 7;
        // double presupuesto = 50000;

        //Prueba 3
        // int edad = 8;
        // double presupuesto = 50000;

        controlRegalo.buscarRegalo(edad, presupuesto);
        System.out.println("-------------------------------");
        System.out.println("Edad: " + edad);
        System.out.println("Precio máximo: " + presupuesto);
        controlRegalo.mostrarRegalos();
        System.out.println("-------------------------------");


    }

}
