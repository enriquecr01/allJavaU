/* Enrique Chavez Romero 4B */
package tarealistacircular;
import Clases.Nodo;
import Clases.listaCircular;
import Interfaces.PantallaLista;

/*Ejercicio*/
/*
Ingresar 2 listas doblemente enlazadas y reportar: 

a) Si las listas son iguales en tamaño y contenido 
b) Si las listas son iguales en tamaño pero no en contenido 
c) No tienen el mismo tamaño ni contenido. 

https://es.scribd.com/document/267499205/Ejercicios-de-Listas-Enlazadas-Dobles-y-Circulares
*/

public class TareaListaCircular 
{

    public static void main(String[] args) 
    {
        //Creacion del objeto de interfaz
        PantallaLista pl = new PantallaLista();
        //Creacion de las listas
        listaCircular cl1 = new listaCircular();
        listaCircular cl2 = new listaCircular();
        
        
        //Añadir datos todos son iguales para 
        //comprobar la situacion del inciso a)
        cl1.agregar(new Nodo("Ejemplo0" , 1));
        cl1.agregar(new Nodo("Ejemplo1" , 2));
        cl1.agregar(new Nodo("Ejemplo2" , 3));
        
        cl2.agregar(new Nodo("Ejemplo0" , 1));
        cl2.agregar(new Nodo("Ejemplo1" , 2));
        cl2.agregar(new Nodo("Ejemplo2" , 3));
        
        
        /*
        //Añadir datos uno es diferente para 
        //comprobar la situacion del inciso b)
        cl1.agregar(new Nodo("Ejemplo0" , 1));
        cl1.agregar(new Nodo("Ejemplo1" , 2));
        cl1.agregar(new Nodo("Ejemplo2" , 3));
        
        cl2.agregar(new Nodo("Ejemplo0" , 1));
        cl2.agregar(new Nodo("Ejemplo1" , 2));
        cl2.agregar(new Nodo("Ejemplo63" , 3));
        */
        
        /*
        //Añadir datos no hay un dato en la lista c1 
        //comprobar la situacion del inciso c)
        cl1.agregar(new Nodo("Ejemplo0" , 1));
        cl1.agregar(new Nodo("Ejemplo1" , 2));
        cl1.agregar(new Nodo("Ejemplo2" , 3));
        
        cl2.agregar(new Nodo("Ejemplo0" , 1));
        cl2.agregar(new Nodo("Ejemplo1" , 2));
        */
        
        
        pl.comprobar(cl1, cl2);
        
    }
    
}
