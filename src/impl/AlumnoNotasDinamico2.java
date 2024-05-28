package impl;
import api.AlumnoNotasTDA;
import api.ConjuntoTDA;
import api.ColaTDA;
import algoritmos.metodosArbol;
import algoritmos.metodosCola;

public class AlumnoNotasDinamico2 implements AlumnoNotasTDA{
    class Nodo{
        int id;
        ColaTDA notas= new ColaDinamica();
        Nodo sig;
    }

    ConjuntoTDA idAlumnos=new ConjuntosDinamico();

    Nodo primero;
    Nodo ultimo;

    int cantidadAlumnos;

    public void InicializacionAlumnoNota(){
        idAlumnos.InicializarConjunto();
        cantidadAlumnos=0;
        primero=null;
        ultimo=null;
    }

    public void NotasAlumno(int id){ //mostra las notas del alumnos
        Nodo recorrer=new Nodo();
        recorrer=primero;
        if (idAlumnos.Pertenece(id)) {
            while (recorrer != null && recorrer.id != id) {
                recorrer=recorrer.sig;
            }
            if (recorrer.id == id) {
                ColaTDA colaAux =new ColaDinamica();
                colaAux.InicializarCola();
                metodosCola.copiarCola(recorrer.notas, colaAux);
                while (!colaAux.ColaVacia()) {
                    System.out.println(colaAux.Primero());
                    colaAux.DesAcoplar();
                }
            }
        }
        
    }
    public double PromedioAlumno(int id){
        double resultado=0;
        if (idAlumnos.Pertenece(id)) {
            Nodo recorrer=new Nodo();
            recorrer=primero;
            double cantidadExamen=0;
            double totalNotas=0;
            while (recorrer != null && recorrer.id != id) {
                recorrer=recorrer.sig;
            }
            if (recorrer.id==id) {
                ColaTDA colaAux =new ColaDinamica();
                colaAux.InicializarCola();
                metodosCola.copiarCola(recorrer.notas, colaAux);
                while (!colaAux.ColaVacia()) {
                    cantidadExamen++;
                    totalNotas+=colaAux.Primero();
                    colaAux.DesAcoplar();
                }
                resultado= totalNotas / cantidadExamen;
            }
        }
        return resultado;
    }


    public double PromedioGrupal(){
        double resultadoGrupal=0;
        if (primero != null) {
            double totalPromedio=0;
            Nodo recorrerGrupal=new Nodo();
            recorrerGrupal=primero;
            while (recorrerGrupal != null) {
                totalPromedio+=PromedioAlumno(recorrerGrupal.id);
                recorrerGrupal=recorrerGrupal.sig;
            }
            
            resultadoGrupal= totalPromedio / cantidadAlumnos;
        }
        return resultadoGrupal;
    }

    public void AlumnosAprobados(){ // ! solo hay dos element6os 
        if (primero != null) {
            Nodo recorrerVista=new Nodo();
            recorrerVista=primero;
            while (recorrerVista != null) {
                if (PromedioAlumno(recorrerVista.id) >= 4) {
                    System.out.println(recorrerVista.id);
                }
                recorrerVista=recorrerVista.sig;
            }
        }
    }


    public void AltaNota(int id , int nota){
        // ESTA EL LA LISTA DE NODO
        if (idAlumnos.Pertenece(id)) {
            Nodo recorrer = new Nodo();
            recorrer=primero;
            while (recorrer != null && recorrer.id != id) {
                recorrer=recorrer.sig;
            }
            if (recorrer.id==id) {
                recorrer.notas.Acoplar(nota);
            }
        }
        else{
            idAlumnos.Agregar(id);
            cantidadAlumnos++;
            Nodo aux=new Nodo();
            aux.id=id;
            aux.notas.InicializarCola();
            aux.notas.Acoplar(nota);
            aux.sig=null;
            // HAY CERO ELEMENTOS
            if (primero == null) {
                ultimo=aux;
                primero=ultimo;
            }
            // HAY ELEMENTO Y AGREGAMOS UNO NUEVO
            else {
                ultimo.sig=aux;
                ultimo=aux; // * HAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY
            }
        } 
        // ! OJO CON USAR UN SOLO NODO PARA VARIAS COSA A LA VEZ
        }

    public void BorrarAlumno(int id){
        if (idAlumnos.Pertenece(id)) {
            idAlumnos.Sacar(id); // ! MIRA QUE VARIABLE ESTAS AFECTANDO
            cantidadAlumnos--;
            if (primero.id == id) {
                primero=primero.sig;
            }
            else {
                Nodo recorrer = new Nodo();
                recorrer=primero;
                while (recorrer.sig != null && recorrer.sig.id != id) {
                    recorrer=recorrer.sig;
                }
                if ( recorrer.sig.id == id ) {
                    recorrer.sig=recorrer.sig.sig;
                }
            } 
        }
    }
}
