package impl;

import api.ConjuntoTDA;
import api.DiccionarioMultipleTDA;

public class DiccionarioMultipleEstatico implements DiccionarioMultipleTDA {
    Elemento[] vector;
    int cantidadClaves;

    class Elemento{
        int clave;
        int[] valores;
        int cantidadValores;
    }
    
    // Busca el indice de la clave y valor
    private int BuscarIndiceClave (int clave){
        int i = cantidadClaves -1;
        while(i >=0 && vector[i].clave!= clave){
            i--;
        }
        return i;
    }
    private int BuscarIndiceValor( Elemento elemento , int valor) {
        int i = elemento.cantidadValores-1;
        while(i >=0 && elemento.valores[i] != valor){
            i --;
        }
        return i;
    }
    //---------------------------------------------------------------------//
    public void InicializarDiccionario(){
        vector = new Elemento[20];
        cantidadClaves=0;
    }
    public void Agregar(int clave , int valor){
        // Buscar si existe o no la clave
        int posicionClave= BuscarIndiceClave(clave);
        if (posicionClave == -1) {
            posicionClave = cantidadClaves; // lo pone al ultimo posicion
            vector[posicionClave]= new Elemento();
            vector[posicionClave].clave=clave;
            vector[posicionClave].valores=new int[20];
            vector[posicionClave].cantidadValores=0;
            cantidadClaves++;
        }
        // Busca si en el el elemento existe el valor a agregar
        Elemento aux= vector[posicionClave]; // toma Elemento de la posicion del vector y lo pasa a aux
        int posicionValor=BuscarIndiceValor( aux ,  valor);
        if (posicionValor == -1) {
            aux.valores[aux.cantidadValores] = valor; // Donde lo guarda? -----
            aux.cantidadValores++;
        }
    }
    public void Eliminar(int clave){
        int posicionClave = BuscarIndiceClave(clave);
        if (posicionClave != -1) { // busca el indice del clave eleminar
            vector[posicionClave]=vector[cantidadClaves-1]; // lo elemina al remplazarlo por el ultimo y reduce la cantidad de claves
            cantidadClaves--;
        }
    }
    public void EliminarValor(int clave , int valor){
        int posicionClave = BuscarIndiceClave(clave);
        if (posicionClave != -1) { // busca el indice del valor eleminar
            Elemento aux = vector[posicionClave];
            int posicionValor = BuscarIndiceValor(aux, valor);
            if (posicionValor == -1) {
                aux.valores[posicionValor] = aux.valores[aux.cantidadValores-1]; // lo elemina al remplazarlo por el ultimo y reduce la cantidad de valores
                aux.cantidadValores--;
                if (aux.cantidadValores == 0) {
                    Eliminar(clave);
                }
            }
        }

    }
    public ConjuntoTDA Recuperar(int clave){
        ConjuntoTDA TotalValores = new ConjuntosDinamico();
        TotalValores.InicializarConjunto();
        int posicionClave=BuscarIndiceClave(clave);
        if ( posicionClave != -1) {
            Elemento aux = vector[posicionClave];
            for (int i =0 ;i < aux.cantidadValores;i++){
                TotalValores.Agregar(aux.valores[i]);
            }
        }
        return TotalValores;

    }
    public ConjuntoTDA Claves(){
        ConjuntoTDA TotalClave = new ConjuntosDinamico();
        TotalClave.InicializarConjunto();
        for (int i = 0;i < cantidadClaves; i++){
            TotalClave.Agregar(vector[i].clave);
        }
        return TotalClave;
    }
}
