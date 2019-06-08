/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasiodb4o;


/**
 *
 * @author Angel
 */
public class Reserva {
    
    private Cliente cli;
    private Maquina maq;
    private String fecha;
    private String hora;

    public Reserva(Cliente cli, Maquina maq, String fecha, String hora) {
        this.cli = cli;
        this.maq = maq;
        this.fecha = fecha;
        this.hora = hora;
    }
        
    public Reserva(){
        this.cli=null;
        this.fecha=null;
        this.hora=null;
        this.maq=null;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Maquina getMaq() {
        return maq;
    }

    public void setMaq(Maquina maq) {
        this.maq = maq;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}