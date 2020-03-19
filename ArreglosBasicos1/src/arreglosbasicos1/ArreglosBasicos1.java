/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglosbasicos1;
import java.util.Scanner;
/**
 *
 * @author emrique
 */
public class ArreglosBasicos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        String[] pacientes = {"[Espacio disponible]","[Espacio disponible]","[Espacio disponible]", 
            "[Espacio disponible]", "[Espacio disponible]", "[Espacio disponible]", 
            "[Espacio disponible]", "[Espacio disponible]", "[Espacio disponible]", 
            "[Espacio disponible]"};
        int opcion=0, i;
        String aux;
        boolean recorrer = true;
        do
        {
            i = 0;
            recorrer = true;
            System.out.println("1.- Listado de pacientes.");
            System.out.println("2.- Asigne un turno.");
            System.out.println("3.- Atienda turno.");
            System.out.println("4.- Turnos disponibles.");
            System.out.println("5.- Salir.");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();

            switch(opcion)
            {
                case 1: 
                    for (i = 0; i<pacientes.length; i++)
                    {
                        System.out.println((i+1) + ".- " + pacientes[i]);
                    }
                    System.out.println("");
                    break;

                case 2:
                    i=0;
                    do
                    {
                        if (pacientes[i].equals("[Espacio disponible]"))
                        {
                            recorrer = false;
                        }//if
                        else
                        {
                            i++;
                        }//else
                                
                    }while(i < pacientes.length && recorrer);
                    
                    if(recorrer)
                    {
                        System.out.println("No hay espacios disponibles");
                    }//if
                    else 
                    {
                        System.out.print("Nombre del paciente con turno " + (i+1) + ": ");
                        pacientes[i] = teclado.next();
                        System.out.println(pacientes[i] + " a sido asignado a la lista de espera con el numero "+ (i+1) + "!");
                    }//else
                    break;
                case 3: 
                    if (pacientes[0].equals("[Espacio disponible]"))
                    {
                        System.out.println("No hay pacientes por atender.");
                    }
                    else
                    {
                        System.out.println("Atender paciente " + pacientes[0] + "?");
                        System.out.print("1.- Si 2.- No: ");
                        opcion = teclado.nextInt();
                        if(opcion == 1)
                        {
                            for(i=0; i<pacientes.length-1;i++)
                            {
                                pacientes[i] = pacientes[i+1];
                            }//for
                            pacientes[9] = "[Espacio disponible]";
                        }//if
                    }//else
                    break;
                
                case 4: 
                    do
                    {
                        if (pacientes[i].equals("[Espacio disponible]"))
                        {
                            System.out.println("Esta disponible el turno: " + (i + 1));
                            i++;
                            recorrer = true;
                        }//if
                        else
                        {
                            i++;
                            recorrer = false;
                        }//else
                                
                    }while(i < pacientes.length);
                    if(!recorrer)
                    {
                        System.out.println("No hay turnos disponibles, por el momento");
                    }//if
                    break;
                default:
                    System.out.println("Seleccione una de las opciones anteriores.");
                    break;
            }//Switch
        }while(opcion != 5);//while
    }//Main
    
}
