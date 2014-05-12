package controles;
import entidades.Articulo;

public class SugerirArticulo {
	Conexion conexion;

	public SugerirArticulo() {
		conexion = new Conexion();
	}
	
	boolean sugerir(String titulo, String autores, String abstracto, String citar, String texto) {
		conexion.executeQuery(
			"insert into Articulo (titulo, autores, abstracto, citar) Articulo values (" +
				titulo + ", " + autores + ", " + abstracto + ", " + citar + ", " + texto + ")" );
	}

}




