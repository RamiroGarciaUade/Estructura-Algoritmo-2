package algoritmos;

import api.PilaTDA;
import impl.PilaDinamica;

import api.ConjuntoTDA;
import impl.ConjuntosDinamico;

public class metodosPila {
    public static void eleminarRepeticiones(PilaTDA p1){
        ConjuntoTDA numeroPila =new ConjuntosDinamico();
        numeroPila.InicializarConjunto();
        PilaTDA pilaAux=new PilaDinamica();
        pilaAux.InicializarPila();
        while (!p1.PilaVacia()) {
            if (!numeroPila.Pertenece(p1.Tope())) {
                pilaAux.Apilar(p1.Tope());
                numeroPila.Agregar(p1.Tope());
            }
            p1.Desapilar();
        }
        pasarPila(pilaAux , p1);
        invertirOrdeDelaPila(p1);
    }


    public static void pasarPila (PilaTDA p1 , PilaTDA p2) { //El tope es el inicio de p2/
        while (!p1.PilaVacia()) {
            p2.Apilar(p1.Tope());
            p1.Desapilar();
        }
    }

    public static void copiarPila(PilaTDA p1 , PilaTDA p2) {
        // copiar en el mismo orden
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();

        pasarPila(p1, aux);

        while (!aux.PilaVacia()) {
            p1.Apilar(aux.Tope());
            p2.Apilar(aux.Tope());
            aux.Desapilar();
        }
    }

    public static void invertirPilaOtraPila(PilaTDA p1 , PilaTDA p2){
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        while (!p1.PilaVacia()) {
            aux.Apilar(p1.Tope());
            p1.Desapilar();
        }
        copiarPila(aux,p2);
    }

    public static void invertirOrdeDelaPila(PilaTDA pila){
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        while (!pila.PilaVacia()) {
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }
        copiarPila(aux,pila);
    }
                      ///
    public static int contarElementoPila(PilaTDA pila){
        int contador =0;
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        copiarPila(pila, aux);
        while (!aux.PilaVacia()) {
            aux.Desapilar();
            contador++;
        }
        return contador;
    }

    public static int sumarTotalElementosPila(PilaTDA pila){
        int suma=0;
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        copiarPila(pila, aux);

        while (!aux.PilaVacia()) {
            suma+=aux.Tope();
            aux.Desapilar();
        }
        return suma;
    }

    public static float promedioTotalPila(PilaTDA pila){
        float promedioTotal;
        int suma=0;
        int elementos=0;
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        copiarPila(pila, aux);

        while (!aux.PilaVacia()) {
            suma+=aux.Tope();
            elementos++;
            aux.Desapilar();
        }
        promedioTotal= suma / elementos ;
        return promedioTotal;
    }

    public static void mostrarPila(PilaTDA pila){ 
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        while (!pila.PilaVacia()){
            System.out.println(pila.Tope());
            aux.Apilar(pila.Tope());
            pila.Desapilar();
        }
        pasarPila(aux ,pila);
    } 
}
