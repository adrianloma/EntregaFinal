package controles;

import java.util.*;
import entidades.*;
import java.sql.*;

import java.io.*;

public class OrdenarPublicacion {
	Conexion conexion;

	public OrdenarPublicacion() {
		conexion = new Conexion();

	}
	
	// regresa un arreglo con los artiuculos
	public Vector<Articulo> getArticulosSeleccionados() {
		Vector<Articulo> arts = new Vector<Articulo>();
		
		try {
		ResultSet rs = conexion.executeQuery("select * from Articulo where status = 'seleccionado'");
				
		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();
		} catch (Exception e) {}


		return arts;
	}

	public Vector<NotaActualidad> getNotasActualidad() {
		Vector<NotaActualidad> notas = new Vector<NotaActualidad>();
	
		try {
		ResultSet rs = conexion.executeQuery("select * from Nota where idEdicion is null");
				
		while(rs.next()) {
			notas.add(new NotaActualidad(rs));
		}

		rs.close();
		} catch (Exception e) {}


		return notas;
	}

	public void publicar(String nombre, int nota, Vector<Integer> articulos/*, PrintWriter out*/) {
		int llave = -1;
		
		ResultSet rs = conexion.executeUpdate("insert into Edicion (fechaedi, DescripcionEdi) values (curdate(), '" + nombre +"')");
		
		try {
		if (rs.next()) {
			llave = rs.getInt(1);
		} 
		
		rs.close();
		} catch (Exception e) {} 
		
		/*out.println("<h1>" + llave + "</h1>");*/
		
		conexion.executeUpdate("update Nota set idEdicion = " + llave + " where idNota = " + nota);
		
		for(int i : articulos) {
			conexion.executeUpdate("update Articulo set status = 'publicado', idEdicion = " + llave + " where idArticulo = " + i);
		}
	}
}




