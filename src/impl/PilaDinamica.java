package impl;

import api.PilaTDA;

public class PilaDinamica implements PilaTDA {
    // Los no primitivo indicas sola memroria 
    Nodo primero;                                   /*Que seria Nodo? unja clase o un nodo*/

    class Nodo {
        int info ;  // informacion
        Nodo sig ;  // direccion del anterior
    }

    public void InicializarPila () {
        primero = null ;
    }
    public void Apilar( int x){
        Nodo aux = new Nodo(); // new Nodo( ) Creas Nodo aux es tipo de dato nodo
        aux.info = x;
        aux.sig = primero; //Le asigna info y sig (la direccion del nodo de primero) 
        primero = aux ;
    }
    public void Desapilar() {
        primero = primero.sig ;
    }
    public boolean PilaVacia (){
        return ( primero == null ) ;
    }
    public int Tope () {
    return primero.info ;
    }
}
