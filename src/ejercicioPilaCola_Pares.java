import api.PilaCola_ParesTDA;
import impl.PilaCola_ParesDinamica;


public class ejercicioPilaCola_Pares {
    public static void main(String[] args) {
        PilaCola_ParesTDA Pc1=new PilaCola_ParesDinamica();
        Pc1.Guardar(0);
        Pc1.Guardar(2);
        Pc1.Guardar(4);
        Pc1.Guardar(6);
        Pc1.Guardar(8);//5
        Pc1.Guardar(10);
        System.out.println("---------------------------");
        System.out.println(Pc1.Mostrar());
        System.out.println("---------------------------");
        Pc1.Guardar(12);
        Pc1.Guardar(14);
        Pc1.Guardar(16);
        Pc1.Guardar(18);//10
        Pc1.Guardar(20);
        Pc1.Guardar(22);
        System.out.println("---------------------------");
        System.out.println(Pc1.Mostrar());
        System.out.println("---------------------------");
        Pc1.Guardar(24);
        Pc1.Guardar(3);
        Pc1.Guardar(6);//15
        Pc1.Imprimir();
        System.out.println("---------------------------");
        Pc1.Sacar();
        Pc1.Sacar();
        Pc1.Sacar();
        Pc1.Sacar();
        Pc1.Sacar();//5
        Pc1.Sacar();
        Pc1.Sacar();
        Pc1.Sacar();
        Pc1.Sacar();
        Pc1.Sacar();//10
        Pc1.Guardar(0);
        Pc1.Guardar(2);
        Pc1.Guardar(4);
        Pc1.Guardar(6);
        Pc1.Guardar(8);
        Pc1.Guardar(10);
        Pc1.Imprimir();

    }
}
