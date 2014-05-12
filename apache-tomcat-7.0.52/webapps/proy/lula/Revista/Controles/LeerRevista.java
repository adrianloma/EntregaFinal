package controles;
import entidades.Articulo;

public class LeerRevista {
	Conexion conexion;

	public LeerRevista() {
		conexion = new Conexion();

	}
	
	// regresa un arreglo con los artiuculos (pero solo se necesita ID y titulo!!)
	Vector<Articulo> getArticulos(int edicion) {
		ResultSet rs = conexion.executeQuery("select * from Articulo where edicion = 'publicacion' and edicion = " + edicion);
		Vector<Articulo> arts = new Vector<Articulo>();
		
		while(rs.next()) {
			arts.add(new Articulo(rs));
		}

		rs.close();

		return arts;
	}
}




