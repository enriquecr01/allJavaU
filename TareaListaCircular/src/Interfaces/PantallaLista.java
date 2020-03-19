package Interfaces;
import Clases.listaCircular;
import Clases.Nodo;

public class PantallaLista 
{
    public void desplegarResultados(int reporteResultado)
    {
        switch(reporteResultado)
        {
            case 1: System.out.println("Las listas son iguales en tamaño y contenido"); break;
            case 2: System.out.println("Las listas son iguales en tamaño pero no en contenido"); break;
            case 3: System.out.println("Las listas NO tienen el mismo tamaño ni contenido."); break;
        }
    }
    
    public void comprobar(listaCircular c1, listaCircular c2)
    {
        Nodo n1 = c1.getInicio();
        Nodo n2 = c2.getInicio();
        boolean diferente = false;
        int reporte = 0, contadorLista1 = 0, contadorLista2 = 0, auxCont = 0;
        
        /*Do while para contar los elementos de la lista 1 */
        do
        {
            n1 = n1.getSig();
            contadorLista1++;
        }while(n1 != c1.getInicio());

        /*Do while para contar los elementos de la lista 2 */
        do
        {
            n2 = n2.getSig();
            contadorLista2++;
        }while(n2 != c2.getInicio());

        if(contadorLista1 == contadorLista2) 
        {
            reporte = 2;
        }

        else reporte = 3;
        
        if(reporte == 2)
        {
            do
            {
                if (n1.getDatostr().equals(n2.getDatostr()) && n1.getDatoint() == n2.getDatoint())
                {
                    n1 = n1.getSig();
                    n2 = n2.getSig();
                    auxCont++;
                    if(auxCont == contadorLista1)
                    {
                        diferente = true;
                        reporte = 1;
                    }
                }
                else diferente = true;
                
            }while(!diferente);
        }
        
        desplegarResultados(reporte);
    }
    
    
}
