package interfaceControl;

import java.util.List;

import model.Regalo;

public interface IBuscarRegalo {
    
    List<Regalo> buscarRegalo(int edad, double presupuesto);
}
