package impl;

import api.AlumnoNotasTDA;
import api.ConjuntoTDA;
import api.ColaTDA;

import javax.print.attribute.standard.Sides;

import algoritmos.metodosCola;

public class AlumnoNotasDinamico implements AlumnoNotasTDA{
    class Nodo{
        int id;
        ColaTDA notas= new ColaDinamica();
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    ConjuntoTDA Alumnos=new ConjuntosDinamico();

    int cantidadAlumnos;
    int totalNotas;

    public void InicializacionAlumnoNota(){
        primero=null;
        ultimo=null;
        Alumnos.InicializarConjunto();
        cantidadAlumnos=0;
        totalNotas=0;
    }

    public void NotasAlumno(int id){ //mostra las notas del alumnos
        if (Alumnos.Pertenece(id)) {
            Nodo aux=new Nodo();
            aux=primero;
            while (aux !=null && aux.id != id) {
                aux=aux.sig;
            }
            ColaTDA colaAux= new ColaDinamica();
            metodosCola.copiarCola(aux.notas,colaAux);
            while (!colaAux.ColaVacia()) {
                System.out.println(colaAux.Primero());
                colaAux.DesAcoplar();
            }
        }
    }
    public double PromedioAlumno(int id){
        double resultado=0;
        if (Alumnos.Pertenece(id)) {
            double  notasAlumnoTotal=0;
            double cantidadExamen=0;
            Nodo aux=new Nodo();
            aux=primero;
            while (aux !=null && aux.id != id) {
                aux=aux.sig;
            }
            ColaTDA colaAux1= new ColaDinamica();
            metodosCola.copiarCola(aux.notas,colaAux1);
            while (!colaAux1.ColaVacia()) {
                cantidadExamen++;
                notasAlumnoTotal+=colaAux1.Primero();
                colaAux1.DesAcoplar();
            }
            resultado= notasAlumnoTotal / cantidadExamen;
        }
        return resultado;
    }


    public double PromedioGrupal(){
        double resultado=0;
        if (primero != null) {
            resultado= totalNotas / cantidadAlumnos;
        }
        return resultado;
    }

    public void AlumnosAprobados(){ // ! solo hay dos element6os 
        if (!Alumnos.ConjuntoVacion()) {
            Nodo aux=new Nodo();
            aux=primero;
            while (aux !=null) {
                if (PromedioAlumno(aux.id) >= 4) {
                    System.out.println(aux.id);
                }
                aux=aux.sig;
            }
        }
    }


    public void AltaNota(int id , int nota){
        // ! OJO CON USAR UN SOLO NODO PARA VARIAS COSA A LA VEZ
        // ESTA EL LA LISTA DE NODO
        if (Alumnos.Pertenece(id) && nota >= 0 && nota <= 10) {
            Nodo recorrerNodo=new Nodo();
            recorrerNodo=primero;
            while (recorrerNodo !=null && recorrerNodo.id != id) {
                recorrerNodo=recorrerNodo.sig;
            }
            if (recorrerNodo.id==id) {
                totalNotas+=nota;
                recorrerNodo.notas.Acoplar(nota);
            }
        }
        // HAY CERO ELEMENTOS
        else if (primero == null && nota >= 0 && nota <= 10) {
            Nodo aux=new Nodo();
            Alumnos.Agregar(id);
            cantidadAlumnos++;
            totalNotas+=nota;

            aux.id=id;
            aux.notas.InicializarCola();
            aux.notas.Acoplar(nota);

            primero=aux;
            ultimo=primero;
        }
        // HAY ELEMENTO Y AGREGAMOS UNO NUEVO
        else if (primero != null && nota >= 0 && nota <= 10) {  
            Nodo aux=new Nodo();
            Alumnos.Agregar(id);
            cantidadAlumnos++;
            totalNotas+=nota;

            aux.id=id;
            aux.notas.InicializarCola();
            aux.notas.Acoplar(nota);
            ultimo.sig=aux;
            aux=ultimo;
        }
        
        

    }
    public void BorrarAlumno(int id){
        if (Alumnos.Pertenece(id)) {
            if (primero.id == id) {
                while (!primero.notas.ColaVacia()) {
                    totalNotas-=primero.notas.Primero();
                    primero.notas.DesAcoplar();
                }
                primero=primero.sig;
            }
            else {
                Nodo recorrer = new Nodo();
                recorrer=primero;
                while (recorrer.sig != null && recorrer.sig.id != id) {
                    recorrer=recorrer.sig;
                }
                while (!recorrer.sig.notas.ColaVacia()) {
                    totalNotas-=recorrer.sig.notas.Primero();
                    recorrer.sig.notas.DesAcoplar();
                }
                if ( recorrer.sig != null &&  recorrer.sig.id == id ) {
                    recorrer.sig=recorrer.sig.sig;
                }
            }
            Alumnos.Sacar(id); // ! MIRA QUE VARIABLE ESTAS AFECTANDO
            cantidadAlumnos--;
        }
    }
}
