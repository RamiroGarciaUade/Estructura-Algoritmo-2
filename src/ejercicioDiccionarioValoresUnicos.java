import api.DiccionarioValoresUnicosTDA;
import impl.DiccionarioValoresUnicosDinamico;
public class ejercicioDiccionarioValoresUnicos {
    public static void main(String[] args) {
        DiccionarioValoresUnicosTDA d1 = new DiccionarioValoresUnicosDinamico();
        d1.InicializarDiccionario();
        d1.AgregarElemento(1, 5);

        d1.AgregarElemento(2, 2);
        d1.AgregarElemento(2, 3);

        d1.AgregarElemento(3, 1);

        d1.Mostrar(1);
        System.out.println("Proemdio:"+d1.PromedioClave(1));
        System.out.println("----------");
        d1.Mostrar(2);
        System.out.println("Proemdio:"+d1.PromedioClave(2));
        System.out.println("----------");
        d1.Mostrar(3);
        System.out.println("Proemdio:"+d1.PromedioClave(3));
        System.out.println("Promedio total:"+d1.PromedioTotal());



        
        d1.EleminarElemento(3);
        System.out.println("Proemdio eleminado de 3:"+d1.PromedioClave(3));
        d1.EleminarValorElemento(2,2);

        System.out.println("Promedio total:"+d1.PromedioTotal());
        d1.Mostrar(2);
    }
}
