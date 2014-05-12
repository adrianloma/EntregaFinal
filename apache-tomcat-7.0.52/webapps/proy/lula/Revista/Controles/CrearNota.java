package controles;
import entidades.Articulo;

public class CrearNota {
	Conexion conexion;

	public CrearNota() {
		conexion = new Conexion();
	}
	
	boolean crearNota(String titulo, String texto) {
		conexion.executeQuery(
			"insert into Nota (titulo, texto) values (" +
				titulo + ", " + texto + ")" );
	}

}




