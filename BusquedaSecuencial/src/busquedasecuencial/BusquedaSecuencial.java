/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedasecuencial;
import java.util.Scanner;

/**
 *
 * @author emrique
 */
public class BusquedaSecuencial {

    public static void main(String[] args) 
    {
        
        int i=0, num = 0;
        int[] a = {4,8,12,15,18,20};
        boolean recorrer = true;
        Scanner scn = new Scanner(System.in);
        System.out.print("Escribe el numero: ");
        num = scn.nextInt();
        do
        {
            if (num == a[i])
            {
                recorrer = false;
                System.out.println("El valor esta en " + i);
            }//if
            else
            {
                i++;
            }//else                              
        }while(i < a.length && recorrer);
        
        if(recorrer)
        {
            System.out.print("El valor " + num + " no se encontro");
        }
    }
    
}
