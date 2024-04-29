package api;

public interface ColaPrioridadTDA {
    void InicializacionCola();
    void Acolar(int dato , int prioridad);
    void Desacolar();
    boolean ColaVacia();
    int Primero();
    int Prioridad();
}
