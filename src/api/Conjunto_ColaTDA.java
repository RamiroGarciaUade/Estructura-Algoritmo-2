package api;

public interface Conjunto_ColaTDA {
    void inicializarConjunto_Cola();
    void agregar(int x); // Si hay mas de 5 elemento se comporta como conjunto eleminando los repetidos
    void eleminar(int x);
    boolean pertenece(int x);
    float promedio();
    int  mayor();// numero menor
    int  menor();
}
