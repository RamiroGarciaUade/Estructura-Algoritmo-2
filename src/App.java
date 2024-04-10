//PILA
import api.PilaTDA;
import impl.PilaEstatica;
import impl.PilaDinamica;
//COLAS
import api.ColaTDA;
import impl.ColaEstatica;

public class App {
    public static void main(String[] args) throws Exception {
        PilaTDA p1= new PilaEstatica();
        PilaTDA p2=new PilaDinamica();

        p1.InicializarPila();
        p2.InicializarPila();

        p1.Apilar(1);
        System.out.print(p1.Tope()+"-");
        p1.Apilar(2);
        p1.Apilar(2);
        p1.Apilar(3);
        System.out.print(p1.Tope()+"-");

        p2.Apilar(2);
        System.out.print("/"+p2.Tope()+"-");
        p2.Apilar(3);
        System.out.print(p2.Tope()+"-");
        p2.Apilar(4);
        System.out.print(p2.Tope()+"-");
        p2.Desapilar();
        System.out.print(p2.Tope()+"-");

    }
}
