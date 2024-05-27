package impl;
import api.ConjuntoMamushkaTDA;

public class ConjuntoMamushkaDinamico implements ConjuntoMamushkaTDA {
    class Nodo{
        int info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    public void InicializarConjuntoMamushkaTDA() {
        primero=null;
        ultimo=null;
    }
    public void Guardar(int x){
        Nodo aux = new Nodo();
        aux.info=x;
        aux.sig=null;
        if (primero != null) {
            ultimo.sig=aux;
            ultimo=aux;
        }
        else {
            ultimo=aux;
            primero=ultimo;
        }
    }
    public void Sacar(int x){
        if (perteneceCanti(x) != 0) {
            if (primero.info == x) {
                primero=primero.sig;
            }
            else{
                Nodo aux =new Nodo();
                aux=primero;
                while (aux != null && aux.sig.info != x) {
                    aux=aux.sig;
                }
                if (aux.sig.info==x) {
                    aux.sig=aux.sig.sig;
                }
            }
        }
    }
    public int Elegir(){
        Nodo aux =new Nodo();
        aux=primero;
        int cantidadElementoConjunto=0;
        while (aux != null) {
            cantidadElementoConjunto++;
            aux=aux.sig;
        }
        int parar=(int) (Math.random() * cantidadElementoConjunto) + 1 % cantidadElementoConjunto;
        Nodo aux1 =new Nodo();
        aux1=primero;
        while (aux1 != null && parar > 0 && parar < cantidadElementoConjunto) {
            parar--;
            aux1=aux1.sig;
        }
        if (aux1 != null) {
            return aux1.info;
        }
        return primero.info;
    }
    public int perteneceCanti(int x){
        int cantidadElemento=0;
        if (primero != null) {
            Nodo aux =new Nodo();
            aux=primero;
            while (aux != null) {
                if (aux.info == x) {
                    cantidadElemento++;
                }
                aux=aux.sig;
            }
        }
        return cantidadElemento;
    }
    public boolean estaVacia(){
        return (primero == null);
    }
}
