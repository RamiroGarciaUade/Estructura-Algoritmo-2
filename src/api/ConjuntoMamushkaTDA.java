package api;

public interface ConjuntoMamushkaTDA {
    void InicializarConjuntoMamushkaTDA();
    void Guardar(int x);
    void Sacar(int x);
    int Elegir();
    int perteneceCanti(int x);
    boolean estaVacia();
}
