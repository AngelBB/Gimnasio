/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasioxml;

/**
 *
 * @author Angel
 */
public class Maquina {
    
    int id;
    String nombre;

    public Maquina(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String cadenaInfoMaquina(){
        String cadena="";
                cadena="id: "+this.id+"\nNombre: "+this.nombre+"\n";
        return cadena;
    }
}
