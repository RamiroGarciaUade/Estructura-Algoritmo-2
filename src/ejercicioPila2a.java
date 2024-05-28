import api.PilaTDA;
import impl.PilaDinamica;
import algoritmos.metodosPila;

public class ejercicioPila2a {
    public static void main(String[] args) throws Exception {
        PilaTDA p1 = new PilaDinamica();
        p1.InicializarPila();

        p1.Apilar(1);
        p1.Apilar(2);
        p1.Apilar(3);
        p1.Apilar(4);

        PilaTDA p2 = new PilaDinamica();
        p2.InicializarPila();

        PilaTDA p3 = new PilaDinamica();
        p3.InicializarPila();

        metodosPila.pasarPila(p1,p2);
        metodosPila.mostrarPila(p2);
        System.out.println("---------------");
        metodosPila.invertirPilaOtraPila(p2, p3);
        metodosPila.mostrarPila(p3);
        System.out.println("---------------");
        metodosPila.invertirOrdeDelaPila(p3);
        metodosPila.mostrarPila(p3);
        System.out.println("---------------");
        int TotalElementos= metodosPila.contarElementoPila(p3);
        System.out.println("Total de elementos en la pila;"+TotalElementos );
        int SumaTotalElementos= metodosPila.sumarTotalElementosPila(p3);
        System.out.println("Suma total de elementos en la pila;"+SumaTotalElementos);
        float PromedioTotalElementos = metodosPila.promedioTotalPila(p3);
        System.out.println("El promedio total de los elementos en la pila;"+PromedioTotalElementos);

        System.out.println("---------------");
        PilaTDA p4 = new PilaDinamica();
        p1.InicializarPila();

        p4.Apilar(1);
        p4.Apilar(2);
        p4.Apilar(2);
        p4.Apilar(3);
        p4.Apilar(3);
        p4.Apilar(4);
        p4.Apilar(4);
        metodosPila.eleminarRepeticiones(p4);
        metodosPila.mostrarPila(p4);
    }
}
