package impl;
import api.DiccionarioValoresUnicosTDA;
import api.ColaTDA;
import algoritmos.metodosCola;
import api.ConjuntoTDA;


public class DiccionarioValoresUnicosDinamico implements DiccionarioValoresUnicosTDA {
    class Nodo{
        int clave;
        ConjuntoTDA valoresEnLista = new ConjuntosDinamico();
        ColaTDA valores = new ColaDinamica();
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    ConjuntoTDA claves= new ConjuntosDinamico();

    float totalClave;
    float totalSumaValores;

    public void InicializarDiccionario(){
        primero=null;
        ultimo=null;
        claves.InicializarConjunto();
        totalClave=0;
        totalSumaValores=0;
    }
    public void AgregarElemento(int clave,int x){
        // clave existente
        if (claves.Pertenece(clave)) {
            Nodo recorrer =new Nodo();
            recorrer=primero;
            while (recorrer != null &&  recorrer.clave != clave ) {
                recorrer=recorrer.sig;
            }
            if (recorrer.clave == clave) {
                if (!recorrer.valoresEnLista.Pertenece(x)) {
                    recorrer.valores.Acoplar(x);
                    recorrer.valoresEnLista.Agregar(x);
                }
            }
        }
        // crear clave
        else {
            claves.Agregar(clave);
            Nodo aux = new Nodo();
            aux.clave=clave;
            aux.valores.InicializarCola();
            aux.valores.Acoplar(x);
            aux.valoresEnLista.InicializarConjunto();
            aux.valoresEnLista.Agregar(x);
            aux.sig=null;

            // cero elementos
            if (primero == null) {
                primero=aux;
                ultimo=primero;
            }
            else{
                ultimo.sig=aux;
                ultimo=aux;
            }
            totalClave++;
        }
        totalSumaValores+=x;
    }
    public void EleminarElemento(int clave){ 
        if (claves.Pertenece(clave)) {
            float total=0;
            claves.Sacar(clave);
            if (primero.clave == clave) {
                while (!primero.valores.ColaVacia()) { 
                    total+=primero.valores.Primero();
                    primero.valores.DesAcoplar();
                }
                primero=primero.sig;
            }
            else{
                Nodo recorrer =new Nodo();
                recorrer=primero;
                while (recorrer != null && recorrer.sig.clave != clave) {
                    recorrer=recorrer.sig;
                }
                
                if (recorrer.sig.clave == clave) {
                    while (!recorrer.sig.valores.ColaVacia()) {
                        total+=recorrer.sig.valores.Primero();
                        recorrer.sig.valores.DesAcoplar();
                    }
                    recorrer.sig=recorrer.sig.sig;
                }
            }
            totalSumaValores=totalSumaValores - total;  // ! no resta
            totalClave--;
            System.out.println("-"+totalSumaValores);
        }
    }
    public void EleminarValorElemento(int clave, int x){ 
        if (claves.Pertenece(clave)) {
            Nodo recorrer =new Nodo();
            recorrer=primero;
            while (recorrer != null &&  recorrer.clave != clave ) {
                recorrer=recorrer.sig;
            }
            if (recorrer.clave == clave) {
                ColaTDA colaAux = new ColaDinamica();
                colaAux.InicializarCola();
                while (!recorrer.valores.ColaVacia()) {
                    if (recorrer.valores.Primero() != x) {
                        colaAux.Acoplar(recorrer.valores.Primero());
                    }
                    recorrer.valores.DesAcoplar();
                }
                metodosCola.copiarCola(colaAux , recorrer.valores );
                totalSumaValores-=x; // ! no resta
            } 
        }
        System.out.println("-"+totalSumaValores);
    }
    public float PromedioClave(int clave){
        float resultado=0;
        if (claves.Pertenece(clave)) {
            float cantidadElementos=0;
            float totalValores=0;
            Nodo recorrer =new Nodo();
            recorrer=primero;
            while (recorrer != null &&  recorrer.clave != clave ) {
                recorrer=recorrer.sig;
            }
            if (recorrer.clave == clave) {
                ColaTDA colaAux = new ColaDinamica();
                colaAux.InicializarCola();
                metodosCola.copiarCola(recorrer.valores, colaAux );
                while (!colaAux.ColaVacia()) {
                    cantidadElementos++;
                    totalValores+=colaAux.Primero();
                    colaAux.DesAcoplar();
                }
                resultado= totalValores / cantidadElementos;
            }
        }
        return resultado;
    }
    public float PromedioTotal(){ 
        return totalSumaValores / totalClave;
    }
    public void Mostrar(int clave){
        if (claves.Pertenece(clave)) {
            Nodo recorrer =new Nodo();
            recorrer=primero;
            while (recorrer != null &&  recorrer.clave != clave ) {
                recorrer=recorrer.sig;
            }
            if (recorrer.clave == clave) {
                ColaTDA colaAux = new ColaDinamica();
                colaAux.InicializarCola();
                metodosCola.copiarCola(recorrer.valores, colaAux );
                while (!colaAux.ColaVacia()) {
                    System.out.println(colaAux.Primero());
                    colaAux.DesAcoplar();
                }
            }
        }
    }
    @Override
    public ConjuntoTDA Claves() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Claves'");
    }
}
