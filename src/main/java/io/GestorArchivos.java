package io;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import interfaceControl.IGestorDatos;
import model.Producto;
import model.Proveedor;

public class GestorArchivos implements IGestorDatos {

    
    @Override
    public List<Producto> cargarProductosJSON(String rutaArchivo) {
        List<Producto> productos = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(rutaArchivo))) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String nombre = jsonObject.get("nombre").getAsString();
                int edadRecomendada = jsonObject.get("edad").getAsInt();
                double precioBase = jsonObject.get("precio").getAsDouble();
                String proveedor = jsonObject.get("proveedor").getAsString();
                productos.add(new Producto(nombre, edadRecomendada, precioBase, proveedor));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + rutaArchivo);
            e.printStackTrace();
        }
        return productos;
    }
    
    @Override
    public List<Proveedor> cargarProveedoresJSON(String rutaArchivoProveedores, String rutaArchivoProductos) {
        List<Producto> productos = cargarProductosJSON(rutaArchivoProductos);
        List<Proveedor> proveedores = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(rutaArchivoProveedores))) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            for (JsonElement jsonElement : jsonArray) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String nombre = jsonObject.get("nombre").getAsString();
                double precioEnvio = jsonObject.get("precioEnvio").getAsDouble();
                List<Producto> productosProveedor = new ArrayList<>();
                for (Producto p : productos) {
                    if (p.getProveedor().equals(nombre)) {
                        productosProveedor.add(p);
                    }
                }
                proveedores.add(new Proveedor(nombre, precioEnvio, productosProveedor));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + rutaArchivoProveedores);
            e.printStackTrace();
        }
        return proveedores;
    }

}

