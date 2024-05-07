package api;

public interface DiccionarioSimpleTDA {
    void InicializarDiccionario();
    void Agregar(int clave , int valor);
    int Recuperar(int clave);
    void Eleminar(int clave);
    ConjuntoTDA Claves();
}
