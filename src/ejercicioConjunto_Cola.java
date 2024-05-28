import api.Conjunto_ColaTDA;
import impl.Conjunto_ColaDinamico;

public class ejercicioConjunto_Cola {
    public static void main(String[] args) {
        Conjunto_ColaTDA c1 = new Conjunto_ColaDinamico();
        c1.inicializarConjunto_Cola();
        c1.agregar(1);
        c1.agregar(1);
        c1.agregar(2);
        c1.agregar(2);
        c1.agregar(3);
        c1.agregar(3);
        c1.agregar(4);
        c1.agregar(5);
        c1.agregar(6);
        c1.agregar(7);
        

        c1.eleminar(1);
        System.out.println(c1.pertenece(3));
        System.out.println(c1.mayor());
        System.out.println(c1.menor());
        System.out.println(c1.promedio());
    }
}
