package entidades;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Date;

public class Articulo{
	public int idArticulo;
	public String nombreArticulo;
	public String status;
	public int edicion;
	public String autores;
	public String abstracto;
	public String textoArticulo;
	
	public Articulo(ResultSet rs) {
		init(rs);
	}
	
	public void init(ResultSet rs) {
		try {
			idArticulo = rs.getInt("idarticulo");
			nombreArticulo = rs.getString("nombrearticulo");
			status = rs.getString("status");
			edicion = rs.getInt("idedicion");
			autores = rs.getString("autores");
			abstracto = rs.getObject("abstracto").toString();
			textoArticulo = rs.getObject("textoarticulo").toString();
		} catch (Exception e){}
	}
	
	public Articulo(int id) {
		Conexion c = new Conexion();
		ResultSet rs = c.executeQuery("select * from Articulo where idarticulo = " + id);
		try {
			if(rs.next()) {
				init(rs);
				rs.close();
			} // else error		
			rs.close();
		} catch (Exception e){}
	}
}
