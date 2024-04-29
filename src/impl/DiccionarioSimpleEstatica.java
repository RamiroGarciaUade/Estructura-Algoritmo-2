package impl;

import api.DiccionarioTDA;
import api.ConjuntoTDA;

public class DiccionarioSimpleEstatica implements DiccionarioTDA {
    int [][] matriz;
    int cant;

    public void InicializarDiccionario() {
        matriz= new int[2][10];
        cant=0;
    }
    public void Agregar(int clave , int valor) { 
        int recorrido=0;
        while (matriz[0][recorrido] != clave && recorrido < cant ) {
            recorrido++;
        }
        if (matriz[0][recorrido] == clave) {
            matriz[1][recorrido]=valor; // se guarda en la fila 1 los valores
        }
        else{
            matriz[1][recorrido+1]=valor;
            matriz[0][recorrido+1]=clave;
            cant++;
        }
    }
    public void Eleminar(int clave) {
        int posicion=cant-1;
        while (posicion >= 0) {
            if (matriz[0][posicion] == clave) {
                if (posicion != cant-1){
                    matriz[0][posicion]=matriz[0][cant-1];
                    matriz[1][posicion]=matriz[1][cant-1];
                }
            }
            posicion--;
        }
    }

    public int Recuperar(int clave) {
        int posicion = 0;
        int valorPredeterminado = -1;
        while (matriz[0][posicion] != clave && posicion < cant-1) {
            posicion++;
        }
        if (matriz[0][posicion] == clave) {
            valorPredeterminado = matriz[1][posicion];
        }
        return valorPredeterminado;
    }
    
    public ConjuntoTDA Claves() {
        int posicion=cant-1;
        int recorrido= 0;
        ConjuntoTDA conjuntoClave=new ConjuntosDinamico();
        conjuntoClave.InicializarConjunto();
        while (recorrido <= posicion) {
            conjuntoClave.Agregar(matriz[0][recorrido]);
            recorrido++;
        }
        return conjuntoClave;
    }
}
