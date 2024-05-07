package api;

public interface SecuenciaTDA {
    void InicializarSecuencia();
    void AgregarEnPos(int x, int p); //agrar en la posición o en el ultimo, no puede dejar espacios libres, o pisa
    void AgregarAlInicio(int x); //inserta el número en la primer posición
    void AgregarAlFinal(int x); //agrega en la ultima posición
    void InsertarEnPos(int x, int p); //inserta
    void EliminarPos(int p);
    void EliminarTodosValor(int x); //elimina todos los valores x de la secuencia (borrar todos los 5)
    void Ordenar();
    void Mostrar(); //muestra la secuencia en pantalla
    boolean SecuenciaVacia();

}
