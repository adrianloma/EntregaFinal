package entidades;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Date;

public class Revista{
	public int idRevista;
	public String nombreRevista;
	
	public Revista(ResultSet rs) {
		init(rs);
	}
	
	private void init(ResultSet rs) {
		try {
		idRevista = rs.getInt("idrevista");
		nombreRevista = rs.getString("nombrerevista");
		} catch (Exception e){}
	}
	
	public Revista(int id) {
		Conexion c = new Conexion();
		ResultSet rs = c.executeQuery("select * from revista where idRevista = " + id);
		try{
			if(rs.next()) {
				init(rs);
				rs.close();
			} // else error		
			rs.close();
		} catch (Exception e){}
	}
}













