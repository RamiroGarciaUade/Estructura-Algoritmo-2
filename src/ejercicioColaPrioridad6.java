import api.ColaPrioridadTDA;
import impl.ColaPrioridadDinamica;
import impl.ColaPrioridadEstatica;
import algoritmos.metodosColaPrioridad;


public class ejercicioColaPrioridad6 {
    
    public static void main(String[] args) throws Exception {
        ColaPrioridadTDA c1= new ColaPrioridadEstatica();
        c1.InicializacionCola(); // es un vector que tiene en 20 indice con valor 0
        c1.Acolar(1, 10);
        c1.Acolar(2, 5);
        c1.Acolar(3, 15);
        metodosColaPrioridad.mostrarCola(c1);
        ColaPrioridadTDA c2= new ColaPrioridadDinamica();
        c2.InicializacionCola();
        //System.out.println(c2.Primero()+"-"+c2.Prioridad()); ESTABAS PREGUNTANDO A LA NADA
        c2.Acolar(1, 10);
        c2.Acolar(2, 5);
        c2.Acolar(3, 15);
        metodosColaPrioridad.mostrarCola(c2);
        System.out.println(metodosColaPrioridad.compararCola(c2,c1));
        System.out.println("-----------------");
        ColaPrioridadTDA c3= new ColaPrioridadEstatica();
        c3.InicializacionCola();
        c3.Acolar(4, 15);
        c3.Acolar(5, 1);
        c3.Acolar(6, 10);
        metodosColaPrioridad.mostrarCola(c3);
        System.out.println("-----------------");
        metodosColaPrioridad.combinarPrioridad(c1, c3);
    }
}
