package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;


public class DiccionarioMultipleDinamico implements DiccionarioMultipleTDA {

    class NodoClave{
        int clave;
        NodoValor valores; // ? guarda el primer nodo valor?
        NodoClave sigClave;
    }
    class NodoValor{
        int valor;
        NodoValor sigValor;
    }

    private NodoClave BuscarNodoClave( int clave){
        NodoClave aux = origen;
        while ( aux != null && aux.clave!= clave){
            aux = aux.sigClave;
        }
        return aux ;
    }

    private void EliminarValorEnNodo ( NodoClave nodo , int valor){ 
        if ( nodo.valores!= null ) {
            if ( nodo.valores.valor == valor) {
                nodo.valores = nodo .valores.sigValor;
            }
            else {
                NodoValor aux = nodo.valores;
                while ( aux . sigValor != null && aux .sigValor.valor!= valor) {
                    aux = aux.sigValor;
                }
                if ( aux.sigValor!= null ) {
                    aux.sigValor= aux.sigValor.sigValor;
                }
            }
            }
    }
        

    NodoClave origen;

    public void InicializarDiccionario (){
        origen = null;
    }
    public void Agregar( int clave , int valor){
        NodoClave nodoClave = BuscarNodoClave(clave);
        if (nodoClave == null) { // Si no esta en los nodos crea nuevo nodo clave para unir a los nodos claves
            nodoClave = new NodoClave();
            nodoClave.clave=clave;
            nodoClave.sigClave= origen; // ?  ORIGEN ESTA VACIO?
        }
        NodoValor aux =nodoClave.valores;
        while ( aux != null && aux.valor!= valor) {
            aux = aux.sigValor;
        }
        if ( aux == null ) {
            NodoValor nodoValor = new NodoValor ();
            nodoValor.valor = valor;
            nodoValor.sigValor = nodoClave.valores; // ?  que hace?
            nodoClave.valores = nodoValor;
        }
    }
    public void Eliminar( int clave){
        if (origen != null) {
            if (origen.clave == clave) {
                origen=origen.sigClave;
            }
            else{
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux= aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave=aux.sigClave.sigClave;
                }
            }
        }

    }
    public void EliminarValor( int clave , int valor){  
        if ( origen!=null ) {
            if ( origen. clave == clave) {
                EliminarValorEnNodo ( origen , valor);
                if ( origen. valores == null ) {
                    origen = origen. sigClave;
                }
            }
            else {
                NodoClave aux = origen;
                while ( aux . sigClave != null && aux . sigClave. clave != clave) {
                    aux = aux.sigClave;
                }
                if ( aux . sigClave!= null ) {
                    EliminarValorEnNodo ( aux . sigClave , valor);
                    if ( aux . sigClave. valores==null ) {
                        aux . sigClave= aux . sigClave. sigClave;
                    }
                }
            }
        }
    }
    public ConjuntoTDA Recuperar( int clave){
        NodoClave n = BuscarNodoClave( clave) ;
        ConjuntoTDA c = new ConjuntosDinamico() ;
        c. InicializarConjunto () ;
        if ( n!= null ) {
            NodoValor aux = n. valores;
            while ( aux != null ) {
                c. Agregar( aux. valor);
                aux = aux.sigValor;
            }
        }
        return c;

    }
    public ConjuntoTDA Claves(){
        ConjuntoTDA c = new ConjuntosDinamico() ;
        c. InicializarConjunto () ;
        NodoClave aux = origen;
        while ( aux != null ){
            c. Agregar( aux . clave);
            aux = aux . sigClave;
        }
        return c;


    }

}
