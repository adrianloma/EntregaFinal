package controles;
import entidades.*;
import java.sql.*;
import java.util.*;
import java.io.*;

public class BuscarArticulos {
	Conexion conexion;

	public BuscarArticulos() {
		conexion = new Conexion();

	}
	
	// regresa un arreglo con los artiuculos
	public Vector<Articulo> buscarArticulos(String keyword) {
		Vector<Articulo> arts = new Vector<Articulo>();

		try {
		
		ResultSet rs = conexion.executeQuery(
			"select * from Articulo where (nombreArticulo like '%" + keyword +  "%' or abstracto like '%" + keyword + "%') and status = 'publicado'"
		);
		
		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();
		
		} catch (Exception e) {
		}

		

		return arts;
	}

	public Articulo getArticulo(int articulo) {
		return new Articulo(articulo);
	}
}
