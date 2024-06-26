package impl;

import api.ColaTDA;

public class ColaDinamica implements ColaTDA {
    Nodo primero;
    Nodo ultimo;

    class Nodo {
        int info;
        Nodo sig; // Es un puntero que apunta  direccion de memoria del nodo que esta apuntarando
    }

    public void InicializarCola(){
        primero = null;
        ultimo = null;
    }

    public void Acoplar(int x){
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig =null;
        if (ultimo != null){
            ultimo.sig = aux;
        }
        ultimo = aux;
        if (primero == null) {
            primero = ultimo;
        }
    }

    public void DesAcoplar(){
        primero = primero.sig;
        if (primero == null) {
            ultimo = null;
        }
    }

    public boolean ColaVacia(){
        return (ultimo == null);
    }

    public int Primero(){
        return primero.info;
    }


    
}
