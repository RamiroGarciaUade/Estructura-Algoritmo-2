import api.ConjuntoTDA;
import impl.ConjuntosEstatico;
import impl.ColaDinamica;
import impl.ConjuntosDinamico;

public class ejercicioConjunto3y6 {
    public static void main(String[] args) throws Exception {
        ConjuntoTDA c1= new ConjuntosEstatico();
        c1.Sacar(6);
        c1.InicializarConjunto();
        c1.Agregar(1);
        c1.Agregar(2);
        c1.Agregar(3);
        c1.Agregar(4);
        System.out.println(c1.Elegir()+"-"+c1.Elegir());
        c1.Sacar(6);
        c1.Sacar(3);
        System.out.println("2 pertenece?:"+c1.Pertenece(2)+"-7 pertenece?"+c1.Pertenece(7));
        System.out.println(c1.Elegir()+"-"+c1.Elegir());
        ConjuntoTDA c2 = new ConjuntosDinamico();
        c2.Sacar(6);
        c2.InicializarConjunto();
        c2.Agregar(1);
        c2.Agregar(2);
        c2.Agregar(3);
        c2.Agregar(4);
        System.out.println(c2.Elegir()+"-"+c2.Elegir());
        c2.Sacar(6);
        c2.Sacar(3);
        System.out.println("2 pertenece?:"+c2.Pertenece(2)+"-7 pertenece?"+c2.Pertenece(7));
        System.out.println(c2.Elegir()+"-"+c2.Elegir());
        
    }
}
