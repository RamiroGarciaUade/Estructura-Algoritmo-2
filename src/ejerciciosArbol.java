import api.ABBTDA;
import impl.ABB;
import algoritmos.metodosArbol;

public class ejerciciosArbol {
    public static void main(String[] args) throws Exception {
        ABBTDA a1 = new ABB();

        a1.InicializarArbol();

        a1.AgregarElem(20);
        a1.AgregarElem(10);
        a1.AgregarElem(15);
        a1.AgregarElem(25);
        a1.AgregarElem(18);
        a1.AgregarElem(30);

        a1.AgregarElem(2);
        a1.EliminarElem(2);

        System.out.println(metodosArbol.buscarElementoArbol(a1,30));
        System.out.println(metodosArbol.hojaElemento(a1,30));
        System.out.println(metodosArbol.valorMenorArbol(a1));
        metodosArbol.mostrarElementosArbol(a1);
        System.out.println("////////");
        System.out.println(metodosArbol.totalElemento(a1));
        System.out.println(metodosArbol.profundidadArbol(a1));
        System.out.println(metodosArbol.cantidadHojaArbol(a1));
        System.out.println(metodosArbol.sumaTotalValoresElemento(a1));
        System.out.println(metodosArbol.cantidadElementoNivelArbol(a1, 2));
    }

}
