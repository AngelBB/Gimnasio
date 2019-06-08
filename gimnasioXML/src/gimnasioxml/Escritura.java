/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasioxml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angel
 */
public class Escritura {
    //Creamos una instancia de xstream
    static XStream xstream=new XStream();
    public static void main(String[] args) {
    
        try{
               
            /*De la misma que insertamos tambien actualizariamos.
            es decir la una diferencia es que sacamos los datos del xml
            y a continuacion lo editamos y lo volvemos a introducir al xml*/
           
            
            /*INSERTAR RESERVA*/
            //Creamos un objeto reserva
            Reserva r=new Reserva();
                
            //Creamos un cliente y una maquina los asociamos a reserva
            Cliente c1=new Cliente("111111111A","Perico","Malababa Pava",111111111);
            Maquina m=new Maquina(1,"Banco de pesas");
            r.setCli(c1);
            r.setMaq(m);
                
            //Terminamos de rellenar la reserva
            r.setFecha("21/02/2015");
            r.setHora("18:00");
            //Instanciamos el metodo toXML pasamos como atributos el objeto Reservas
            //y un FileOutputStream
            xstream.setClassLoader(Reserva.class.getClassLoader());
            xstream.toXML(r, new FileOutputStream("basededatos.xml"));

            
            
            /*** SACAR DATOS ***/
                xstream.setClassLoader(Reserva.class.getClassLoader());
                // Asociamos la etiqueta XML con la clase
                xstream.alias("reserva", Reserva.class);
                // Obtenemos del XML la clase cargada
                Reserva miReserva = (Reserva) xstream.fromXML(new FileInputStream("basededatos.xml"));//OJO: Ponemos FileInputStream en vez de FileOutputStream
            
            //Mostramos los datos
                System.out.println(miReserva.getCli().cadenaInfoCliente()+"\n");
                System.out.println(miReserva.getMaq().cadenaInfoMaquina()+"\n");
            /******/
            
            
            /*INSERTAR CLIENTE*/
            Cliente c2=new Cliente("22222222A","Marta","Escudero Iraola",111111111);
            xstream.addImplicitCollection(Cliente.class, "cliente");
            xstream.toXML(c2, new FileOutputStream("basededatos.xml"));

            /*INSERTAR MAQUINA*/
            Maquina m2=new Maquina(1,"Bici estatica");
            xstream.addImplicitCollection(Maquina.class, "maquina");
            xstream.toXML(c2, new FileOutputStream("basededatos.xml"));

            /******************************/
            /*LISTAR CLIENTE*/
            Cliente c3 = (Cliente)xstream.fromXML(new FileInputStream("basededatos.xml"));
            System.out.println(c3.cadenaInfoCliente());
            
            
            /*LISTAR MAQUINA*/
            Maquina m3 = (Maquina)xstream.fromXML(new FileInputStream("basededatos.xml"));
            System.out.println(m3.cadenaInfoMaquina());
            
            /*LISTAR RESERVAS*/
            Reserva r3=(Reserva)xstream.fromXML(new FileInputStream("basededatos.xml"));
            System.out.println("cliente:"+r3.getCli().cadenaInfoCliente()+
                                    "maquina: "+r3.getMaq().cadenaInfoMaquina()+
                                    "fecha"+r3.getFecha()+"\n"+
                                    "hora"+r3.getHora()+"\n\n");
            
            
            }catch(FileNotFoundException ex){
                System.err.println(ex.getMessage());
            }
    }
}
