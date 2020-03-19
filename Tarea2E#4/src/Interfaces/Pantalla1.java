package Interfaces;
import Clases.Cliente;
import Clases.ListaDoble;
import java.util.Scanner;

public class Pantalla1 
{
    static ListaDoble clientes = new ListaDoble();
    Scanner sc = new Scanner(System.in);
    static Cliente apuntador = new Cliente();
    /*rep de repuesto como queda la linea de enter en el buffer entonces este la leera*/
    static Scanner rep = new Scanner(System.in);
    
    public void menu()
    {
        int opcion=0;
        do
        {
            opciones();
            opcion = sc.nextInt();
            switch(opcion)
            {
                case 1:
                    agregarFinal();
                    break;
                case 2:
                    agregarEnMedio();
                    break;
                case 3:
                    break;
                case 4:
                    desplegar();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("El numero no esta dentro del rango.");
                    break;
            }
        }while(opcion != 5);
    }//menu
    
    public void opciones()
    {
        System.out.println("1.- Agregar");
        System.out.println("2.- Se encontro a alguien conocido");
        System.out.println("3.- Atender");
        System.out.println("4.- Desplegar");
        System.out.println("5.- Salir");
        System.out.print("Opcion: ");
    }//opciones
    
    public void agregarFinal()
    {
        String nombre;
        int matricula = 0;
        System.out.println("Agregando al alumno");
        System.out.println("Nombre: ");
        nombre = sc.next();
        System.out.println("Matricula: ");
        matricula = sc.nextInt();
        
        Cliente nuevo = new Cliente(nombre, matricula);
        clientes.AgregarFinal(nuevo);
    }//agregar
    
    public void agregarEnMedio()
    {
        String nombre, buscar;
        int matricula = 0;
        System.out.println("Agregando al alumno");
        System.out.println("Nombre: ");
        nombre = sc.next();
        System.out.println("Matricula: ");
        matricula = sc.nextInt();
        buscar = rep.next();
        System.out.print("Se encontro con: ");
        buscar = sc.next();
        
        Cliente nuevo = new Cliente(nombre, matricula);
        clientes.AgregarEnMedio(nuevo, buscar);
    }
    
    public void atender()
    {
        Cliente i = new Cliente();
        i = clientes.getInicio();
        int cont = 0, aux = 1;
        do
        {
            switch(aux)
            {
                case 1:
                    System.out.println("Se antendio a " + i.getNombre() + " por taquilla 1");
                    aux++;
                    break;
                case 2:
                    System.out.println("Se antendio a " + i.getNombre() + " por taquilla 2");
                    aux++;
                    break;
                case 3:
                    System.out.println("Se antendio a " + i.getNombre() + " por taquilla 3");
                    aux++;
                    break;
                case 4:
                    System.out.println("Se antendio a" + i.getNombre() + " por taquilla 1");
                    aux++;
                    break;
                case 5:
                    System.out.println("Se antendio a " + i.getNombre() + " por taquilla 2");
                    aux++;
                    break;
                case 6:
                    System.out.println("Se antendio a " + i.getNombre() + " por taquilla 1");
                    aux++;
                    break;
                default:
                    cont++;
                    break;
            }//switch
            cont++;
            i = i.getSiguiente();
            clientes.borrarInicio();
        }while(i != null && cont <= 6);//while
        
        clientes.borrarInicio();
    }//atender
    
       
    public static void desplegar()
    {
        apuntador = clientes.getInicio();
        System.out.println("-----------------------------------------");
        do
        {
            System.out.println(apuntador.toString());
            System.out.println("-----------------------------------------");
            apuntador = apuntador.getSiguiente();
        }while(apuntador != null);//dowhile
    }//desplegar
    
    
    public void agregarFinalP(String nombre, int matricula)
    {   
        Cliente nuevo = new Cliente(nombre, matricula);
        clientes.AgregarFinal(nuevo);
    }//agregar
    
    
}
