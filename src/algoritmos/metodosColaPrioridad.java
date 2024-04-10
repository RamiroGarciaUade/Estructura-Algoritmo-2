package algoritmos;
import api.ColaPrioridadTDA;
import impl.ColaPrioridadEstatica;

public class metodosColaPrioridad {
    public static void mostrarCola(ColaPrioridadTDA cola){
        ColaPrioridadTDA aux = new ColaPrioridadEstatica();
        aux.InicializacionCola();
        aux = cola;
        while (!cola.ColaVacia()){
            System.out.println(cola.Primero()+"-"+cola.Prioridad());
            cola.DesAcoplar();
        }
        cola=aux;
    }
}