
package Clases;

public class ListaDoble 
{
    private Alumno inicio;
    private Alumno fin;

    //Setter & Getters Inicio
    public Alumno getInicio() { return inicio; }
    public void setInicio(Alumno inicio) { this.inicio = inicio; }
    
    //Setter & Getters Fin
   // public Alumno getFin() { return fin; }
    public void setFin(Alumno fin) { this.fin = fin; }
    
    public ListaDoble()
    {
        this.inicio = null;
        this.fin = null;
    }//constructor
    
    public void AgregarFinal(Alumno nuevo)
    {
        if(inicio == null)
        {
            inicio = nuevo;
            fin = nuevo;
        }
        else
        {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }//else
    }//AgregarFinal
    
    public void AgregarInicio (Alumno nuevo)
    {
        if(inicio == null)
        {
            inicio = nuevo;
            fin = nuevo;
        }
        else
        {
            fin.setAnterior(nuevo);
            nuevo.setSiguiente(fin);
            inicio = nuevo;
        }//else
    }//AgregarInicio
    
    public void AgregarEnMedio(Alumno nuevo, String cadena)
    {
        if(inicio == null)
        {
            AgregarFinal(nuevo);
        }
        else
        {
            boolean encontrado = false;
            Alumno i = new Alumno();
            i = inicio;
            while(i != null)
            {
                if(i.getNombre().equals(cadena))
                {
                    System.out.print("entre 0");
                    if(inicio==fin) 
                    { 
                        System.out.print("entre 1");
                        AgregarFinal(nuevo);
                        encontrado = true;
                    }//if
                    else
                    {
                        System.out.print("entre 2");
                        nuevo.setSiguiente(i.getSiguiente());
                        nuevo.setAnterior(i);
                        i.getSiguiente().setAnterior(nuevo);
                        i.setSiguiente(nuevo);
                        encontrado = true;
                    }//else
                }//if
                System.out.print("entre 3");
               i= i.getSiguiente();
            }//while
            if(!encontrado) { AgregarFinal(nuevo); }
        }//else
    }//AgregarFinal
    
}
