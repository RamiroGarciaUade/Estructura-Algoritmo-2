import api.SecuenciaTDA;
import impl.SecuenciaDinamica;

public class ejercicioSecuencia {
    public static void main(String[] args) {
        SecuenciaTDA s1 = new SecuenciaDinamica();
        s1.InicializarSecuencia();
        s1.AgregarAlFinal(4);
        s1.AgregarAlFinal(4);
        s1.AgregarAlFinal(4);
        s1.AgregarAlInicio(4);
        s1.AgregarAlInicio(2);
        s1.AgregarAlFinal(3);
        s1.AgregarAlFinal(4);
        s1.AgregarAlFinal(4);
        s1.AgregarAlFinal(4);
        s1.AgregarAlFinal(5);
        s1.AgregarAlFinal(6);
        s1.AgregarEnPos(7, 1);
        s1.AgregarEnPos(8, 5);
        s1.EliminarTodosValor(4);
        s1.InsertarEnPos(9, 3);
        s1.EliminarPos(1);
        s1.Mostrar();
        System.out.println("-------------");
        s1.Ordenar();
    }

}
