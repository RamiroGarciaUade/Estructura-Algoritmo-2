package api;

public interface AlumnoNotasTDA {
    void InicializacionAlumnoNota();
    void NotasAlumno(int id);//mostra las notas del alumno
    double PromedioAlumno(int id);
    double PromedioGrupal();
    void AlumnosAprobados(); // >= 4
    void AltaNota(int id , int nota); // si no existe el alumno lo creas en el acto
    void BorrarAlumno(int id);
}
