import api.ColaPrioridadTDA;
import impl.ColaPrioridadEstatica;
import algoritmos.metodosColaPrioridad;


public class ejercicioColaPrioridad6 {
    public static void main(String[] args) throws Exception {
        ColaPrioridadTDA c1= new ColaPrioridadEstatica();
        c1.InicializacionCola();
        c1.AcoplarPrioridad(1, 4);
        c1.AcoplarPrioridad(2, 2);
        c1.AcoplarPrioridad(3, 1);
        metodosColaPrioridad.mostrarCola(c1);
        c1.DesAcoplar();
        metodosColaPrioridad.mostrarCola(c1);
    }
}
