package controles;
import entidades.*;
import java.sql.*;
import java.util.*;


public class LeerRevista {
	Conexion conexion;

	public LeerRevista() {
		conexion = new Conexion();

	}
	
	public int getEdicion() {
		try {
			ResultSet rs = conexion.executeQuery ("select idEdicion from Edicion order by idEdicion desc limit 1");
			
			if(rs.next())
				return rs.getInt("idEdicion");
		
		} catch (Exception e) {}
		
		return -1;
	}
	
	public NotaActualidad notaEd(int id) {
		try {
			ResultSet rs = conexion.executeQuery("select * from Nota where idEdicion = " + id);
			
			NotaActualidad nota = null;
			
			if(rs.next())
				nota = new NotaActualidad(rs);
			
			return nota;
		
		} catch (Exception e) {}
		return null;	
	}
	
	public Vector<Articulo> articulosAprobados(int id) {
		Vector<Articulo> arts = new Vector<Articulo>();

		try {
		
		ResultSet rs = conexion.executeQuery ("select * from Articulo where idEdicion = "+id);
		
		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();
		
		} catch (Exception e) {
		}

		

		return arts;
	}
}




