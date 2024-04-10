package algoritmos;

import api.ColaTDA;
import impl.ColaDinamica;

import api.PilaTDA;
import impl.PilaDinamica;

// CREAR METODO DE PASA UNA COLA A PILA PARA NO REPETIR CODIGO

public class metodosCola {
    public static void pasarCola(ColaTDA cola1 , ColaTDA cola2){
        while (!cola1.ColaVacia()) {
            cola2.Acoplar(cola1.Primero());
            cola1.DesAcoplar();
        }
    }

    public static void copiarCola(ColaTDA cola1 , ColaTDA cola2){
        ColaTDA aux = new ColaDinamica();
        aux.InicializarCola();
        pasarCola(cola1 ,aux);
        while (!aux.ColaVacia()) {
            cola1.Acoplar(aux.Primero());
            cola2.Acoplar(aux.Primero());
            aux.DesAcoplar();
        }
    }
    public static void invertirColaConPila(ColaTDA cola){
        PilaTDA aux = new PilaDinamica();
        aux.InicializarPila();
        while (!cola.ColaVacia()) {
            aux.Apilar(cola.Primero());
            cola.DesAcoplar();
        }
        while (!aux.PilaVacia()) {
            cola.Acoplar(aux.Tope());
            aux.Desapilar();
        }
    }
    //ACAAAAAAAAAA/
    public static void invertirColaSinPila(ColaTDA cola){
        int [] lista=new int[20];
        int indice=0;
        while (!cola.ColaVacia()) {
            lista[indice]=cola.Primero();
            indice++;
            cola.DesAcoplar();
        }
        for (int i=indice; i >= 0; i--){
            cola.Acoplar(lista[i]);
        }
    } 
    public static boolean coincidenciaCola(ColaTDA cola1 , ColaTDA cola2){
        ColaTDA aux1=new ColaDinamica();
        ColaTDA aux2=new ColaDinamica();
        int ultimoValorCola1=0;
        int ultimoValorCola2=0;
        while (cola1.ColaVacia()!=true && cola2.ColaVacia()!=true) {
            System.out.print(cola1.ColaVacia()+"-"+cola2.ColaVacia()+"/");
            if (!cola1.ColaVacia()) { //problema con cola1 
                aux1.Acoplar(cola1.Primero());
                ultimoValorCola1=cola1.Primero();
                cola1.DesAcoplar();
            } 
            if (!cola2.ColaVacia()) {
                aux2.Acoplar(cola2.Primero());
                ultimoValorCola2=cola2.Primero();
                cola2.DesAcoplar();
            } 
        }
        pasarCola(aux1,cola1);
        pasarCola(aux2,cola2);
        System.out.println(ultimoValorCola1+"-"+ultimoValorCola2);
        if (ultimoValorCola1 == ultimoValorCola2) {
            return true;
        }
        return false;
    }
    public static boolean capicuraCola(ColaTDA cola1){
        ColaTDA aux1=new ColaDinamica();
        PilaTDA aux2=new PilaDinamica();
        ColaTDA aux3=new ColaDinamica();
        copiarCola(cola1, aux1);
        copiarCola(aux1, aux3);
        while (!aux1.ColaVacia()) {
            aux2.Apilar(aux1.Primero());
            aux1.DesAcoplar();
        }
        while (!aux3.ColaVacia()) {
            if (aux3.Primero()!=aux2.Tope()) {
                return false;
            }
            aux2.Desapilar();
            aux3.DesAcoplar();
        }
        return true;
    }

    public static boolean inversoColaComparar(ColaTDA cola1 , ColaTDA cola2){
        ColaTDA aux1=new ColaDinamica();
        ColaTDA aux2=new ColaDinamica();
        PilaTDA aux3=new PilaDinamica();
        copiarCola(cola1, aux1);
        copiarCola(cola2, aux2);
        while (!aux1.ColaVacia()) {
            aux3.Apilar(aux1.Primero());
            aux1.DesAcoplar();
        }
        metodosPila.invertirOrdeDelaPila(aux3);
        while (!aux2.ColaVacia()) {
            if (aux2.Primero()!=aux3.Tope()) {
                return false;
            }
            aux2.DesAcoplar();
            aux3.Desapilar();
        }
        return true;
    }

    public static void mostrarCola(ColaTDA cola){
        ColaTDA aux = new ColaDinamica();
        aux.InicializarCola();
        while (!cola.ColaVacia()){
            System.out.println(cola.Primero());
            aux.Acoplar(cola.Primero());
            cola.DesAcoplar();
        }
        pasarCola(aux, cola);
    }
}
