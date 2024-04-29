package api;

public interface ConjuntoTDA {
    void InicializarConjunto();
    void Agregar(int x);
    void Sacar(int x);
    boolean ConjuntoVacion();
    boolean Pertenece(int x);
    int Elegir();
}
