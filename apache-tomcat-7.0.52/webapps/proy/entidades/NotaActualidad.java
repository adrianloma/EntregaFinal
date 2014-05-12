package entidades;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Date;

public class NotaActualidad {
	public int idNotaActualidad;
	public String texto;
	public int edicion;
	public String status;
	public String titulo;
	
	public NotaActualidad(ResultSet rs) {
		init(rs);
	}
	
	public void init(ResultSet rs) {
		try {
			idNotaActualidad = rs.getInt("idnota");
			texto = rs.getString("texto");
			edicion = rs.getInt("idedicion");
			titulo = rs.getString("titulo");
		} catch (Exception e){}
	}
	
	public NotaActualidad(int id) {
		Conexion c = new Conexion();
		ResultSet rs = c.executeQuery("select * from Nota where idNota = " + id);
		try {
			if(rs.next()) {
				init(rs);
				rs.close();
			} // else error		
			rs.close();
		} catch (Exception e){}
	}
	
}
