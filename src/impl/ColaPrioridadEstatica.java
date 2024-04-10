package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {
    int [] vector;
    int [] vectorPrioridad;
    int indice;
    public void InicializacionCola(){
        vector= new int[20];
        vectorPrioridad= new int[20];
        indice=0;
    }
    public void AcoplarPrioridad(int x, int prioridad){
        int posiciamiento;
        if (prioridad > vectorPrioridad[0]) {
            inserta(posiciamiento=0 , x);
            inserta(posiciamiento=0 , prioridad);
        }
        else if (prioridad < vectorPrioridad[indice-1]) {
            vector[indice]=x;
            vectorPrioridad[indice]=prioridad;
        }
        else{
            for (int i=indice;i>0;i--){
                if (prioridad >= vectorPrioridad[i]){
                    inserta(posiciamiento=i , x);
                    inserta(posiciamiento=i , prioridad);
                }
            }
        indice++;
        }
    }
    public void inserta(int pos , int x){ 
        for (int j=indice;j>pos;j--){
            vector[j]=vector[j-1];
        }
        vector[pos]=x;
    }

    public void DesAcoplar(){ //ACCAA
        for (int j=0;j<=indice;j++){
            vector[j]=vector[j+1];
            vectorPrioridad[j]=vectorPrioridad[j+1];
        }
        indice--;
    }
    public int Primero(){
        return vector[0];
    }
    public int Prioridad(){
        return vectorPrioridad[0];
    }
    public boolean ColaVacia(){
        return (indice == 0);
    }
    
}
