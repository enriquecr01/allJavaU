package Clases;

public class ListaDoble 
{
    private Cliente inicio;
    private Cliente fin;

    //Setter & Getters Inicio
    public Cliente getInicio() { return inicio; }
    public void setInicio(Cliente inicio) { this.inicio = inicio; }
    
    //Setter & Getters Fin
    public Cliente getFin() { return fin; }
    public void setFin(Cliente fin) { this.fin = fin; }
    
    public ListaDoble()
    {
        this.inicio = null;
        this.fin = null;
    }//constructor
    
    public void AgregarFinal(Cliente nuevo)
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
    
    public void AgregarInicio (Cliente nuevo)
    {
        if(inicio == null)
        {
            inicio = nuevo;
            fin = nuevo;
        }
        else
        {
            inicio.setAnterior(nuevo);
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }//else
    }//AgregarInicio
    
    public void AgregarEnMedio(Cliente nuevo, String cadena)
    {
        if(inicio == null)
        {
            AgregarFinal(nuevo);
        }
        else
        {
            boolean encontrado = false;
            Cliente i = new Cliente();
            i = inicio;
            while(i != null)
            {
                if(i.getNombre().equals(cadena))
                {
                    if(inicio==fin) 
                    { 
                        AgregarFinal(nuevo);
                        encontrado = true;
                    }//if
                    else
                    {
                        nuevo.setSiguiente(i.getSiguiente());
                        nuevo.setAnterior(i);
                        i.getSiguiente().setAnterior(nuevo);
                        i.setSiguiente(nuevo);
                        encontrado = true;
                    }//else
                }//if
               i= i.getSiguiente();
            }//while
            if(!encontrado) { AgregarFinal(nuevo); }
        }//else
    }//AgregarFinal
    
    public void borrarInicio()
    {
        Cliente aux = new Cliente();
        if(inicio==fin)
        {
            inicio = null;
            fin = null;
        }
        else
        {
            aux = inicio;
            inicio = inicio.getSiguiente();
            aux.setSiguiente(null);
        }
        
    }//borrar
    
        
    public void borrarFinal()
    {
        Cliente aux = new Cliente();
        if(inicio==fin)
        {
            inicio = null;
            fin = null;
        }
        else
        {
            aux = fin;
            fin = fin.getAnterior();
            aux.setAnterior(null);
            fin.setSiguiente(null);
        }
        
    }//borrar
    
    public void borrarMedio(String cadena)
    {
        Cliente aux = new Cliente();
        if(inicio==fin)
        {
            inicio = null;
            fin = null;
        }
        else
        {
            boolean encontrado = false;
            Cliente i = new Cliente();
            i = inicio;
            while(i != null)
            {
                if(i.getNombre().equals(cadena))
                {
                    if(inicio==fin) 
                    {
                        aux.setAnterior(null);
                        fin.setSiguiente(null);
                        encontrado = true;
                    }//if
                    else
                    {
                        aux = i.getSiguiente();
                        Cliente aux2 = new Cliente();
                        Cliente aux3 = new Cliente();
                        
                        aux2 = aux.getSiguiente();
                        aux3 = aux.getAnterior();
                        
                        aux.getAnterior().setSiguiente(aux2);
                        aux.getSiguiente().setAnterior(aux3);
                        aux.setAnterior(null);
                        aux.setSiguiente(null);
                        encontrado = true;
                    }//else
                }//if
                i = i.getSiguiente();
            }//while
        }//else
    }//borrar
    
}
