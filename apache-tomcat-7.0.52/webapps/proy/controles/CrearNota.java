package controles;
import entidades.*;
import java.sql.*;
import java.util.*;

public class CrearNota {
	Conexion conexion;

	public CrearNota() {
		conexion = new Conexion();
	}
	
	public void crearNota(String titulo, String texto) {
	conexion.executeUpdate(
			"insert into Nota (titulo, texto) values ('" +
				titulo + "', '" + texto + "')" );
	}

}




