/**
 * @author Angel Barrilao Bensrhir
 */
package gimnasiojdbc;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
   //////////////////////////////////
   //Atributos de la clase conexion//
   //////////////////////////////////
   private String dbuser;
   private String host;
   private String dbpassword;
   private String dbSelected;
   private String typebd;
   private int port;
   
    
   
   ///////////////////////////
   //Constructor por defecto//
   ///////////////////////////
   
   public Conexion(){
        this.dbuser="2dam";
        this.host="localhost";
        this.dbpassword="2dam";
        this.dbSelected="gimnasio";
        this.typebd="mysql";
        this.port=3306;
       
    }
   
    
    //////////////////////////////
    //Constructor por parametros//
    //////////////////////////////
   
    public Conexion(String user,String pass,String db,int port,String host,String tipo){
        this.dbuser=user;
        this.dbpassword=pass;
        this.dbSelected=db;
        this.port=port;
        this.host=host;
        this.typebd=tipo;
    }
        
    //////////////////////////////////////////
    //Metodos generales de la clase Conexion//
    //////////////////////////////////////////
    
    public String getDbuser() {
        return dbuser;
    }

    public void setDbuser(String dbuser) {
        this.dbuser = dbuser;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public String getDbSelected() {
        return dbSelected;
    }

    public void setDbSelected(String dbSelected) {
        this.dbSelected = dbSelected;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public String getHost(){
        return host;
    }
    
    public void setHost(String host){
        this.host=host;
    }
    
     public String getTypebd(){
        return typebd;
    }
    
    public void setTypebd(String tbd){
        this.typebd=tbd;
    }
    
    
    
    
    ////////////////////////////////////////////
    //Metodos especificos de la clase Conexion//
    ////////////////////////////////////////////
    
    //Con este metodo creamos la conexion y devolvemos un objeto de tipo Connection
    public Connection conexionDefault()throws SQLException{
     try{
            // Establecemos la conexión con la base de datos.
            Connection conex = DriverManager.getConnection("jdbc:"+getTypebd()+"://"+getHost()+":"+getPort()+"/"+getDbSelected(),getDbuser(),getDbpassword());//despues de poner el puerto ponemos esto 
            return conex;//Devolvemos el objeto conexion
        }catch(SQLException e){//Excepciones sobre la conexion
            System.err.println(e.getMessage());
        }catch(Exception ex){//Otras excepciones
            System.err.println(ex.getMessage());
        }// try-catch
        
        return null;
    }//Metodo crearConexion();
               
}//Clase Conexion