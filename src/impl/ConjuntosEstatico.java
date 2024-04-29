package impl;

import api.ConjuntoTDA;

public class ConjuntosEstatico implements ConjuntoTDA{
    int [] vector;
    int cantidad;

    public void InicializarConjunto() {
        vector= new int[20];
        cantidad=0;
    }
    public void Agregar(int x) {
        vector[cantidad]=x;
        cantidad++;
    }
    public  void Sacar(int x) {
        if (ConjuntoVacion()==false) {
            int i=0;
            while (x != vector[i] && i < cantidad) {
                i++;
            }
            vector[i]=vector[cantidad-1]; //Que?
        }
    }

    public boolean ConjuntoVacion() {
        return (cantidad==0);
    }
    public boolean Pertenece(int x) {
        int i=0;
        while (x != vector[i] && i < cantidad) {
            i++;
        }
        return (i < cantidad); // Que?
    }
    public  int Elegir() { // no eligir elemento sino la  cantidad
        //return (vector[Math.abs((int)System.nanoTime() % cantidad)]);
        return vector[0];
    }
}
