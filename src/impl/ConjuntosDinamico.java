package impl;

import api.ConjuntoTDA;

public class ConjuntosDinamico implements ConjuntoTDA {
    Nodo primero;
    int cantidad;

    class Nodo{
        int info ;
        Nodo sig;
    }

    
    public void InicializarConjunto() {
        primero = null;
        cantidad=0;
    }
    public void Agregar(int x) { ///
        if (!Pertenece(x)) {
            Nodo aux = new Nodo();
            aux.info=x;
            aux.sig=primero;
            primero=aux;
            cantidad++;
        }
    }
    public  void Sacar(int x) {
        if (primero != null){
            if (primero.info==x) {
                primero=primero.sig;
            }
            else{
                Nodo recorrer= new Nodo();
                recorrer=primero;
                while (recorrer.sig !=null && recorrer.sig.info != x) {
                    recorrer = recorrer.sig;
                }
                if (recorrer.sig !=null){
                    recorrer.sig=recorrer.sig.sig; // el siguente nodo con el valor es aplastado por el nodo que lo esta apuntando
                }
            }
        }
    }
    public boolean ConjuntoVacion() {
        return (primero==null);
    }
    public boolean Pertenece(int x) {
        Nodo recorrer=primero;
        while (recorrer != null && recorrer.info != x) {
            recorrer = recorrer.sig;
        }
        return (recorrer != null);
    }
    
    public  int Elegir() { // no elige Nodo sino el numero entre cantidad
        int numero = (int) (Math.random() * cantidad) + 1 % cantidad;
        return numero;
    }
}
