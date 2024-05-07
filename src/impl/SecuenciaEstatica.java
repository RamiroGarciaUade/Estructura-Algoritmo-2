package impl;

import api.SecuenciaTDA;

public class SecuenciaEstatica implements SecuenciaTDA{
    int[] secuencia;
    int cantidad;

    private void Acomodar(int posicion){

    }

    public void InicializarSecuencia(){
        secuencia = new int[20];
        cantidad=0;
    }
    public void AgregarEnPos(int x, int posicion) {
        if (posicion > -1) {
            
        }

    } //agrar en la posición o en el ultimo, no puede dejar espacios libres, o pisa
    public void AgregarAlInicio(int x){

    } //inserta el número en la primer posición
    public void AgregarAlFinal(int x){

    } //agrega en la ultima posición
   public void InsertarEnPos(int x, int p){

    } //inserta
    public void EliminarPos(int p){

    }
    public EliminarTodosValor(int x){

    } //elimina todos los valores x de la secuencia
    public void Ordenar(){

    }
    public void Mostrar(){

    } //muestra la secuencia en pantalla
    public boolean SecuenciaVacia(){

    }
}
