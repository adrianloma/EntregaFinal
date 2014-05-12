package entidades;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Date;

public class Cuenta{
	public int idCuenta;
	public String CName;
	public String tipo;
	public int telefono;
	public String login;
	public String password;
	public String direccion;
	public Date fechaSalida;
	
	//metodos
	public Cuenta(ResultSet rs) {
		init(rs);
	}
	
	public void init(ResultSet rs) {
		try{
			idCuenta = rs.getInt("idCuenta");
			CName = rs.getString("CName");
			tipo = rs.getString("tipo");
			telefono = rs.getInt("telefono");
			login = rs.getString("login");
			password = rs.getString("password");
			direccion = rs.getString("direccion");
			//fechaEntrada = rs.getDate("fechaentrada");
			fechaSalida = rs.getDate("fechasalida");
		} catch (Exception e){}
	}
	
	public Cuenta(int id) {	
		Conexion c = new Conexion();
		ResultSet rs = c.executeQuery("select * from cuenta where idCuenta = " + id);
		try {
			if(rs.next()) {
				init(rs);
				rs.close();
			} // else error		
			rs.close();
		} catch (Exception e){}
	}
   

}
