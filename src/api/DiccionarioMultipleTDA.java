package api;

public interface DiccionarioMultipleTDA {
    void InicializarDiccionario () ;
    // siempre que el diccionario est´e inicializado  conjunto de valores, pero esos valores no se pueden repetir.
    void Agregar( int clave , int valor);
    // siempre que el diccionario est´e inicializado
    void Eliminar( int clave);
    // siempre que el diccionario est´e inicializado
    void EliminarValor( int clave , int valor);
    // siempre que el diccionario est´e inicializado eliminar el valor, la clave no tiene otros valores asociados se debe eliminar la misma.
    ConjuntoTDA Recuperar( int clave);
    // siempre que el diccionario est´e inicializado
    ConjuntoTDA Claves();
}
