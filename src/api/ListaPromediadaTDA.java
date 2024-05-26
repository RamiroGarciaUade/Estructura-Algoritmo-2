package api;

public interface ListaPromediadaTDA {
    void InicializarListaPromediada();
    void Agregar(int valor);
    void Eleminar(int valor);
    double Promedio();
    ColaTDA Menores();
    ColaTDA Mayores();
    boolean EstaVacia();
}
