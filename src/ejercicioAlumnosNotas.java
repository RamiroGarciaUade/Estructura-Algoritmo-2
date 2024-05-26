import api.AlumnoNotasTDA;
import impl.AlumnoNotasDinamico;
public class ejercicioAlumnosNotas {
    public static void main(String[] args) {
        AlumnoNotasTDA an1 = new AlumnoNotasDinamico();
        an1.InicializacionAlumnoNota();
        an1.AltaNota(1, 5);
        an1.AltaNota(1, 7);
        an1.AltaNota(1, 3);
        an1.NotasAlumno(1);
        System.out.println("Promedio;"+an1.PromedioAlumno(1));
        System.out.println("----------");
        an1.AltaNota(2, 10);
        an1.AltaNota(2, 7);
        an1.AltaNota(2, 7);
        an1.NotasAlumno(2);
        System.out.println("Promedio;"+an1.PromedioAlumno(2));
        System.out.println("----------");
        an1.AltaNota(3, 3);
        an1.AltaNota(3, 8);
        an1.AltaNota(3, 5);
        an1.NotasAlumno(3);
        System.out.println("Promedio;"+an1.PromedioAlumno(3));
        System.out.println("----------");
        an1.AltaNota(4, 1);
        an1.AltaNota(4, 2);
        an1.AltaNota(4, 7);
        an1.NotasAlumno(4);
        System.out.println("Promedio;"+an1.PromedioAlumno(4));
        System.out.println("----------");
        System.out.println("Alumnos aprobados");
        an1.AlumnosAprobados();
        System.out.println("----------");
        System.out.println("Promedio grupal:"+an1.PromedioGrupal());
        System.out.println("----------");

        an1.BorrarAlumno(3);
        System.out.println("Promedio;"+an1.PromedioAlumno(3));
    }
    

}
