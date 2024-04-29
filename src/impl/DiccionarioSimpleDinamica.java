package impl;

import api.ConjuntoTDA;
import api.DiccionarioTDA;

public class DiccionarioSimpleDinamica implements DiccionarioTDA {
    Nodo primero;
    Nodo ultimo;
    int cantidad;

    class Nodo {
        int clave;
        int valor;
        Nodo sig;
    }
    public void InicializarDiccionario() {
        primero=null;
        ultimo=null;
        cantidad=0;
    }
    public void Agregar(int clave , int valor) {
        Nodo aux=new Nodo();
        aux.valor=valor;
        aux.clave=clave;
        aux.sig=null;
        //Si esta vacia
        if (primero==null) {
            primero=aux;
            ultimo=primero;
        }
        //Si esta ya en el diccionario o no  SIGUIR VIENDO
        else {
            Nodo recorrer=new Nodo();
            recorrer=primero;
            while (recorrer.clave != aux.clave && recorrer.sig != null) { /// que pasa?
                recorrer = recorrer.sig;
            } 
            //intermedio
            if (recorrer.clave == aux.clave) {
                aux.sig = recorrer.sig;
            }
            // al final
            else{
                ultimo=aux;
            }
            
        }

    }
    public int Recuperar(int clave) {
        int valor;
        Nodo aux = primero;
        while (aux != null && aux.clave !=clave) {
            aux=aux.sig;
        }
        if (aux == null) {
            return -1;
        }
        else{
            valor=aux.valor;
            return valor;
        }
    }
    public void Eleminar(int clave) {
        if (primero != null) {
            if (primero.clave == clave) {
                primero=primero.sig;
            }
            else{
                Nodo aux = primero;
                while (aux.sig != null && aux.sig.clave != clave) {
                    aux=aux.sig;
                }
                if (aux.sig != null) {
                    aux.sig=aux.sig.sig;
                }
            }
        }
    }
    public ConjuntoTDA Claves() {
        ConjuntoTDA conjuntoClave=new ConjuntosDinamico();
        conjuntoClave.InicializarConjunto();
        Nodo aux = primero;
        while (aux != null) {
            conjuntoClave.Agregar(aux.clave);
            aux=aux.sig;
        }
        return conjuntoClave;
    }

}
