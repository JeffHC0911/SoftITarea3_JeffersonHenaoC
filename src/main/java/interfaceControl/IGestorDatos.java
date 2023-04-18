package interfaceControl;

import java.util.List;

import model.Producto;
import model.Proveedor;



public interface IGestorDatos {
    
    List<Proveedor> cargarProveedoresJSON(String ruta1, String ruta2);

    List<Producto> cargarProductosJSON(String ruta1);

}
