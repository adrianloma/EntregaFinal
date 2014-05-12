package controles;
import entidades.Articulo;

public class BuscarArticulos {
	Conexion conexion;

	public BuscarArticulos() {
		conexion = new Conexion();

	}
	
	// regresa un arreglo con los artiuculos
	Vector<Articulo> buscarArticulos(String keyword) {
		ResultSet rs = conexion.executeQuery(
			"select * from Articulo where titulo like '%" + keyword +  "%' " +
			"	or abstract like '%" + keyword + "%'"
		);
		Vector<Articulo> arts = new Vector<Articulo>();
		
		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();

		return arts;
	}

	Articulo getArticulo(int articulo) {
		return new Articulo(articulo);
	}
}

