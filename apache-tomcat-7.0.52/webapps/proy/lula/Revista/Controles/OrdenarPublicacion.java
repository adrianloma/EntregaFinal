package controles;
import entidades.Articulo;
import entidades.Nota;

public class OrdenarPublicacion {
	Conexion conexion;

	public OrdenarPublicacion() {
		conexion = new Conexion();

	}
	
	// regresa un arreglo con los artiuculos
	Vector<Articulo> getArticulosSeleccionados() {
		ResultSet rs = conexion.executeQuery("select * from Articulo where status = 'seleccionado'");
		Vector<Articulo> arts = new Vector<Articulo>();
		
		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();

		return arts;
	}

	Vector<Nota> getNotasActualidad() {
		ResultSet rs = conexion.executeQuery("select * from Nota where status = 'escrita'");
		Vector<Nota> notas = new Vector<Nota>();
		
		while(rs.next()) {
			notas.add(new Nota(rs));
		}

		rs.close();

		return notas;
	}

	void publicar(int nota, Vector<int> articulos) {
		String query
	}
}




