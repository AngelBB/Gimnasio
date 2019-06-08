/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasioxml;

/**
 *
 * @author 2dai
 */
public class Cliente {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private int tlf;
    
    
   public Cliente(){
        this.dni="";
        this.nombre="";
        this.apellidos="";
        this.tlf=0;
    }
    
    public Cliente(String dni, String nombre, String apellidos,int tlf){
        this.dni=dni;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.tlf=tlf;
    }
    
    //Getter - setter
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTlf() {
        return Integer.toString(tlf);
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }
     
    //Para sacar los datos de un cliente 
    public String cadenaInfoCliente(){
           String cadena="";
            cadena="Dni: "+this.dni+"\nNombre: "+this.nombre
                    +"\nApellidos: "+this.apellidos+"\nTlf: "+this.tlf+"\n";
        
            return cadena;//enviamos una cadena para que se mueste donde queramos
    }
}
