package Interfaz;

import Clases.Alumno;
import Clases.ListaDoble;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pantalla1 
{
    Scanner teclado = new Scanner(System.in);
    /*rep de repuesto como queda la linea de enter en el buffer entonces este la leera*/
    Scanner rep = new Scanner(System.in);
    static ListaDoble grupoB = new ListaDoble();
    static Alumno apuntador = new Alumno();
    
    public void menu()
    {
        
        int opc= 0;
        do
        {
            imprimirMenu();
            System.out.print("Opcion: ");
            opc = teclado.nextInt();
            switch(opc)
            {
                case 1:
                    crearLista(grupoB);
                    break;
                case 2:
                    agregar();
                    break;
                case 3: 
                    agregarInicio();
                    break;
                case 4:
                    agregarEnMedio();
                    break;
                case 5:
                    desplegar();
                    break;
            }
        }while(opc != 9);
    }//
    
    private void imprimirMenu()
    {
        System.out.println("1.- Crear Lista");
        System.out.println("2.- Agregar al Final");
        System.out.println("3.- Agregar al Inicio");
        System.out.println("4.- Agregar en Medio");
        System.out.println("5.- Desplegar");
        System.out.println("9.- Salir");
    }//menu
    
    public void agregar()
    {
        String nombre;
        boolean seguir=true;
        int edad = 1, matricula = 0;
        System.out.println("Agregando al alumno");
        nombre = leerNombre();
        
        do
        {
            matricula = leerMatricula();
            if(matricula==1) { seguir = true; }
            else { seguir = false; }
        }while(seguir);
        
        seguir=true;
        
        do
        {
            edad = leerEdad();
            if(edad==1) { seguir = true; }
            else { seguir = false; }
        }while(seguir);
        
        Alumno tsu = new Alumno(nombre, matricula, edad);
        grupoB.AgregarFinal(tsu);
        
        
    }//agregar
    
    public void agregarInicio()
    {
        String nombre;
        boolean seguir=true;
        int edad = 1, matricula = 0;
        System.out.println("Agregando al alumno");
        nombre = leerNombre();
        
        do
        {
            matricula = leerMatricula();
            if(matricula==1) { seguir = true; }
            else { seguir = false; }
        }while(seguir);
        
        seguir=true;
        
        do
        {
            edad = leerEdad();
            if(edad==1) { seguir = true; }
            else { seguir = false; }
        }while(seguir);
        
        Alumno tsu = new Alumno(nombre, matricula, edad);
        grupoB.AgregarInicio(tsu);
        
        
    }//agregar
    
    public void agregarEnMedio()
    {
        String nombre;
        boolean seguir=true;
        int edad = 1, matricula = 0;
        System.out.println("Agregando al alumno");
        nombre = leerNombre();
        
        do
        {
            matricula = leerMatricula();
            if(matricula==1) { seguir = true; }
            else { seguir = false; }
        }while(seguir);
        
        seguir=true;
        
        do
        {
            edad = leerEdad();
            if(edad==1) { seguir = true; }
            else { seguir = false; }
        }while(seguir);
        
        Alumno tsu = new Alumno(nombre, matricula, edad);
        String nombreBuscar = "";
        System.out.print("Agregar despues de: ");
        nombreBuscar = teclado.next();
        System.out.print(nombreBuscar);
    
        grupoB.AgregarEnMedio(tsu, nombreBuscar);
        
        
    }//agregar
    
    private int leerEdad()
    {
        int edad=0;
        do
        {
            System.out.print("Edad: ");
            try
            {
                
                edad = teclado.nextInt();
            }
            catch(Exception ex)
            {
                teclado.nextLine();
                System.out.println("Solo numeros");
                edad=1;
            }
        }while(edad < 0 || edad > 120);
        return edad;
    }
    
    private String leerNombre()
    {
        String nombre="";
        boolean seguir=true;
        do
        {
            try
            {
                System.out.print("Nombre: ");
                nombre = teclado.next();
                seguir=false;
            }
            catch(Exception ex)
            {
                System.out.print("Nombre no aceptado");
            }
        }while(seguir);
        return nombre;
    }
    
    private static ListaDoble crearLista(ListaDoble grupoB)
    {
        System.out.println("Lista creada homie");
        return grupoB = new ListaDoble();
    }
    
    public static void desplegar()
    {
        apuntador = grupoB.getInicio();
        System.out.println("-----------------------------------------");
        do
        {
            System.out.println(apuntador.toString());
            System.out.println("-----------------------------------------");
            apuntador = apuntador.getSiguiente();
        }while(apuntador != null);//dowhile
    }//desplegar
    
    public int leerMatricula()
    {
        int matricula=0;
        System.out.print("Matricula: ");
            try
            {
                matricula = teclado.nextInt();
            }
            catch(InputMismatchException ex)
            {
                teclado.nextLine();
                System.out.println("Matricula invalida");
                matricula=1;
            }
        return matricula;
    }
    
}
