package controles;
import entidades.Articulo;

public class SeleccionarArticulo {
	Conexion conexion;
	ResultSet rs;

	public SeleccionarArticulo() {
		conexion = new Conexion();
	}
	
	boolean seleccionar(int id) {
		ResultSet rs = conexion.executeQuery("select * from Articulo where id = " + id);

		if(rs.next()) {
			rs.updateString("status", "seleccionado");
			rs.close();
			return true;
		} else {
			rs.close();
			return false
		}
	}

}




