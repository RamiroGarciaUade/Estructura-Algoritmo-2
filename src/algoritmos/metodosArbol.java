package algoritmos;

import api.ABBTDA;

import java.lang.Math;

public class metodosArbol {
    
    public static boolean buscarElementoArbol(ABBTDA a, int x){
        if (x == a.Raiz()) {
            return true;
        }
        else if (x > a.Raiz()) {
            if (a.HijoDer().ArbolVacio() == false) {
                return buscarElementoArbol(a.HijoDer(), x);
            }
        }
        else if (x < a.Raiz()) {
            if (a.HijoIzq().ArbolVacio() == false) {
                return(buscarElementoArbol(a.HijoIzq(), x));
            }
        }
        return false;
    }

    public static boolean hojaElemento(ABBTDA a , int x){
        // PREGUNTAMOS SI ES LA RAIZ
        if (x == a.Raiz()) {
            // PREGUNTAMOS SI ES HOJA
            if ( a.HijoIzq().ArbolVacio()  &&  a.HijoDer().ArbolVacio() ) {
                return true;
            }
            
        }
        else if (x > a.Raiz()) {
            if (a.HijoDer().ArbolVacio() == false) {
                return hojaElemento(a.HijoDer() , x);
            }
        }
        else if (x < a.Raiz()) {
            if (a.HijoIzq().ArbolVacio() == false) {
                return(hojaElemento(a.HijoIzq(), x));
            }
        }
        return false;
    }

    public static int cantidadHojaArbol(ABBTDA a){ 
        int x=0;
        // PREGUNTAMOS SI no tiene los dos HIJOS (incrementando por ser hoja)
        if (a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio()) {
            x++;
        }
        if (!a.HijoDer().ArbolVacio()) {
            x+=cantidadHojaArbol(a.HijoDer());
        }
        if (!a.HijoIzq().ArbolVacio()) {
            x+=cantidadHojaArbol(a.HijoIzq());
        }
        return x;
    }

    public static int cantidadElementoNivelArbol(ABBTDA a, int nivel){  // !
        if (nivel >= 0  && nivel <= profundidadArbol(a)) {
            int der = 0;
            int izq = 0;
            if (nivel == 0) {
                return 1;
            }
            if (!a.HijoDer().ArbolVacio()) {
                der = cantidadElementoNivelArbol(a.HijoDer(), nivel - 1);
            }
            if (!a.HijoIzq().ArbolVacio()) {
                izq = cantidadElementoNivelArbol(a.HijoIzq(), nivel-1);
            }
            return der+izq;
            
        }
        return 0;
    } 

    public static int valorMenorArbol(ABBTDA a){
        //Preguntamos si h.i existe (siendo que este tiene el valor mas bajo)
        if (a.HijoIzq().ArbolVacio()) {
            return a.Raiz();
        }
        else {
            return valorMenorArbol(a.HijoIzq());
        }
    }

    public static void mostrarElementosArbol(ABBTDA a){
        System.out.print(a.Raiz()+"-");
        if (!a.HijoIzq().ArbolVacio()) {
            mostrarElementosArbol(a.HijoIzq());
        }
        if (!a.HijoDer().ArbolVacio()) {
            mostrarElementosArbol(a.HijoDer());
        }
    }

    public static int totalElemento(ABBTDA a){
        int totalElemento=1;
        if (!a.HijoIzq().ArbolVacio()) {
            totalElemento+= totalElemento(a.HijoIzq());
        }
        if (!a.HijoDer().ArbolVacio()) {
            totalElemento+=totalElemento(a.HijoDer());
        } 
        return totalElemento;
    }

    public static int sumaTotalValoresElemento(ABBTDA a){ // * EVITAR USAR VARIABLE EN RECURSION (PERO SI LO NECESITAS USA LA)
        if (a.ArbolVacio()) {
            return 0;
        }
        return a.Raiz() + sumaTotalValoresElemento(a.HijoDer())+sumaTotalValoresElemento(a.HijoIzq());
    }

    public static int profundidadArbol(ABBTDA a){ 
        int i=0; // CADA INT MIDE LA PROFUNDIDAD DE UN HIJO
        int y=0;
        if (!a.HijoIzq().ArbolVacio()) {
            i++; // SI EXISTE INCREMENTA
            i+=profundidadArbol(a.HijoIzq());
        }
        if (!a.HijoDer().ArbolVacio()) {
            y++;
            y+=profundidadArbol(a.HijoDer());
        }
        return Math.max( i , y) ; // ELIGE ENTRE LOS DOS HIJOS CUAL ES EL QUE TIENE VALOR MAYOR DE PROFUNDIDAD
    } 

}
