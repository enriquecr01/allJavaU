/*
*****Enrique Chavez Romero 4B******
 */
package fibonacci;
import java.util.Scanner;
/**
 *
 * @author Enrique Chavez Romero 4B
 */
public class Integradora2Recursividad 
{
    public static int cont3=2;
    public static int tope1;
    public static int[] fibo = new int[10000];
    public static int n1=0;
    public static int n2=1;
    public static void main(String[] args) 
    {
        Scanner scn = new Scanner(System.in);
        int opcion=0, opcionR=0;
        int tope = 0;
        do
        {
            System.out.println("1.- Fibonacci Recursivo");
            System.out.println("2.- Fibonacci Ciclo");
            System.out.println("3.- Suma Recursiva");
            System.out.println("4.- Salir");
            System.out.print("Opcion:  ");
            opcion = scn.nextInt();
            switch(opcion)
            {
                case 1: 
                    System.out.print("Tope: ");
                    tope = scn.nextInt();
                    tope1=tope;
                    fibo[0] = 0;
                    fibo[1] = 1;
                    System.out.print(fibo[cont3] + ", ");
                    fibonacci(tope);
                    break;
                case 2:
                    System.out.print("Tope: ");
                    tope = scn.nextInt();
                    int[] arreglo = new int[tope];
                    arreglo[0] = 0;
                    arreglo[1] = 1;
                    System.out.print(arreglo[0] + ", " + arreglo[1] + ", ");
                    for(int i=2; i<tope-1;i++)
                    {
                        arreglo[i] = arreglo[i-1] + arreglo[i-2];
                        System.out.print(arreglo[i] + ", ");
                    }//for
                    break;
                case 3:
                    sumaRecursiva(opcionR);
                    break;
            }//switch
        }while(opcion != 4);

    }//main
    
    public static int fibonacci(int tope)
    {
        cont3++;
        if (tope<0)
            return 0;
        else
        {
            fibo[cont3] = fibo[cont3-1] + fibo[cont3-2];
            System.out.print(fibo[cont3] + ", ");
            
            //n1 = n1+n2;
            //System.out.print(n1 +", ");
            return fibonacci(tope - 1);
            //return fibonacci(tope - 1);
        }//else
        
    }//fibonacci
    
    public static int sumaRecursiva(int opcion)
    {
        if(opcion==2)
        {
            return 0;
        }//if
        else
        {
            int n1, n2,opc;
            Scanner sc = new Scanner(System.in);
            System.out.print("Numero 1: ");
            n1 = sc.nextInt();
            System.out.print("Numero 2: ");
            n2 = sc.nextInt();
            System.out.println("Resultado: " + (n1+n2));
            System.out.println("1.- Otra Suma");
            System.out.println("2.- Salir");
            System.out.print("Opcion: ");
            opc = sc.nextInt();
            return 1 + sumaRecursiva(opc);
        }//else
    }//sumaRecursiva
    
    
}//class
