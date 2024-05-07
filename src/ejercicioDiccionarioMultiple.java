import api.DiccionarioMultipleTDA;
import impl.DiccionarioMultipleEstatico;
import impl.DiccionarioMultipleDinamico;

import api.ConjuntoTDA;
import impl.ConjuntosDinamico;

public class ejercicioDiccionarioMultiple {
    public static void main(String[] args) throws Exception {
        DiccionarioMultipleTDA d1 = new DiccionarioMultipleEstatico();
        d1.InicializarDiccionario();
        d1.Agregar(34, 1); 
        d1.Agregar(34, 2); 
        d1.Agregar(34, 3); 
        d1.Agregar(34, 4); 
        d1.Agregar(34, 1); 
        d1.EliminarValor(34,4);
        d1.Agregar(78, 1);
        d1.Agregar(78, 2);
        d1.Eliminar(78);
        ConjuntoTDA d138=d1.Recuperar(34);
        ConjuntoTDA totalClave=d1.Claves();
    }

}
