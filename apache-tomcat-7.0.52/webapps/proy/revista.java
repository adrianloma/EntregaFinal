import java.util.*;
import java.sql.*;
import java.io.*;

public class revista{
	Connection conn;
    Statement stmt;
	
	public revista() {
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost/revista";
			Class.forName ("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection (url, userName, password);
			stmt = conn.createStatement();
		  }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
	}
	 
	public void agregarRevista(int idRevista, String nombreRevista, editorJefe editorJefe) {
		try {
         String s = "INSERT INTO CUENTA (idrevista, nombrerevista, editorjefe)" +
                   " VALUES ("+ idRevista + " , '" + nombreRevista + "', " + editorJefe + " )";
         System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); } 
	}
}

class cuenta{
	Connection conn;
    Statement stmt;
	
	//metodos
	public cuenta(){   
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/revista";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }
   
    public boolean validar(int cuenta){
      try {
         stmt.executeQuery ("SELECT idcuenta FROM cuenta WHERE idcuenta = " + cuenta);
         ResultSet rs = stmt.getResultSet();
         if (rs.next()) { //Va al primer registro si lo hay
            int idCuenta = rs.getInt ("idCuenta");
            rs.close(); 
            return( cuenta == idCuenta );
         }else{ return false;}
      } catch (SQLException e) {}
      return false;
   }
   
    public void agregarCuenta(int cuenta, String nombre, char tipo, int telefono, String direccion, String login, String password){
      try {
         String s = "INSERT INTO CUENTA (idcuenta, nombre, tipo, telefono, direccion, login, password)" +
                   " VALUES ("+ cuenta + " , '" + nombre + "', " + tipo + " "+ telefono + " , '" + direccion + "', " + login + "  "+ password +" )";
		 System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }  
   
   public void quitarCuenta(int cuenta){
      try {
         String s = "DELETE FROM CUENTA WHERE idcuenta = " + cuenta ;		 
		 System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }  
   
    public void publicarEvento(int idEvento, String descripcion, String fechaEvento, String temaEvento){
      try {
         String s = "INSERT ON TABLE EVENTO VALUES ("+ idEvento + " , '" + descripcion + "', " + fechaEvento + ", "+ temaEvento +" )";
         System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }  
}

class suscriptor extends cuenta{
	private float descuento;
	private int finSuscripcion;
	private int saldo;
	private revista revista;
	
	private edicionSuscriptor ed;
}

class edicionSuscriptor{ 
	Connection conn;
    Statement stmt;
	private int idSuscriptor;
	private int idEdicion;
	
	public edicionSuscriptor(){   
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/revista";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }
}

class juez extends cuenta{
	private String fechaIngreso;
	private revista revista;
	
	public void agregarArticulo(int idArticulo, String nombreArticulo, int seleccionado, boolean aprobado){
      try {
         String s = "INSERT INTO CUENTA (idarticulo, nombrearticulo, seleccionado, aprobado)" +
                   " VALUES ("+ idArticulo + " , '" + nombreArticulo + "', " + seleccionado + ", 0 )";
		 System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database " + e ); }   
   }  
}

class autor extends cuenta{
	private String fechaAporte;
	
	private revista revista;
}

class editorJefe extends cuenta{
	Connection conn;
    Statement stmt;
	private String fechaIngreso;
	
	private revista revista;
	
	//metodos
	
	public void aprobarArticulo(int idArticulo){
      try {
         String s = "UPDATE TABLE ARTICULO SET  APROBADO = 1 WHERE idarticulo = " + idArticulo;
         
		 
		 System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }  
}



class pago{
	Connection conn;
    Statement stmt;
	
	//metodos
	public pago(){   
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/revista";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }
	
	public void agregarPago(int idPago, float precio, float descuento, String metodoPago, float total, String fechaPago, int idSuscriptor){
      try {
         String s = "INSERT INTO CUENTA (idpago, precio, descuento, metodopago, total, fechapago, idSuscriptor)" +
                   " VALUES ("+ idPago + " , " + precio + ", " + descuento + " ,'"+ metodoPago + "' , " + total + ", '" + fechaPago + ", " + idSuscriptor +")";
		 System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }  
   
	public float getTotal(int idPago){
     float total = 0.0f; 
      try {
         stmt.executeQuery ("SELECT total FROM pago WHERE idpago = " +idPago);
         ResultSet rs = stmt.getResultSet();
         rs.next(); //Va al registro ya validado
         total = rs.getFloat("total");
         rs.close();
         return(total);
      } catch (SQLException e) {System.out.println ("Cannot getTotal()" + e);}
      return total;
   } 
}

class articulo{
	Connection conn;
    Statement stmt;
	
	public articulo(){   
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/revista";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }
	
	public void agregarArticulo(int idArticulo, String nombreArticulo, int seleccionado, boolean aprobado,int idEdicion,int idJuez,int idEditorJefe){
      try {
         String s = "INSERT INTO CUENTA (idarticulo, nombrearticulo, seleccionado, aprobado,idEdicion,idJuez,idEditorJefe)" +
                   " VALUES ("+ idArticulo + " , '" + nombreArticulo + "', " + seleccionado + ", "+ aprobado +", "+idEdicion+", "+ idJuez +", "+ idEditorJefe +")";
		 System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }  
}

class edicion{

	Connection conn;
    Statement stmt;
	
	public edicion(){   
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/revista";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }
   
   	public void agregarEdicion(int idEdicion, String fechaEd, String descripcionEd, String temaEdicion, int idRevista, int idSuscriptor){
      try {
         String s = "INSERT INTO CUENTA (idedicion, fechaed, descripcioned, temaedicion, idRevista, idSuscriptor)" +
                   " VALUES ("+ idEdicion + " , '" + fechaEd + "', '" + descripcionEd + "', '"+ temaEdicion +"', "+ idRevista +", "+ idSuscriptor +" )";
		 System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }  
	

}

class evento{
	Connection conn;
    Statement stmt;
	
	public evento(){   
      try {
        String userName = "root";
        String password = "";
        String url = "jdbc:mysql://localhost/revista";
        Class.forName ("com.mysql.jdbc.Driver").newInstance();
        conn = DriverManager.getConnection (url, userName, password);
        stmt = conn.createStatement();
      }catch (Exception e) { System.out.println ("Cannot connect to database server"); }
   }
   
    public void agregarEvento(int idEvento, String descripcion, String fechaEvento, String temaEvento, int idEdicion, int idCuenta){
      try {
         String s = "INSERT INTO CUENTA (idevento, descripcion, fechaevento, temaevento, idEdicion, idCuenta)" +
                   " VALUES ("+ idEvento + " , '" + descripcion + "', '" + fechaEvento + "', '"+ temaEvento +"', "+ idEdicion +", "+ idCuenta +" )";
		 System.out.println(s); 
         stmt.executeUpdate(s);
      }catch (Exception e) { System.out.println ("Cannot update database" + e ); }   
   }  
}