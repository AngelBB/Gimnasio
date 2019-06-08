/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasiodb4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class Main {
       
     //CUIDADO!!!!  con la ruta que pongamos 
    final static String BDGimnasio="C:/ficheros/BDGimnasio.yap";
    static ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),BDGimnasio);
    
    public static void main(String[] args) {
        
       /* 
        ///////////////////////////////////        
        // INSERTAMOS ANIMALES Y PERSONAS//
        ///////////////////////////////////
        
        //Lo haremos de forma manual ya que estamos probando pero lo ideal seria con un entorno grafico 
        // y mas modificables y adpatable ante cualquier exigencia
        
        //Creamos clientes
        Cliente c1=new Cliente("75170767M","Angel","Barrilao Bensrhir",123456);
        Cliente c2=new Cliente("11111111A","Ana","Bueno Salgado",111111111);
        Cliente c3=new Cliente("22222222B","Elena","Peña Minarvae",222222222);
        Cliente c4=new Cliente("33333333C","Miguel","Diaz Herrera",333333333);
                      
        //Creamos maquinas y le pasamos el objeto persona
        Maquina m1=new Maquina(1,"Pesas");
        Maquina m2=new Maquina(2,"Cinta andadora");
        Maquina m3=new Maquina(3,"Bicicleta estatica");
        Maquina m4=new Maquina(4,"Banco press");
        
        //Creamos reservas y le aosciamos una persona y una maquina
        Reservas r1=new Reservas(c1,m1,"15/12/2014","12:00");//Contiene la persona , la maquina , fecha y hora
        Reservas r2=new Reservas(c2,m2,"06/01/2015","12:00");
        Reservas r3=new Reservas(c3,m3,"25/12/2014","17:00");
        
        //Almacenamos objetos de reservas en la base de datos
        
        db.store(c1);
        db.store(c2);
        db.store(c3);
        db.store(c4);
        
        db.store(m1);
        db.store(m2);
        db.store(m3);
        db.store(m4);
        
        db.store(r1);
        db.store(r2);
        db.store(r3);
        */
        
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
                            mostrarCliente(generarCliente());
                            break;
                        case 2:
                            mostrarMaquina(generarMaquina());
                            break;
                        case 3:
                            mostrarReserva(generarReserva());
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
                            actualizarCliente(generarCliente());
                            break;
                        case 2:
                            actualizarMaquina(generarMaquina());
                            break;
                        case 3:
                            actualizarReserva(generarReserva());
                            break;    
                    }
                    break;
                case 4:
                    
                    System.out.println("Borrar:\n1) Tabla Clientes\n2) Tabla maquinas\n3) Tabla reservas");
                    j = scan.nextInt();
                    switch(j){
                        case 1:
                            borrarCliente(generarCliente());
                            break;
                        case 2:
                            borrarMaquina(generarMaquina());
                            break;
                        case 3:
                            borrarReserva(generarReserva());
                            break;    
                    }
                    break; 
                    
                case 5:
                    System.exit(0);
                    break; 
            }//switch
        }
    }//static void main        
         

    /*METODO INSERTAR*/
    public static void insertarCliente(){
            String dni,nombre,apellidos;
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
            telefono=Integer.parseInt(scan.next());

            db.store(new Cliente(dni,nombre,apellidos,telefono));
    }
    public static void insertarMaquina(){
            String nombre;
            int id;
            Scanner scan=new Scanner(System.in);//Para por el teclado

            System.out.println("\nAgregar nueva Maquina\n");
            System.out.println("Ingrese el id");
            id=Integer.parseInt(scan.next());

            System.out.println("Ingrese el nombre porfavor: ");
            nombre=scan.next();

            db.store(new Maquina(id,nombre));
    }
    public static void insertarReserva(){//Le pasamos los parametros de los objetos que deseamos buscar en la bd para insertarlos en Reserva
            String fecha,hora;
            Scanner scan=new Scanner(System.in);//Para por el teclado

            //Generamos el cliente y la maquina a buscar en la bd
            Cliente c=generarCliente();
            Maquina m=generarMaquina();

            System.out.println("\nAgregar nueva Reserva\n");
            System.out.println("Ingrese el fecha");
            fecha=scan.next();

            System.out.println("Ingrese el hora: ");
            hora=scan.next();

            //El cliente y la maquina los podemos sacar
            //desde la base de datos 
            ObjectSet<Cliente> c1=db.queryByExample(c);
            ObjectSet<Maquina> m1=db.queryByExample(m);

            db.store(new Reserva(c1.next(),m1.next(),fecha,hora));//Insertamos el objeto Reserva
    }

    /*METODOS ACTUALIZAR*/
    public static void actualizarCliente(Cliente modificar){
     ObjectSet<Cliente> result1=db.queryByExample(modificar);//Le pasamos el cliente que se quiera actualizar
                if(result1.size()==0){
                    System.out.println("No existe registro");
                }else{
                    Cliente existe=(Cliente) result1.next();
                    System.out.println("Antes de la modificacion \n\nCLIENTE:"+existe.cadenaInfoCliente());

                    existe.setTlf(958777666);//modificamos un valor
                    db.store(existe);//lo guardamos
                    System.out.println("Despues de la modificacion\n\nCLIENTE: "+existe.cadenaInfoCliente());

                }    
    }
    public static void actualizarMaquina(Maquina modificar){
     ObjectSet<Maquina> result1=db.queryByExample(modificar);//Le pasamos la maquina que se quiera actualizar
                if(result1.size()==0){
                    System.out.println("No existe registro");
                }else{
                    Maquina existe=(Maquina) result1.next();
                    System.out.println("Antes de la modificacion \n\nMAQUINA: "+existe.cadenaInfoMaquina());

                    existe.setNombre("Banco de pesas");//modificamos un valor
                    db.store(existe);//lo guardamos
                    System.out.println("Despues de la modificacion\n\nMAQUINA: "+existe.cadenaInfoMaquina());
                }    
    }
    public static void actualizarReserva(Reserva modificar){
     ObjectSet<Reserva> result1=db.queryByExample(modificar);
                if(result1.size()==0){
                    System.out.println("No existe registro");
                }else{
                    Reserva existe=(Reserva) result1.next();
                    System.out.println("Antes de la modificacion \n\nCLIENTE:"+existe.getCli().cadenaInfoCliente()+
                                            "MAQUINA: "+existe.getMaq().cadenaInfoMaquina()+
                                            "fecha"+existe.getFecha()+"\n"+
                                            "hora"+existe.getHora()+"\n\n");

                    existe.setFecha("23/12/2014");//modificamos la fecha
                    db.store(existe);//lo guardamos
                }
    }

    /*METODOS BORRAR*/
    public static void borrarCliente(Cliente c){
    ObjectSet<Cliente> result2=db.queryByExample(c);
                if(result2.size()==0){
                    System.out.println("No existe registro");
                }else{
                    Cliente existe=(Cliente) result2.next();
                    System.out.println("Registros a borrar: "+result2.size());
                    if(result2.size()>1){ //controlamos si son varios objetos a borrar
                        while(result2.hasNext()){
                            Cliente a=result2.next();
                            db.delete(a);
                            System.out.println("Borrando.......");
                            System.out.println("Borrando finalizado");
                        }
                    }else{
                        db.delete(existe);//Si solo hay un objeto
                    }
                }
    }
    public static void borrarMaquina(Maquina m){
    ObjectSet<Maquina> result2=db.queryByExample(m);
                if(result2.size()==0){
                    System.out.println("No existe registro");
                }else{
                    Maquina existe=(Maquina) result2.next();
                    System.out.println("Registros a borrar: "+result2.size());
                    if(result2.size()>1){ //controlamos si son varios objetos a borrar
                        while(result2.hasNext()){
                            Maquina a=result2.next();
                            db.delete(a);
                            System.out.println("Borrando.......");
                            System.out.println("Borrando finalizado");
                        }
                    }else{
                        db.delete(existe);//Si solo hay un objeto
                    }
                }
    }
    public static void borrarReserva(Reserva r){
    ObjectSet<Reserva> result2=db.queryByExample(r);
                if(result2.size()==0){
                    System.out.println("No existe registro");
                }else{
                    Reserva existe=(Reserva) result2.next();
                    System.out.println("Registros a borrar: "+result2.size());
                    if(result2.size()>1){ //controlamos si son varios objetos a borrar
                        while(result2.hasNext()){
                            Reserva a=result2.next();
                            db.delete(a);
                            System.out.println("Borrando.......");
                            System.out.println("Borrando finalizado");
                        }
                    }else{
                        db.delete(existe);//Si solo hay un objeto
                    }
                }
    }

    /*METODOS LISTAR*/
    public static void mostrarCliente(Cliente c){
    ObjectSet<Cliente> result=db.queryByExample(c);
        if(result.size() ==0){
            System.out.println("No esxisten registros");
        }else{
            System.out.println("Numero de registros:"+result.size());
            while(result.hasNext()){
                Cliente resultado=result.next();
                System.out.println("CLIENTE:\n "+resultado.cadenaInfoCliente());
            }
        }
    }
    public static void mostrarMaquina(Maquina m){
    ObjectSet<Maquina> result=db.queryByExample(m);
        if(result.size() ==0){
            System.out.println("No esxisten registros");
        }else{
            System.out.println("Numero de registros:"+result.size());
            while(result.hasNext()){
                Maquina resultado=result.next();
                System.out.println("MAQUINA:\n "+resultado.cadenaInfoMaquina());
            }
        }
    }
    public static void mostrarReserva(Reserva r){
        ObjectSet<Reserva> result=db.queryByExample(r);
        if(result.size() ==0){
            System.out.println("No esxisten registros");
        }else{
            System.out.println("Numero de registros:"+result.size());
            while(result.hasNext()){
                Reserva resultado=result.next();
                System.out.println("CLIENTE:"+resultado.getCli().cadenaInfoCliente()+
                                    "MAQUINA: "+resultado.getMaq().cadenaInfoMaquina()+
                                    "fecha"+resultado.getFecha()+"\n"+
                                    "hora"+resultado.getHora()+"\n\n");
            }
        }
    }


    /*Metodos para generar clientes y maquinas
    para insertar la reserva*/
    public static Cliente generarCliente(){
            String dni,nombre,apellidos;
            int telefono;
            Scanner scan=new Scanner(System.in);//Para por el teclado

            System.out.println("\nImplementar datos de cliente ya existente\n");
            System.out.println("Ingrese el dni porfavor");
            dni=scan.next();

            System.out.println("Ingrese el nombre porfavor: ");
            nombre=scan.next();

            System.out.println("Ingrese los apellidos: ");
            apellidos=scan.next();

            System.out.println("Ingrese el telefono: ");
            telefono=Integer.parseInt(scan.next());

            Cliente cli=new Cliente(dni,nombre,apellidos,telefono);
            return cli;
    }
    public static Maquina generarMaquina(){
     String nombre;
            int id;
            Scanner scan=new Scanner(System.in);//Para por el teclado

            System.out.println("\nImplementar datos de maquina ya existente\n");
            System.out.println("Ingrese el id");
            id=Integer.parseInt(scan.next());

            System.out.println("Ingrese el nombre porfavor: ");
            nombre=scan.next();

            Maquina ma =new Maquina(id,nombre);

            return ma;
    }
    public static Reserva generarReserva(){
            String fecha,hora;
            Scanner scan=new Scanner(System.in);//Para por el teclado

            //Generamos el cliente y la maquina a buscar en la bd
            Cliente c=generarCliente();
            Maquina m=generarMaquina();

            System.out.println("\nImplementar datos de reserva ya existente\n");
            System.out.println("Ingrese el fecha");
            fecha=scan.next();

            System.out.println("Ingrese el hora: ");
            hora=scan.next();

            Reserva res=new Reserva(c,m,fecha,hora);
            return res;
    }
}//main