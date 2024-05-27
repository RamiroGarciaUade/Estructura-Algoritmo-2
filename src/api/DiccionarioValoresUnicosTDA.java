package api;

public interface DiccionarioValoresUnicosTDA {
    void InicializarDiccionario();
    void AgregarElemento(int clave,int x); // creas o agregas segun si existe o no la clave y los valores no se pueden repetir dentro de la clave
    void EleminarElemento(int clave); // eleminas el elemento segun su clave
    void EleminarValorElemento(int clave, int x); // eleminas el valor segun su clave
    float PromedioClave(int clave); // saber el promedio de una clave
    float PromedioTotal(); // saber el promedio de todas las clave
    ConjuntoTDA Claves(); // las claves del dicccionario
    void Mostrar(int clave); // mostrar los elementos de una clave
}
