package controles;

import java.util.*;
import entidades.*;
import java.sql.*;

public class SugerirArticulo {
	Conexion conexion;

	public SugerirArticulo() {
		conexion = new Conexion();
	}
	
	public void sugerir(String titulo, String autores, String abstracto, String texto) {
		conexion.executeUpdate(
		//nombreArticulo, idEdicion, status, textoArticulo, abstracto, Autores
			"insert into Articulo (nombreArticulo, status, textoArticulo, abstracto, autores) values ('" +
				titulo + "', 'sugerido', '" + texto + "', '" + abstracto + "', '" + autores + "')" );
	}

}




