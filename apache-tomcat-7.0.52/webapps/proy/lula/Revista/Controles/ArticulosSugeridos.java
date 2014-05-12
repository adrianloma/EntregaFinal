package controles;
import entidades.Articulo;

public class ArticulosSugeridos {
	Conexion conexion;

	public ArticulosSugeridos() {
		conexion = new Conexion();

	}
	
	// regresa un arreglo con los artiuculos
	Vector<Articulo> getArticulosSugeridos() {
		ResultSet rs = conexion.executeQuery("select * from Articulo where status = 'sugerido'");
		Vector<Articulo> arts = new Vector<Articulo>();
		
		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();

		return arts;
	}

}




