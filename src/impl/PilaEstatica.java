package impl; /* Una forma de organizar las clases donde agrupa clases en paquetes (paquete de pilas o de colas) */

import api.PilaTDA;

public class PilaEstatica  implements PilaTDA{
    int[] vector; 
    int i;

    public void InicializarPila(){
        vector = new int[100];
        i = 0;
    }
    public void Apilar(int x){
        vector[i]=x;
        i++;
    }
    public void Desapilar(){
        i--;
    }
    
    public int Tope(){
        return (vector[i-1]);
    }

    public boolean PilaVacia(){
        return (i==0);
    }
}
