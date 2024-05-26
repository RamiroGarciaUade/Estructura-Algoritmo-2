package impl;

import api.PilaCola_ParesTDA;

public class PilaCola_ParesDinamica implements PilaCola_ParesTDA{
    class Nodo{
        int info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    int cantidadPares;

    // Si es mayor 10 n par es pila y si es menor es cola
    public void Inicializar(){
        primero=null;
        ultimo=null;
        cantidadPares=0;
    }
    public void Guardar(int x){
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig =null;
        if (Par(x)) {
            cantidadPares++;
        }
        if (cantidadPares > 10) {
            if (primero == null) { // si esta vacio
                ultimo = aux;
                primero=ultimo;
            }
            else{ // si no 
                aux.sig = primero; //Le asigna info y sig (la direccion del nodo de primero) 
                primero = aux ;
            }
        }
        else{
            if (ultimo != null){ // si hay elemento
                ultimo.sig = aux;
            }
            ultimo = aux; 
            if (primero == null) { // si no hay elemento
                primero = ultimo;
            }
        }
    }
    public void Sacar(){// desacolar o despilar 
        if (Par(primero.info)) {
            cantidadPares--;
        }
        if (cantidadPares > 10) {
            primero=primero.sig;
        }
        else{
            primero = primero.sig;
            if (primero == null) {
                ultimo = null;
            }
        }
    }
    public int Mostrar(){
        if (cantidadPares > 10) {
            return primero.info;
        }
        return ultimo.info ; 
        
    }
    public boolean EstaVacia(){
        return (primero == null);
    }
    public void Imprimir(){
        Nodo aux=new Nodo();
        aux=primero;
        while (aux.sig != null) {
            System.out.println(aux.info);
            aux=aux.sig;
        }
        System.out.println(aux.info);
    }

    private boolean Par(int x){
        return(x % 2 == 0);
    }
}
