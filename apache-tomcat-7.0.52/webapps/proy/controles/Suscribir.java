package controles;

import java.util.*;
import entidades.*;
import java.sql.*;


public class Suscribir {
	Conexion conexion;

	public Suscribir() {
		conexion = new Conexion();
	}
	
	public void suscribir(String login, String pass, String nombre, String direccion, String telefono, char tipo, int tiempo) {
		conexion.executeUpdate(
			"insert into Cuenta (Login, Password, CName, Direccion, Tipo, Telefono) values ('" +
				login + "', '" + pass + "', '" + nombre + "', '" + direccion + "', '" + tipo  + "', '" + telefono  + "')" );
	}
	
	public void renovar(String tarjeta, String mes, String ano, String codigo, int tiempo) {
	}
}
