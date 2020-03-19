package Clases;

public class Cliente 
{
    private String nombre;
    private int matricula;
    private Cliente siguiente;
    private Cliente anterior;
    
    //Setter & Getters Nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    //Setter & Getters Matricula
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }

    //Setter & Getters Siguiente
    public Cliente getSiguiente() { return siguiente; }
    public void setSiguiente(Cliente siguiente) { this.siguiente = siguiente; }
    
    //Setter & Getters Anterior
    public Cliente getAnterior() { return anterior; }
    public void setAnterior(Cliente anterior) { this.anterior = anterior; }
    
    public Cliente()
    {
        this.nombre = "";
        this.matricula = 0;
        this.siguiente = null;
        this.anterior = null;
    }//constructor
    
    public Cliente(String nombre, int matricula)
    {
        this.nombre = nombre;
        this.matricula = matricula;
        this.siguiente = null;
        this.anterior = null;
    }//constructor
    
    public String toString() 
    { 
        return "Nombre: " + this.nombre + "\nMatricula: " + this.matricula;
    } 
    
}
