package algoritmos;
import api.ColaPrioridadTDA;
import impl.ColaPrioridadDinamica;


public class metodosColaPrioridad {
    public static void mostrarCola(ColaPrioridadTDA cola){
        ColaPrioridadTDA aux = new ColaPrioridadDinamica() ;
        aux.InicializacionCola();
        while (!cola.ColaVacia()){
            System.out.println(cola.Primero()+"-"+cola.Prioridad());
            aux.Acolar(cola.Primero(), cola.Prioridad());
            cola.Desacolar();
        }
        pasarCola(aux, cola);
    }

    public static void pasarCola(ColaPrioridadTDA cola1 , ColaPrioridadTDA cola2){
        while (!cola1.ColaVacia()) {
            cola2.Acolar(cola1.Primero(), cola1.Prioridad());
            cola1.Desacolar();
        }
    }

    public static void copiarColaProridad(ColaPrioridadTDA cola1,ColaPrioridadTDA cola2){
        ColaPrioridadTDA aux = new ColaPrioridadDinamica();
        aux.InicializacionCola();
        pasarCola(cola1 ,aux);
        while (!aux.ColaVacia()) {
            cola1.Acolar(aux.Primero(),aux.Prioridad());
            cola2.Acolar(aux.Primero(),aux.Prioridad());
            aux.Desacolar();;
        }
    }

    public static void combinarPrioridad(ColaPrioridadTDA cola1 , ColaPrioridadTDA cola2){
        ColaPrioridadTDA cola3 = new ColaPrioridadDinamica();
        cola3.InicializacionCola();
        ColaPrioridadTDA aux1 = new ColaPrioridadDinamica();
        aux1.InicializacionCola();
        ColaPrioridadTDA aux2 = new ColaPrioridadDinamica();
        aux2.InicializacionCola();
        copiarColaProridad(cola1, aux1);
        copiarColaProridad(cola2, aux2);
        while (!aux1.ColaVacia()) {
            cola3.Acolar(aux1.Primero(), aux1.Prioridad());
            aux1.Desacolar();
        }
        while (!aux2.ColaVacia()) {
            cola3.Acolar(aux2.Primero(), aux2.Prioridad());
            aux2.Desacolar();
        }
        mostrarCola(cola3);
    }
    public static boolean compararCola(ColaPrioridadTDA cola1 , ColaPrioridadTDA cola2){
        ColaPrioridadTDA aux1 = new ColaPrioridadDinamica();
        aux1.InicializacionCola();
        ColaPrioridadTDA aux2 = new ColaPrioridadDinamica();
        aux2.InicializacionCola();
        copiarColaProridad(cola1, aux1);
        copiarColaProridad(cola2, aux2);
        while (!aux1.ColaVacia()) {
            if (aux1.ColaVacia()==true && aux2.ColaVacia() == false || aux2.ColaVacia()==true && aux1.ColaVacia()==false) {
                return false;
            }
            if (aux1.Primero() != aux2.Primero() || aux1.Prioridad() != aux2.Prioridad()) {
                return false;
            }
            aux1.Desacolar();
            aux2.Desacolar();
        }
        return true;
    }
}