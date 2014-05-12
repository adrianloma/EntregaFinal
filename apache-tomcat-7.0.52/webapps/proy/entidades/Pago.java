package entidades;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Date;

public class Pago {
	public int idPago;
	public float precio;
	public float descuento;
	public String metodoPago;
	public float total;
	public Date fechaPago;
	public int suscriptor;
	
	public Pago(ResultSet rs) {
		init(rs);
	}
	public void init(ResultSet rs) {
		try {
			idPago = rs.getInt("idpago");
			precio = rs.getFloat("precio");
			descuento = rs.getFloat("descuento");
			metodoPago = rs.getString("metodopago");
			total = rs.getFloat("ptotal");
			fechaPago = rs.getDate("fechaPago");
			suscriptor = rs.getInt("idcuenta");
		} catch (Exception e){}
	}
	
	public Pago(int id) {
		Conexion c = new Conexion();
		ResultSet rs = c.executeQuery("select * from pago where idpago = " + id);
		try {
			if(rs.next()) {
				init(rs);
				rs.close();
			} // else error		
			rs.close();
		} catch (Exception e){}
	}
	//metodos

	

}
