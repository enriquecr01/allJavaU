package Clases;

public class listaCircular 
{
    private Nodo inicio;
    private Nodo fin;
    
    public Nodo getInicio() { return inicio; }

    public void setInicio(Nodo inicio) { this.inicio = inicio; }

    public Nodo getFin() { return fin; }

    public void setFin(Nodo fin) { this.fin = fin; }
    
    public listaCircular()
    {
        this.inicio = null;
        this.fin = null;
    }
    
    public boolean vacia()
    {
        if(getInicio() == null ) return true;
        else return false;
    }
    
    public void agregar(Nodo elemento)//agrega al final
    {
        if(vacia())
            inicio = elemento;
        else
            fin.setSig(elemento);
        
        fin = elemento;
        fin.setSig(inicio);
    }
    
    public void agregarInicio(Nodo elemento)
    {
        if(vacia())
            agregar(elemento);
        else
        {
            fin.setSig(elemento);
            elemento.setSig(inicio);
            inicio = elemento;
        }
            
    }
    
    public void agregarEnMedio(Nodo elemento, String buscar)
    {
        if(vacia())
        {
            agregar(elemento);
        }
        else
        {
            Nodo i = inicio;
            boolean encontrado = false;
            do
            {
                if(i.getDatostr().equals(buscar))
                {
                    encontrado = true;
                    elemento.setSig(i.getSig());
                    i.setSig(elemento);
                    if(inicio == fin || i == fin) { fin = elemento; }
                }
                i = i.getSig();
                
            }while(!encontrado && i != fin.getSig());
            
            if(!encontrado) { agregar(elemento); }
            
        }
    }
    
    public void desplegar()
    {
        if(!vacia())
        {
            Nodo i = inicio;
            do
            {
                System.out.println("Dato: " + i.getDatostr());
                i = i.getSig();
            }while(i != fin.getSig());
        }
    }
    
    
    
    
    
}
