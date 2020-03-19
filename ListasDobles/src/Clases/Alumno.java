package Clases;

public class Alumno 
{
    private String nombre;
    private int matricula;
    private int edad;
    private Alumno siguiente;
    private Alumno anterior;
    
    //Setter & Getters Nombre
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    //Setter & Getters Matricula
    public int getMatricula() { return matricula; }
    public void setMatricula(int matricula) { this.matricula = matricula; }
    
    //Setter & Getters Edad
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    //Setter & Getters Siguiente
    public Alumno getSiguiente() { return siguiente; }
    public void setSiguiente(Alumno siguiente) { this.siguiente = siguiente; }
    
    //Setter & Getters Anterior
    public Alumno getAnterior() { return anterior; }
    public void setAnterior(Alumno anterior) { this.anterior = anterior; }
    
    public Alumno()
    {
        this.nombre = "";
        this.matricula = 0;
        this.edad = 18;
        this.siguiente = null;
        this.anterior = null;
    }//constructor
    
    public Alumno(String nombre, int matricula, int edad)
    {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.siguiente = null;
        this.anterior = null;
    }//constructor
    
    public String toString() 
    { 
        return "Nombre: " + this.nombre + "\nMatricula: " + this.matricula + "\nEdad: " + this.edad;
    } 
    
}
