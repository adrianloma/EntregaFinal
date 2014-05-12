package controles;
import entidades.*;
import java.sql.*;
import java.util.*;


public class RenovarSuscripcion {
	Conexion conexion;

	public RenovarSuscripcion() {
		conexion = new Conexion();
	}
	
	void renovar(int id, String nombre, String telefono, String tipo, String direccion, String login, String password) {
		conexion.executeQuery(
			"update Cuenta " +
			"CName = '" + nombre + "', " +
			"telefono = '" + telefono + "', " + 
			"tipo = " + tipo + "', " + 
			"direccion = '" + direccion + "', " +
			"login = '" + login + "', " +
			"password = '" + password + "' " +
			"where id = " + id
		);
	}
}


/*

CREATE TABLE Cuenta(
	idCuenta INT auto_increment NOT NULL,
	CName VARCHAR(15) NOT NULL,
	Telefono int(20) NOT NULL,
	Tipo CHAR(1) NOT NULL,
	Direccion VARCHAR(30) NOT NULL,
	Login VARCHAR(30) NOT NULL,
	Password VARCHAR(30) NOT NULL,
	PRIMARY KEY(idCuenta)
)

package controles;
import entidades.*;
import java.sql.*;
import java.util.*;


*/
