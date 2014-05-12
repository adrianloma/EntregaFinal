package controles;
import entidades.*;
import java.util.*;
import java.sql.*;

public class ArticulosSugeridos {
	Conexion conexion;

	public ArticulosSugeridos() {
		conexion = new Conexion();

	}
	
	// regresa un arreglo con los artiuculos
	Vector<Articulo> getArticulosSugeridos() {
		Vector<Articulo> arts = new Vector<Articulo>();
				
		try {
		ResultSet rs = conexion.executeQuery("select * from Articulo where status = 'sugerido'");

		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();
		} catch (Exception e) {}


		return arts;
	}

}




