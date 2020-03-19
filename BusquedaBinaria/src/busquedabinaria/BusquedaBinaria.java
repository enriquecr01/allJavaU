/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busquedabinaria;
import java.util.Scanner;
/**
 *
 * @author emrique
 */
public class BusquedaBinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        SecuenciaBinaria();
    }
    
    public static void SecuenciaBinaria()
    {
       int[] a = {4,8,12,15,17,20};
       System.out.println("Ingrese un numero a buscar");
       Scanner teclado = new Scanner(System.in);
       int num = teclado.nextInt();
       int i=0;
       int f = a.length-1;
       int c=0;
       boolean found = false;
       while(i <= f && !found)
       {
    	   c = (i+f)/2;
    	   if(num==a[c])
    	   {
                    for(int j = 0; j<a.length; j++)
                    {
                         if (j == c) { System.out.print("_" + a[j] + "_,"); }//if

                         else if (j == i) { System.out.print("_" + a[j] + "_,"); }//if

                         else if (j == f) { System.out.print("_" + a[j] + "_,"); }//if

                         else { System.out.print(a[j] + ", "); }
                    }
                    System.out.println("");
    		   System.out.println("valor encontrado: " + c);
    		   found = true;
    	   }
           else if(num < a[c])
    	   {
               /**********************************/
               for(int j = 0; j<a.length; j++)
               {
                    if (j == c) { System.out.print("_" + a[j] + "_,"); }//if
                    
                    else if (j == i) { System.out.print("_" + a[j] + "_,"); }//if
                    
                    else if (j == f) { System.out.print("_" + a[j] + "_,"); }//if
                    
                    else { System.out.print(a[j] + ", "); }
               }
               /**********************************/
               System.out.println("");
               f = c - 1;
               if(i>f) 
               {
                   found = true;
                   System.out.println("El valor " + num + " no fue encontrado");
               }
    	   }
           
           
            else
    	   {
               for(int j = 0; j<a.length; j++)
               {
                    if (j == c) { System.out.print("_" + a[j] + "_,"); }//if
                    
                    else if (j == i) { System.out.print("_" + a[j] + "_,"); }//if
                    
                    else if (j == f) { System.out.print("_" + a[j] + "_,"); }//if
                    
                    else { System.out.print(a[j] + ", "); }
               }
               System.out.println("");
                i = c + 1;
                
                if(i>f) 
                {
                    found = true;
                    System.out.println("El valor " + num + " no fue encontrado");
                }   
           }
       }
       
       
    }
    
}
