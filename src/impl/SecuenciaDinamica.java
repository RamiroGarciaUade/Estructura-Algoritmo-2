package impl;

import api.SecuenciaTDA;
import api.ColaPrioridadTDA;

public class SecuenciaDinamica implements SecuenciaTDA {
    class Nodo{
        int info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    int cantidadElemento;

    public void InicializarSecuencia(){
        primero=null;
        ultimo=null;
        cantidadElemento=0;
    }
    public void AgregarEnPos(int x, int p){ //agrar en la posición o en el ultimo, no puede dejar espacios libres, o pisa
        Nodo aux = new Nodo();
        aux.info=x;
        aux.sig=null;
        if (p < cantidadElemento && p >= 0 && primero != null) {
            if (p == 0) {
                aux.sig=primero;
                primero=aux;
                cantidadElemento++;
            }
            else{
                Nodo recorrer =new Nodo();
                recorrer=primero;
                int i=0;
                while (recorrer != null && i+1 !=p) {
                    recorrer=recorrer.sig;
                    i++;
                }
                if (i+1 == p) {
                    aux.sig=recorrer.sig;
                    recorrer.sig=aux;
                    cantidadElemento++;
                }
            }
            
        }
        else{
            if (primero == null) {
                ultimo=aux;
                primero=ultimo;
            }
            else{
                ultimo.sig=aux;
                ultimo=aux;
                cantidadElemento++;
            }
        }
    } 
    public void AgregarAlInicio(int x){ //inserta el número en la primer posición
        if (primero ==null) {
            Nodo aux=new Nodo();
            aux.info=x;
            primero=aux;
            ultimo=primero;
            cantidadElemento++;
        }
        else {
            primero.info=x;
        }

    } 
    public void AgregarAlFinal(int x){ //agrega en la ultima posición
        Nodo aux=new Nodo();
        aux.info=x;
        aux.sig=null;
        if (primero ==null) {
            primero=aux;
            ultimo=primero;
            cantidadElemento++;
        }
        else{
            ultimo.sig=aux;
            ultimo=aux;
            cantidadElemento++;
        }

    } 
    public void InsertarEnPos(int x, int p){ //inserta POR POS
        if (p < cantidadElemento && p >= 0 && primero != null) {
            if (p == 0) {
                primero.info=x;
            }
            else if (p == cantidadElemento-1) {
                ultimo.info=x;
            }
            else{
                Nodo recorrer =new Nodo();
                recorrer=primero;
                int i=0;
                while (recorrer != null && i !=p) {
                    recorrer=recorrer.sig;
                    i++;
                }
                if (i == p) {
                    recorrer.info=x;
                }
            }
        }
    }
    public void EliminarPos(int p){
        if (p < cantidadElemento && p >= 0 && primero != null) {
            if (p == 0) {
                primero=primero.sig;
            }
            else{
                Nodo recorrer =new Nodo();
                recorrer=primero;
                int i=0;
                while (recorrer != null && i+1 !=p) {
                    recorrer=recorrer.sig;
                    i++;
                }
                if (i+1 == p) {
                    recorrer.sig=recorrer.sig.sig;
                }
            }
        }
    }
    public void EliminarTodosValor(int x){  //elimina todos los valores x de la secuencia (borrar todos los 5) 
        while (primero.info == x) {
            primero = primero.sig;
        }
        Nodo recorrer=primero;
        while( recorrer != null){
            if (recorrer.sig != null) {
                if (recorrer.sig.info == x) {
                    recorrer.sig = recorrer.sig.sig;
                }
                while (recorrer.sig.info == x) {
                    recorrer.sig = recorrer.sig.sig;
                }
            }
            recorrer= recorrer.sig;
            
        }
    }
    public void Ordenar(){
        ColaPrioridadTDA colaOrdenada= new ColaPrioridadDinamica();
        colaOrdenada.InicializacionCola();
        Nodo recorrer =new Nodo();
        recorrer=primero;
        while (recorrer != null) {
            colaOrdenada.Acolar(recorrer.info, -recorrer.info);
            recorrer=recorrer.sig;
        }
        while (!colaOrdenada.ColaVacia()) {
            System.out.println(colaOrdenada.Primero());
            colaOrdenada.Desacolar();
        }

    }
    public void Mostrar(){
        Nodo aux =new Nodo();
        aux=primero;
        while (aux != null) {
            System.out.println(aux.info);
            aux=aux.sig;
        }

    } //muestra la secuencia en pantalla
    public boolean SecuenciaVacia(){
        return (primero == null);
    }
}
