import algoritmos.metodosCola;
import api.ColaTDA;
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

        metodosCola.pasarCola(c1,c2);
        metodosCola.mostrarCola(c2);
        System.out.println("---------------");
        metodosCola.invertirColaConPila(c2);
        metodosCola.mostrarCola(c2);
        System.out.println("---------------");
        System.out.println("El ultimo valor de las dos colas es;"+metodosCola.coincidenciaCola(c2,c3)); 
        System.out.println("Orden inverso de las dos colas es;"+metodosCola.inversoColaComparar(c2, c3));
        System.out.println("Estado capicura de la cola es;"+metodosCola.capicuraCola(c3));

        
        metodosCola.invertirColaSinPila(c2,3);
        System.out.println(c2);
    }

}
