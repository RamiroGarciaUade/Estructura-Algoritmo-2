import api.ConjuntoTDA;

import api.DiccionarioTDA;
import impl.DiccionarioSimpleEstatica;
import impl.DiccionarioSimpleDinamica;


public class ejercicioDiccionarioSimple {
    public static void main(String[] args) throws Exception {
        DiccionarioTDA d1 = new DiccionarioSimpleEstatica();
        d1.InicializarDiccionario();
        d1.Agregar(10, 1);
        d1.Agregar(15, 2);
        d1.Agregar(20, 3);
        d1.Eleminar(20);
        System.out.println("Valor de la clave 20:"+d1.Recuperar(15));
        ConjuntoTDA ClavesD1=d1.Claves();
        System.out.println("---------------");
        DiccionarioTDA d2 = new DiccionarioSimpleDinamica();
        d2.Agregar(45, 1);
        d2.Agregar(78, 2);
        d2.Agregar(89, 3);
        d2.Eleminar(78);
        System.out.println("Valor de la clave 45:"+d2.Recuperar(45));
        ConjuntoTDA ClaveD2 = d2.Claves();
    }

}
