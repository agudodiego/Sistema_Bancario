
package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;

import java.sql.SQLException;


/**
 * Clase abstracta para gestionar la conexion a la BD<br>
 * De ella deben heredar los demas DAOs.<br><br>
 * <strong>Metodos de la Clase:</strong><br>
 * conectarBase()<br>
 * desconectarBase()<br>
 * insertarModificarEliminar(String consultaSQL)<br>
 * consultarBase(String consultaSQL)<br>
 * 
 * @author diegoagudo
 */
public abstract class DAO {
    
   protected Connection miConexion = null;
   protected Statement sentencia = null;
   protected ResultSet resultado = null;
   
   private final String USER = "root";
   private final String PASSWORD = "";
   private final String DATABASE = "sistema_bancario";
   private final String DRIVER = "com.mysql.cj.jdbc.Driver";
   
   
   
   protected void conectarBase() throws ClassNotFoundException, SQLException{
       try {
          Class.forName(DRIVER);
          String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE;
          
          miConexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
          
       } catch (ClassNotFoundException | SQLException ex) {
          throw ex;
       }
   } 
   
   protected void desconectarBase() throws Exception {
       try {
           if (resultado != null){
               resultado.close();
           }
           if (sentencia != null){
               sentencia.close();    
           }
           if (miConexion != null){
               miConexion.close();               
           }
           
       } catch (Exception ex) {
           throw ex;
       }
   }

   protected void insertarModificarEliminar(String consultaSQL) throws Exception{
       try {           
           conectarBase();
           sentencia = miConexion.createStatement();
           sentencia.executeUpdate(consultaSQL);        
           
       } catch (ClassNotFoundException | SQLException ex) {
           throw ex;
       }finally{
           desconectarBase();
       }
   } 

   protected void consultarBase(String consultaSQL) throws Exception{
       try {
           conectarBase();
           sentencia = miConexion.createStatement();
           resultado = sentencia.executeQuery(consultaSQL);
           
       } catch (Exception ex) {
           throw ex;
       }
   }
   
   
}
