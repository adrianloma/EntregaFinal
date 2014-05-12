package controles;

import java.util.*;
import entidades.*;
import java.sql.*;
import java.io.*;

public class SeleccionarArticulo {
	Conexion conexion;
	ResultSet rs;

	public SeleccionarArticulo() {
		conexion = new Conexion();
	}
	
	public void seleccionar(int id) {
		conexion.executeUpdate("update Articulo set status='seleccionado' where idArticulo="+id+"");
	}
	
	public void borrar(int id) {
		conexion.executeUpdate("delete from Articulo where idArticulo='"+id+"'");
	}
	
	public Vector<Articulo> articulosAprobar() {
		Vector<Articulo> arts = new Vector<Articulo>();

		try {
		
		ResultSet rs = conexion.executeQuery(
			"select * from Articulo where status = 'sugerido'"
		);
		
		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();
		
		} catch (Exception e) {}
		return arts;
	}

}




