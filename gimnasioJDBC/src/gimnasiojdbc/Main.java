/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasiojdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class Main {
    
    public static Conexion con=new Conexion();
    

public static void main(String[] args) {
               
    while(true){
            System.out.println("Menu\nOpciones:\n1)Mostrar"
            +"\n2)Agregar\n3)Actualizar\n4)Borrar\n5)Salir");
        
            int i;
            int j;
            Scanner scan=new Scanner(System.in);
            i = scan.nextInt();

            switch(i){
                case 1:
                    System.out.println("Tablas a mostrar:\n1) Tabla Clientes\n2) Tabla maquinas\n3) Tabla reservas");
                    j = scan.nextInt();
                    switch(j){
                        case 1:
                            mostrarCliente();
                            break;
                        case 2:
                            mostrarMaquina();
                            break;
                        case 3:
                            mostrarReserva();
                            break;    
                    }
                    break;
                case 2:
                    
                    System.out.println("Insertar:\n1) Clientes\n2) Maquinas\n3) Reservas");
                    j = scan.nextInt();
                    switch(j){
                        case 1:
                            insertarCliente();
                            break;
                        case 2: 
                            insertarMaquina();
                            break;
                        case 3:
                            insertarReserva();
                            break;    
                    }
                    break;
                case 3:
                   
                    System.out.println("Actualizar:\n1) Tabla Clientes\n2) Tabla maquinas\n3) Tabla reservas");
                    j = scan.nextInt();
                    switch(j){
                        case 1: 
                            actualizarCliente();
                            break;
                        case 2:
                            actualizarMaquina();
                            break;
                        case 3:
                            actualizarReserva();
                            break;    
                    }
                    break;
                case 4:
                    
                    System.out.println("Borrar:\n1) Tabla Clientes\n2) Tabla maquinas\n3) Tabla reservas");
                    j = scan.nextInt();
                    switch(j){
                        case 1:
                            borrarCliente();
                            break;
                        case 2:
                            borrarMaquina();
                            break;
                        case 3:
                            borrarReserva();
                            break;    
                    }
                    break; 
                    
                case 5:
                    System.exit(0);
                    break; 
            }//switch
        }//while
    }//static void main   


/*INSERTAR*/
public static void insertarCliente(){
            String dni,nombre,apellidos,query;
            int telefono;
            Scanner scan=new Scanner(System.in);//Para por el teclado

            System.out.println("\nAgregar nuevo Cliente\n");
            System.out.println("Ingrese el dni porfavor");
            dni=scan.next();

            System.out.println("Ingrese el nombre porfavor: ");
            nombre=scan.next();

            System.out.println("Ingrese lso apellidos: ");
            apellidos=scan.next();

            System.out.println("Ingrese el telefono: ");
            telefono=scan.nextInt();

        try{
            if(!"".equals(dni) && !"".equals(nombre) && !"".equals(apellidos) && telefono>0){//Si la query esta vacia no ejecutamos la consulta
                query="INSERT INTO clientes VALUES('"+dni+"','"+nombre+"','"+apellidos+"',"+telefono+")";
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha Actualizado "+count+"\n\n");
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }
public static void insertarMaquina(){
            String nombre,query;
            int id;
            Scanner scan=new Scanner(System.in);//Para por el teclado

            System.out.println("\nAgregar nueva Maquina\n");
            System.out.println("Ingrese el id");
            id=scan.nextInt();

            System.out.println("Ingrese el nombre porfavor: ");
            nombre=scan.next();
            
        try{
            if(!"".equals(id) && !"".equals(nombre)){//Si la query esta vacia no ejecutamos la consulta
                query="INSERT INTO maquinas VALUES("+id+",'"+nombre+"')";
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha Actualizado "+count+"\n\n");
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
}
public static void insertarReserva(){
            String fecha,hora,query;
            int id_maquina,id_cliente;
            Scanner scan=new Scanner(System.in);//Para por el teclado
            
            System.out.println("\nAgregar nueva Reserva\n");
            System.out.println("Ingrese el id_dni: ");
            id_cliente=scan.nextInt();
            
            System.out.println("Ingrese el id_maquina: ");
            id_maquina=scan.nextInt();
                        
            System.out.println("Ingrese el fecha: ");
            fecha=scan.next();
             
            System.out.println("Ingrese el hora: ");
            hora=scan.next();
            
        try{
            if(!"".equals(fecha) && !"".equals(hora) && id_cliente>0 && id_maquina>0 ){//Si la query esta vacia no ejecutamos la consulta
                query="INSERT INTO reservas VALUES("+id_cliente+","+id_maquina+",'"+fecha+"','"+hora+"')";
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha Actualizado "+count+"\n\n");
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }

/*ACTUALIZAR*/
public static void actualizarCliente(){
//Variables 
int opcion=0;
String cadena,cadenaAux,query="";
Scanner scan=new Scanner(System.in);

while(opcion != 5){
    System.out.println("\n\nActualizar por:\n1) dni\n2) nombre\n3) apellidos\n4) telefono\n5) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el dni:");
                cadena=scan.next();
                System.out.println("Introduce el nuevo dni:");
                cadenaAux=scan.next();
                
                query = "UPDATE clientes SET dni='"+cadenaAux+"' where dni='"+cadena+"'";
            break;

            case 2:
                System.out.println("Introduce el nombre:");
                cadena=scan.next();
                System.out.println("Introduce el nuevo nombre:");
                cadenaAux=scan.next();
                query = "UPDATE clientes SET nombre='"+cadenaAux+"' where nombre='"+cadena+"'";
            break;

            case 3:
                System.out.println("Introduce los apellidos:");
                cadena=scan.next();
                System.out.println("Introduce los nuevos apellidos:");
                cadenaAux=scan.next();
                query = "UPDATE clientes SET apellidos='"+cadenaAux+"' where apellidos='"+cadena+"'";
            break;

            case 4:
                System.out.println("Introduce el telefono:");
                cadena=scan.next();
                System.out.println("Introduce el nuevo telefono:");
                cadenaAux=scan.next();
                query = "UPDATE clientes SET telefono="+cadenaAux+"where telefono='"+cadena+"'";
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha Actualizado "+count+"\n\n");
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}
public static void actualizarMaquina(){
//Variables 
int opcion=0;
String cadena,cadenaAux,query="";
Scanner scan=new Scanner(System.in);

while(opcion != 3){
    System.out.println("\n\nActualizar por:\n1) id\n2) nombre\n3) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el id:");
                cadena=scan.next();
                System.out.println("Introduce el nuevo id:");
                cadenaAux=scan.next();
                
                query = "UPDATE maquinas SET id='"+cadenaAux+"' where id='"+cadena+"'";
            break;

            case 2:
                System.out.println("Introduce el nombre:");
                cadena=scan.next();
                System.out.println("Introduce el nuevo nombre:");
                cadenaAux=scan.next();
                query = "UPDATE maquinas SET nombre='"+cadenaAux+"' where nombre='"+cadena+"'";
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha actualizado "+count+"\n\n");
            }//if
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}
public static void actualizarReserva(){
//Variables 
int opcion=0;
String cadena,cadenaAux,query="";
Scanner scan=new Scanner(System.in);

while(opcion != 5){
    System.out.println("\n\nConsultar por:\n1) id_usuario\n2) id_maquina\n3) fecha\n4) hora\n5) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el id_usuario:");
                cadena=scan.next();
                System.out.println("Introduce el nuevo id_usuario:");
                cadenaAux=scan.next();
                query = "UPDATE reservas SET id_usuario="+cadenaAux+" where id_usuario="+cadena;
            break;

            case 2:
                System.out.println("Introduce el id_maquina:");
                cadena=scan.next();
                System.out.println("Introduce el nuevo id_maquina:");
                cadenaAux=scan.next();
                query = "UPDATE reservas SET id_maquina="+cadenaAux+" where id_maquina="+cadena;
            break;

            case 3:
                System.out.println("Introduce la fecha:");
                cadena=scan.next();
                System.out.println("Introduce la nueva fecha:");
                cadenaAux=scan.next();
                query = "UPDATE reservas SET fecha='"+cadenaAux+"' where fecha='"+cadena+"'";
            break;

            case 4:
                System.out.println("Introduce la hora:");
                cadena=scan.next();
                System.out.println("Introduce la nueva hora:");
                cadenaAux=scan.next();
                query = "UPDATE reservas SET hora='"+cadenaAux+"' where hora='"+cadena+"'";
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha actualizado "+count+"\n\n");
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}

/*BORRAR*/
public static void borrarCliente(){
//Variables 
int opcion=0;
String cadena,query="";
Scanner scan=new Scanner(System.in);

while(opcion != 5){
    System.out.println("\n\nBorrar por:\n1) dni\n2) nombre\n3) apellidos\n4) telefono\n5) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el dni:");
                cadena=scan.next();
                query = "DELETE FROM clientes where dni='"+cadena+"'";
            break;

            case 2:
                System.out.println("Introduce el nombre:");
                cadena=scan.next();
                query = "DELETE FROM clientes where nombre='"+cadena+"'";
            break;

            case 3:
                System.out.println("Introduce el apellidos:");
                cadena=scan.next();
                query = "DELETE FROM clientes where apellidos='"+cadena+"'";
            break;

            case 4:
                System.out.println("Introduce el telefono:");
                cadena=scan.next();
                query = "DELETE FROM clientes where telefono="+cadena;
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha borrado "+count+"\n\n");
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}
public static void borrarMaquina(){
//Variables 
int opcion=0;
String cadena,query="";
Scanner scan=new Scanner(System.in);

while(opcion != 3){
    System.out.println("\n\nConsultar por:\n1) id\n2) nombre\n3) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el id:");
                cadena=scan.next();
                query = "DELETE FROM maquinas where id="+cadena+"";
            break;

            case 2:
                System.out.println("Introduce el nombre:");
                cadena=scan.next();
                query = "DELETE FROM maquinas where nombre='"+cadena+"'";
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha borrado "+count+"\n\n");
            }//if
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}
public static void borrarReserva(){
//Variables 
int opcion=0;
String cadena,query="";
Scanner scan=new Scanner(System.in);

while(opcion != 5){
    System.out.println("\n\nBorrar por:\n1) id_usuario\n2) id_maquina\n3) fecha\n4) hora\n5) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el id_usuario:");
                cadena=scan.next();
                query = "DELETE FROM reservas where id_usuario="+cadena;
            break;

            case 2:
                System.out.println("Introduce el id_maquina:");
                cadena=scan.next();
                query = "DELETE FROM reservas where id_maquina="+cadena;
            break;

            case 3:
                System.out.println("Introduce la fecha:");
                cadena=scan.next();
                query = "DELETE FROM reservas where fecha='"+cadena+"'";
            break;

            case 4:
                System.out.println("Introduce la hora:");
                cadena=scan.next();
                query = "DELETE FROM reservas where hora='"+cadena+"'";
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                int count = stmt.executeUpdate(query);
                System.out.println("\n\nSe ha borrado "+count+"\n\n");
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}

/*LISTAR*/
public static void mostrarCliente(){

//Variables 
int opcion=0;
String cadena,resultado="",query="";
Scanner scan=new Scanner(System.in);

while(opcion != 5){
    System.out.println("\n\nConsultar por:\n1) dni\n2) nombre\n3) apellidos\n4) telefono\n5) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el dni:");
                cadena=scan.next();
                query = "select * from clientes where dni='"+cadena+"'";
            break;

            case 2:
                System.out.println("Introduce el nombre:");
                cadena=scan.next();
                query = "select * from clientes where nombre='"+cadena+"'";
            break;

            case 3:
                System.out.println("Introduce el apellidos:");
                cadena=scan.next();
                query = "select * from clientes where apellidos='"+cadena+"'";
            break;

            case 4:
                System.out.println("Introduce el telefono:");
                cadena=scan.next();
                query = "select * from clientes where telefono="+cadena;
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    resultado+=rs.getString("dni")+"\n";
                    resultado+=rs.getString("nombre")+"\n";
                    resultado+=rs.getString("apellidos")+"\n";
                    resultado+=rs.getString("telefono")+"\n";
                }
            
                System.out.println("\n"+resultado+"\n");
                resultado="";
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}
public static void mostrarMaquina(){
//Variables 
int opcion=0;
String cadena,resultado="",query="";
Scanner scan=new Scanner(System.in);

while(opcion != 3){
    System.out.println("\n\nConsultar por:\n1) id\n2) nombre\n3) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el id:");
                cadena=scan.next();
                query = "select * from maquinas where id="+cadena;
            break;

            case 2:
                System.out.println("Introduce el nombre:");
                cadena=scan.next();
                query = "select * from maquina where nombre='"+cadena+"'";
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    resultado+=rs.getString("id")+"\n";
                    resultado+=rs.getString("nombre")+"\n";
                }
            
                System.out.println("\n\n"+resultado+"\n");
                resultado="";
            }//if
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}        
public static void mostrarReserva(){

//Variables 
int opcion=0;
String cadena,resultado="",query="";
Scanner scan=new Scanner(System.in);

while(opcion != 5){
    System.out.println("\n\nConsultar por:\n1) id_usuario\n2) id_maquina\n3) fecha\n4) hora\n5) Salir\n\n");
    opcion = scan.nextInt();
        switch(opcion){
            case 1:
                System.out.println("Introduce el id_usuario:");
                cadena=scan.next();
                query = "select * from reservas where id_usuario="+cadena;
            break;

            case 2:
                System.out.println("Introduce el id_maquina:");
                cadena=scan.next();
                query = "select * from reservas where id_maquina="+cadena;
            break;

            case 3:
                System.out.println("Introduce la fecha:");
                cadena=scan.next();
                query = "select * from reservas where fecha='"+cadena+"'";
            break;

            case 4:
                System.out.println("Introduce la hora:");
                cadena=scan.next();
                query = "select * from reservas where hora='"+cadena+"'";
            break;
        }//switch
        try{
            if(!"".equals(query)){//Si la query esta vacia no ejecutamos la consulta
                Connection on =con.conexionDefault();
                Statement stmt = null;           
                stmt = on.createStatement();//Utilizamos nuestra clase de conexion y le pasamos el string
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    resultado+=rs.getString("id_usuario")+"\n";
                    resultado+=rs.getString("id_maquina")+"\n";
                    resultado+=rs.getString("fecha")+"\n";
                    resultado+=rs.getString("hora")+"\n";
                }
            
                System.out.println("\n\n"+resultado+"\n");
                resultado="";
            }
        }catch(SQLException ex){//Excepciones sobre la conexion
            System.err.println(ex.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch    
    }//while
}
}// clase main