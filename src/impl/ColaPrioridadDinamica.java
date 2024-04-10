package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadDinamica {
    Nodo primero;
    Nodo ultimo;
    class Nodo {
        int info;
        int prio;
        Nodo sig;
    }
    public void InicializacionCola(){
        primero=null;
        ultimo=null;
        
    }
    public void AcoplarPrioridad(int x, int prioridad){
        Nodo aux=new Nodo();
        aux.info=x;
        aux.prio=prioridad;
        aux.sig=null;
        if (aux.prio > primero.prio){
            aux.sig = primero;
            primero=aux;
        }
        else if  (aux.prio < ultimo.prio){
            ultimo.sig=aux;
            ultimo=aux;
        }
        else{
            for (;>=aux.prio;){
                
                aux.sig=
            }
        }
    }

    public void DesAcoplar(){ //ACCAA
        
    }
    public int Primero(){
        return primero.info;
    }
    public int Prioridad(){
        return primero.prio ;
    }
    public boolean ColaVacia(){
        return ( primero == null );
    }
}
