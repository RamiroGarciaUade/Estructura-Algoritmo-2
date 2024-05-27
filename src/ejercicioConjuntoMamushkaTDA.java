import api.ConjuntoMamushkaTDA;
import impl.ConjuntoMamushkaDinamico;
public class ejercicioConjuntoMamushkaTDA {
    public static void main(String[] args) {
        ConjuntoMamushkaTDA c1 = new ConjuntoMamushkaDinamico();
        c1.InicializarConjuntoMamushkaTDA();
        c1.Guardar(1);
        c1.Guardar(2);
        c1.Guardar(2);
        c1.Guardar(3);
        c1.Guardar(4);
        c1.Guardar(5);
        c1.Guardar(6);
        System.out.println("Cantidad de 1:"+c1.perteneceCanti(1));
        System.out.println("Cantidad de 2:"+c1.perteneceCanti(2));
        System.out.println("Cantidad de 6:"+c1.perteneceCanti(6));
        c1.Sacar(1);
        System.out.println("Cantidad de 1:"+c1.perteneceCanti(1));
        System.out.println("numero del conjunto;"+c1.Elegir());
        System.out.println("numero del conjunto;"+c1.Elegir());
        System.out.println("numero del conjunto;"+c1.Elegir());
        System.out.println("numero del conjunto;"+c1.Elegir());
    }
}
