package impl;

import api.ColaTDA;
import api.ListaPromediadaTDA;
import api.ColaPrioridadTDA;

public class ListaPromedioDinamica implements ListaPromediadaTDA {
    class Nodo {
        int info;
        Nodo sig;
    }
    // APUNTADORES DE LA LISTA
    Nodo primero;
    Nodo ultimo;

    // sacar el promedio
    int cantidad;
    int suma;


    public void InicializarListaPromediada(){
        primero=null;
        ultimo=null;
        cantidad=0;
        suma=0;

    }
    public void Agregar(int valor){
        Nodo aux=new Nodo();
        aux.info=valor;
        aux.sig=null;
        if (primero == null) {
            cantidad++;
            suma+=valor;
            ultimo=aux;
            primero=ultimo;
        }
        else if (aux.info > Promedio()) {
            cantidad++;
            suma+=valor;
            ultimo.sig=aux;
            ultimo=aux;
        }
        else if (aux.info < Promedio()) {
            cantidad++;
            suma+=valor;
            aux.sig=primero;
            primero=aux;
        }
    }
   // *
    @Override
    public void Eleminar(int valor) {
        int apariciones = contador(valor);
        int i = 0;
        while( i < apariciones){
            eliminar1(valor);
            i++;
        }
    }
    private void eliminar1(int valor){
        Nodo aux = primero;
        if(primero.info == valor){
            primero = primero.sig;
            
        }
        else{
            while(aux.sig.info != valor && aux != null){
                aux = aux.sig;
            }
            aux.sig = aux.sig.sig;
            
        }

    }
    private int contador(int valor){
        Nodo aux = primero;
        int cantidades = 0;
        while(aux != null){
            if (aux.info == valor){
                cantidades ++;

            }
            aux = aux.sig;
        }
        return cantidades;

    }
    //* 

    public double Promedio(){
        return (suma / cantidad);
    }

    public ColaTDA Menores(){
        ColaTDA ColaMenores = new ColaDinamica();
        ColaMenores.InicializarCola();
        ColaPrioridadTDA ColaAux=new ColaPrioridadDinamica();
        ColaAux.InicializacionCola();

     /// Metiendo los valores menores al promedio en una cola priodidad para ordenar 
        Nodo aux =new Nodo();
        aux=primero;
        while (aux != null) {
            if (aux.info < Promedio()) {
                ColaAux.Acolar(aux.info, aux.info);
            }
            aux=aux.sig;
        }
        // Lo pasamos a una cola normal
        while (!ColaAux.ColaVacia()) {
            ColaMenores.Acoplar(ColaAux.Primero());
            ColaAux.Desacolar();
        }
        return ColaMenores;
    }

    public ColaTDA Mayores(){
        ColaTDA ColaMayor = new ColaDinamica();
        ColaMayor.InicializarCola();
        ColaPrioridadTDA ColaAux=new ColaPrioridadDinamica();
        ColaAux.InicializacionCola();

     /// Metiendo los valores mayores al promedio en una cola priodidad para ordenar 
        Nodo aux =new Nodo();
        aux=primero;
        while (aux!= null) {
            if (aux.info > Promedio()) {
                ColaAux.Acolar(aux.info, -aux.info);
            }
            aux=aux.sig;
        }
        // Lo pasamos a una cola normal
        while (!ColaAux.ColaVacia()) {
            ColaMayor.Acoplar(ColaAux.Primero());
            ColaAux.Desacolar();
        }
        return ColaMayor;
    }
    public boolean EstaVacia(){
        return (primero == null);
    }

}
