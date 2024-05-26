package api;

public interface PilaCola_ParesTDA {
    void Inicializar();
    void Guardar(int x);
    void Sacar();// desacolar o despilar
    int Mostrar(); // tope o el primero segun se comporte
    boolean EstaVacia();
    void Imprimir();
}
