package interfaceControl;

import model.Producto;
import model.Proveedor;

public interface ICalcularPrecio {
    
    double calculaPrecio(Producto producto, Proveedor proveedor);
}
