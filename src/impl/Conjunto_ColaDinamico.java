package impl;
import api.Conjunto_ColaTDA;
import api.ConjuntoTDA;

public class Conjunto_ColaDinamico implements Conjunto_ColaTDA{
    class Nodo {
        int info;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    ConjuntoTDA valoresUnicos=new ConjuntosDinamico();

    int cantidadElementos;




    public void inicializarConjunto_Cola(){
        valoresUnicos.InicializarConjunto();
        primero=null;
        ultimo=null;
        cantidadElementos=0;
    }
    public void agregar(int x) {
        Nodo aux =new Nodo();
        aux.info=x;
        aux.sig=null;
        if (primero != null) {
            if (cantidadElementos > 5) {
                if (cantidadElementos == 6) {
                    valoresUnicos.InicializarConjunto();
                    Nodo recorrer = primero;  
                    valoresUnicos.Agregar(recorrer.info); 
                    //    
                    while (recorrer !=null) { // !
                        if (recorrer.sig != null) {
                            if (pertenece(recorrer.sig.info)) {
                                recorrer.sig=recorrer.sig.sig;
                                cantidadElementos--;
                            }  
                            while (recorrer.sig.sig != null && pertenece(recorrer.sig.sig.info)) {
                                recorrer.sig=recorrer.sig.sig;
                                cantidadElementos--;
                            }
                                
                        }
                        recorrer=recorrer.sig;
                    }
                        
                }
                if (cantidadElementos > 5) {
                    if (!pertenece(x)) {
                        valoresUnicos.Agregar(x);
                        ultimo.sig=aux;
                        ultimo=aux;
                        cantidadElementos++;
                    }
                }
                else{
                    ultimo.sig=aux;
                    ultimo=aux;
                    cantidadElementos++;
                }
                }
                else{
                    if (!pertenece(x)) {
                        ultimo.sig=aux;
                        ultimo=aux;
                        cantidadElementos++;
                    }
                }
            }
            else {
                ultimo.sig=aux;
                ultimo=aux;
                cantidadElementos++;
            }
        }
        else{
            ultimo=aux;
            primero=ultimo;
            cantidadElementos++;
        }
    }

    public void eleminar(int x){ // !
        while (primero.info == x) {
            primero = primero.sig;
        }
        Nodo recorrer = primero;  
        while( recorrer != null){
            if (recorrer.sig != null) {
                if (recorrer.sig.info == x) {
                    recorrer.sig = recorrer.sig.sig;
                    cantidadElementos--;
                }
                while (recorrer.sig.info == x) {
                    recorrer.sig = recorrer.sig.sig;
                    cantidadElementos--;
                }
            }
            recorrer= recorrer.sig;
        }
    }
    public boolean pertenece(int x){
        boolean estado=false;
        Nodo recorrer = primero;      
        while (recorrer !=null && recorrer.info != x) {
            recorrer=recorrer.sig;
        }
        if (recorrer !=null ) {
            if (recorrer.info == x) {
                estado=true;
            }
        }
        return estado;
    }

    public float promedio(){
        float promedio=0;
        Nodo recorrer = primero;
        if (primero != null) {
            float valores=0;
            float cantidadValores=0;
            while (recorrer !=null) {
                cantidadValores++;
                valores+=recorrer.info;
                recorrer=recorrer.sig;
            }
            promedio= valores / cantidadValores;
        }      
        return promedio;
    }
    public int  mayor(){
        int Mayor=-1;
        Nodo recorrer = primero;
        if (primero != null) {
            Mayor=primero.info;
            while (recorrer !=null) {
                if (recorrer.info > Mayor) {
                    Mayor=recorrer.info;
                }
                recorrer=recorrer.sig;
            }
        }
        return Mayor;
    }
    public int  menor(){
        int Menor =-1;
        Nodo recorrer = primero;
        if (primero != null) {
            Menor=primero.info;
            while (recorrer !=null) {
                if (recorrer.info < Menor) {
                    Menor=recorrer.info;
                }
                recorrer=recorrer.sig;
            }
        }
        return Menor;
    }

}
