package Clases;

public class Nodo {
    private String datostr;
    private int datoint;
    private Nodo sig;
    
    public Nodo(){
        datostr = "";
        datoint = 0;
        sig = null;
    }
    
    public Nodo(String datostr){
        this.datostr = datostr;
        datoint = 0;
        sig = null;
    }
    
    public Nodo(int datoint){
        this.datoint = datoint;
        datostr = "";
        sig = null;
    }
    
    public Nodo(String datostr, int datoint){
        this.datostr = datostr;
        this.datoint = datoint;
        sig = null;
    }
    
    public void setDatostr(String datostr){ this.datostr = datostr; }
    public String getDatostr() { return datostr; }
    public void setDatoint(int datoint) { this.datoint = datoint; }
    public int getDatoint() { return datoint; }
    public void setSig(Nodo sig) { this.sig = sig; }
    public Nodo getSig(){ return sig; }
    
    @Override
    public String toString(){
        return "Dato entero: " + datoint + "; Dato String: " + datostr;
    }
}
