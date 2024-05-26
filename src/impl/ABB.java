package impl;
import api.ABBTDA;

public class ABB implements ABBTDA{ // AL USAR RECURSIVIDIDAD NO ES NECESARIO LLAMAR A LA MISMA INTERFAZ PORQUE YA LA TIENE
    // * CADA NODO ES UN ARBOL
    class NodoABB{
        int info ;
        ABBTDA hijoIzq;
        ABBTDA hijoDer;
    }
    
    NodoABB raiz; // Cada vez lo intacio crea el nodo y este tiene una raiz con sus hijos

    public void InicializarArbol () { // *Cuando creas un ABB tienes que inicializarlo
        raiz = null;
    }
     // siempre que el ´arbol est´e inicializado
    public boolean ArbolVacio(){ //*  Preguntara si el ABB esta vacio
        return ( raiz == null );
    }
    // siempre que el ´arbol est´e inicializado y no est´e vac´ıo
    public int Raiz (){
        return raiz.info;
    }
    public ABBTDA HijoDer() {
        return raiz.hijoDer;
    }
    public ABBTDA HijoIzq() {
        return raiz.hijoIzq;
    }
    
    // siempre que el ´arbol est´e inicializado
    public void AgregarElem( int x){
        if (raiz == null) { // * Si raiz no tiene nigun valor crea un ABB
            raiz = new NodoABB();
            raiz.info=x;
            raiz.hijoIzq=new ABB(); // * USAS LA MISMA IMPLEMENTACION USANDO RECURSIVIDIDAD
            raiz.hijoIzq.InicializarArbol();
            raiz.hijoDer=new ABB();
            raiz.hijoDer.InicializarArbol();
        }
        else if (raiz.info > x){ 
            raiz.hijoIzq.AgregarElem(x);
        }
        else if (raiz.info < x) {
            raiz.hijoDer.AgregarElem(x);
        }
    }
    // siempre que el ´arbol est´e inicializado
    public void EliminarElem( int x){
        if (raiz != null) {// * Si no existe el valor no se puede eleminar nada (solo cuando llege a la parte mas baja del arbol)
            // Cuando encuentra el valor a eleminar
            if (raiz.info == x && raiz.hijoIzq.ArbolVacio()  && raiz.hijoDer.ArbolVacio()) /* el and debe ser todo true un false no cumple condicion */ { 
                raiz =null; // * Si no tiene nigun ABB hijo se lo elemina
            }
            else if (raiz.info ==x && !raiz.hijoIzq.ArbolVacio()) { // * Preguntamos si el  H.I existe
                raiz.info=this.mayor(raiz.hijoIzq); // te devuelve el la raiz del nodo o el H.I (IZQUIERDA MAYOR) y le copias el valor al ABB 
                // ? porque THIS?
                raiz.hijoIzq.EliminarElem(raiz.info);// RECURSIVIDADE DE ELEMINACION PARA RLRMINAR EL nodo del H.I que le remplazarte por la raiz de este arbol
            }
            else if (raiz.info ==x && raiz.hijoIzq.ArbolVacio()) {
                raiz.info=this.menor(raiz.hijoDer);// te devuelve el la raiz del nodo o el H.D (DERECHA MENOR) y lo convertis en raiz del arbol
                raiz.hijoDer.EliminarElem(raiz.info); // RECURSIVIDADE DE ELEMINACION PARA RLRMINAR EL nodo del H.D que le remplazarte por la raiz de este arbol
            }
            // Recorre el arbol hasta encontrar el valor a eleminar
            else if ( raiz.info < x){
                raiz . hijoDer. EliminarElem(x) ;
                } 
            else {
                raiz . hijoIzq. EliminarElem(x) ;
            }
        }
    }
    private int mayor( ABBTDA a) { // Busca el valor mayor del ABB
        if (a. HijoDer().ArbolVacio ()) {
            return a.Raiz() ;}
        else{
            return mayor(a.HijoDer());
        }
    }

    private int menor( ABBTDA a) { // busca el valor menor del ABB
        if (a.HijoIzq().ArbolVacio ()) {
            return a.Raiz() ;}
        else{
            return mayor(a. HijoIzq());
        }
    }
}

