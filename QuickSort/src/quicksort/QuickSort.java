package quicksort;
import java.util.Scanner;

/**
 *
 * @author alumnotic
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        int[] a = {3,0,1,8,7,2,5,4,9,6};
        int inicio = 0;
        int fin = a.length-1;
        quicksort(a, inicio, fin);
        for (int n = 0; n < a.length;n++)
        {
            System.out.print(a[n]+", ");
        }
        
    }//main
    
    public static void quicksort(int a[],int inicio, int fin)
    {
        int pivote=a[inicio];
        int auxInicio=inicio; 
        int auxFin=fin;
        int aux;

        while(auxInicio < auxFin)
        {   

           while(a[auxInicio] <= pivote && auxInicio<auxFin) auxInicio++;

           while(a[auxFin]>pivote) auxFin--;   

           if (auxInicio<auxFin) {                                     
               aux= a[auxInicio];                  
               a[auxInicio]=a[auxFin];
               a[auxFin]=aux;
           }
        }
         a[inicio]=a[auxFin]; 
         a[auxFin]=pivote; 
        if(inicio<auxFin-1)
            quicksort(a,inicio,auxFin-1);
         if(auxFin+1 <fin)
            quicksort(a,auxFin+1,fin);
        
    }
}
