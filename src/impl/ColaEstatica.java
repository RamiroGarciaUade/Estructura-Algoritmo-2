package impl;

import api.ColaTDA;

public class ColaEstatica implements ColaTDA {
    int[] vector; 
    int indice;

    public void InicializarCola(){
        vector = new int [18];
        indice = 0;
    }

    public void Acoplar(int dato){
        for (int i = indice-1 ; i >= indice ; i--) {
            vector[i-1]=vector[i];
        }
        vector[0]=dato;
        indice++;
    }

    public void DesAcoplar(){
        indice--;
    }

    public boolean ColaVacia(){
        return (indice==0);
    }

    public int Primero(){
        return vector[indice-1];
    }
}
    
