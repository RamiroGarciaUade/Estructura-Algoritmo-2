package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
    int [] vector;
    int [] vectorPrioridad;

    int indice;
    int posiciamiento;

    public void InicializacionCola(){
        vector= new int[20];
        vectorPrioridad= new int[20];
        indice=0;
    }
    public void Acolar(int x, int prioridad){
        // desplaza a derecha los elementos de la cola mientras
        // estos tengan mayor o igual prioridad que la de x
        int j = indice;
        for (; j >0 && vectorPrioridad[j -1] >= prioridad; j -- ){
            vector[j] = vector[j -1];
            vectorPrioridad[ j] = vectorPrioridad[j -1];
        }
        vector[j] = x ;
        vectorPrioridad[j] = prioridad;
        indice++;
    }

    public void Desacolar(){ 
        indice--;
    }
    public int Primero(){
        return vector[indice-1];
    }
    public int Prioridad(){
        return vectorPrioridad[indice-1];
    }
    public boolean ColaVacia(){
        return (indice == 0);
    }
    
}
