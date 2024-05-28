import java.util.ArrayList;

import algoritmos.metodosCola;
import api.ColaTDA;
import api.ConjuntoTDA;
import impl.ColaDinamica;

public class ejercicioCola3y4 {
    public static void main(String[] args) {
        ColaTDA c1 =new ColaDinamica();
        c1.InicializarCola();
        ColaTDA c2 =new ColaDinamica();
        c2.InicializarCola();
        ColaTDA c3 =new ColaDinamica();
        c3.InicializarCola();

        c1.Acoplar(1);
        c1.Acoplar(2);
        c1.Acoplar(3);

        c3.Acoplar(3);
        c3.Acoplar(2);
        c3.Acoplar(1);
        metodosCola.pasarCola(c1, c3);
        metodosCola.mostrarCola(c1);
        metodosCola.mostrarCola(c3);
        System.out.println("---------------");
        metodosCola.pasarCola(c1,c2);
        metodosCola.copiarCola(c2, c3);
        
        System.out.println("---------------");
        metodosCola.invertirColaConPila(c2);
        metodosCola.mostrarCola(c2);
        System.out.println("---------------");
        System.out.println("El ultimo valor de las dos colas es;"+metodosCola.coincidenciaCola(c2,c3)); 
        System.out.println("Orden inverso de las dos colas es;"+metodosCola.inversoColaComparar(c2, c3));
        System.out.println("Estado capicura de la cola es;"+metodosCola.capicuraCola(c3));

        
        //metodosCola.invertirColaSinPila(c2,3); // esta mal es con recursivididad
        System.out.println(c2);

        System.out.println("---------------");
        ColaTDA c4=new ColaDinamica();
        c4.InicializarCola();

        c4.Acoplar(1);
        c4.Acoplar(2);
        c4.Acoplar(3);
        c4.Acoplar(4);
        ArrayList<ColaTDA> colasPartidas=metodosCola.partirMitadCola(c4);
        metodosCola.mostrarCola(colasPartidas.get(0));
        System.out.println("---------------");
        metodosCola.mostrarCola(colasPartidas.get(1));

        ConjuntoTDA conjuntoRepetido=metodosCola.numeroRepetidos(c4);
        System.out.println("---------------");
        metodosCola.eleminarRepeticiones(c4);
        metodosCola.mostrarCola(c4);
    }

}
