package api;

public interface ColaPrioridadTDA {
    void InicializacionCola();
    void AcoplarPrioridad(int dato , int prioridad);
    void DesAcoplar();
    boolean ColaVacia();
    int Primero();
    int Prioridad();
}
