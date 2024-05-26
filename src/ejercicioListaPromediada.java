import algoritmos.metodosCola;
import api.ColaTDA;
import impl.ColaDinamica;
import algoritmos.metodosCola;


import api.ListaPromediadaTDA;
import impl.ListaPromedioDinamica;
import algoritmos.metodosListaPromedio;



public class ejercicioListaPromediada {
    public static void main(String[] args) throws Exception {
        ListaPromediadaTDA l1 = new ListaPromedioDinamica();
        l1.InicializarListaPromediada();

        l1.Agregar(10);
        l1.Agregar(15);
        l1.Agregar(20);
        l1.Agregar(17);
        l1.Agregar(20);
        System.out.println(l1.Promedio());


        ColaTDA c3 =l1.Menores();
        metodosCola.mostrarCola(c3);
        System.out.println("---------------");
        l1.Eleminar(20);

        ColaTDA c1 =l1.Menores();
        ColaTDA c2 =l1.Mayores();

        metodosCola.mostrarCola(c1);
        System.out.println("---------------");
        metodosCola.mostrarCola(c2);
    }
}
