package algoritmos;

import java.util.ArrayList;

import api.ColaTDA;
import api.ConjuntoTDA;
import impl.ColaDinamica;
import impl.ConjuntosDinamico;
import api.PilaTDA;
import impl.PilaDinamica;

// CREAR METODO DE PASA UNA COLA A PILA PARA NO REPETIR CODIGO

public class metodosCola {

    public static ArrayList<ColaTDA> partirMitadCola(ColaTDA c1){ // ! no carga las cola1 y cola2
        ArrayList<ColaTDA> colasPartidas= new ArrayList<>();
        ColaTDA cola1 = new ColaDinamica();
        cola1.InicializarCola();

        ColaTDA cola2 = new ColaDinamica();
        cola1.InicializarCola();

        ColaTDA colaAux = new ColaDinamica();
        colaAux.InicializarCola();
        copiarCola(c1, colaAux);

        ColaTDA colaAux1 = new ColaDinamica();
        colaAux.InicializarCola();
        copiarCola(c1, colaAux1);
        int i=0;
        while (!colaAux1.ColaVacia()) {
            i++;
            colaAux1.DesAcoplar();
        }
        if (i % 2 == 0) {
            int vueltas=i / 2;
            int a=vueltas;
            while (a != 0) {
                cola1.Acoplar(colaAux.Primero());
                colaAux.DesAcoplar();
                a--;
            }
            int b=vueltas;
            while (b !=0) {
                cola1.Acoplar(colaAux.Primero());
                colaAux.DesAcoplar();
                b--;
            }
            colasPartidas.add(cola1);
            colasPartidas.add(cola2);
        }
        return colasPartidas;
    }

    public static ConjuntoTDA numeroRepetidos(ColaTDA c1){
        ConjuntoTDA numeroCola =new ConjuntosDinamico();
        numeroCola.InicializarConjunto();

        ConjuntoTDA numeroColaRepetidos =new ConjuntosDinamico();
        numeroColaRepetidos.InicializarConjunto();

        ColaTDA colaAux = new ColaDinamica();
        colaAux.InicializarCola();
        copiarCola(c1, colaAux);
        while (!colaAux.ColaVacia()) {
            if (numeroCola.Pertenece(colaAux.Primero())) {
                numeroColaRepetidos.Agregar(colaAux.Primero());
            }
            numeroCola.Agregar(colaAux.Primero());
            colaAux.DesAcoplar();
        }
        return numeroColaRepetidos;
    }

    public static void eleminarRepeticiones(ColaTDA c1){
        ConjuntoTDA numeroCola =new ConjuntosDinamico();
        numeroCola.InicializarConjunto();
        ColaTDA colaAux = new ColaDinamica();
        colaAux.InicializarCola();
        while (!c1.ColaVacia()) {
            if (!numeroCola.Pertenece(c1.Primero())) {
                colaAux.Acoplar(c1.Primero());
                numeroCola.Agregar(c1.Primero());
            }
            c1.DesAcoplar();
        }
        pasarCola(colaAux, c1);
    }

    public static void pasarCola(ColaTDA cola1 , ColaTDA cola2){
        while (!cola2.ColaVacia()) {
            cola2.DesAcoplar();
        }
        while (!cola1.ColaVacia()) {
            cola2.Acoplar(cola1.Primero());
            cola1.DesAcoplar();
        }
    }

    public static void copiarCola(ColaTDA cola1 , ColaTDA cola2){
        while (!cola2.ColaVacia()) {
            cola2.DesAcoplar();
        }
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
    
    // ESTA MAL SIN NIGUNA ESTRUTURA DE DATOS , ES CON CURSIVIDIDAD
    public static void invertirColaSinPila(ColaTDA cola , int cantidad){
        int dato=cola.Primero();
        cola.DesAcoplar();
        cola.Acoplar(dato);
        if (cantidad != 0) { // que condicion debo poner?
            cantidad--;
            invertirColaSinPila(cola,cantidad);
        }
    } 
    public static boolean coincidenciaCola(ColaTDA cola1 , ColaTDA cola2){
        ColaTDA aux1=new ColaDinamica();
        ColaTDA aux2=new ColaDinamica();
        int ultimoValorCola1=0;
        int ultimoValorCola2=0;
        while (cola1.ColaVacia()!=true && cola2.ColaVacia()!=true) {
            System.out.print(cola1.ColaVacia()+"-"+cola2.ColaVacia()+"/");
            if (!cola1.ColaVacia()) { 
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
