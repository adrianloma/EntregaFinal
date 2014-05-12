package controles;
import java.util.*;
import entidades.*;
import java.sql.*;


public class Ingresar {
	Conexion conexion;
	String tipo;
	
	public Ingresar() {
		conexion = new Conexion();
	}
	
	public void init(ResultSet rs) {
		try {
			tipo = rs.getString("tipo");
		} catch (Exception e){}
	}
	
	public String accesar(String email, String pass) {		
		try {
		ResultSet rs = conexion.executeQuery("Select tipo from Cuenta where Login='" +email + "' and Password='" + pass + "'");

		if(rs.next()) {
			init(rs);
			rs.close();
		} // else er

		rs.close();
		} catch (Exception e) {}

		return tipo;
	}
	
	
}
