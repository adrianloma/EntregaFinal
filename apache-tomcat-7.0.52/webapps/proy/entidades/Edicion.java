package entidades;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Date;

public class Edicion{
	public int idEdicion;
	public Date fechaEd;
	public String descripcionEd;
	public String temaEdicion;
	public int revista;

	public Edicion(ResultSet rs){   
		init(rs);
	}
	
	public void init(ResultSet rs){   
		try {
			idEdicion = rs.getInt("idedicion");
			fechaEd = rs.getDate("fechaed");
			descripcionEd = rs.getString("descripcioned");
			temaEdicion = rs.getString("temaedicion");
			revista = rs.getInt("revista");
		} catch (Exception e){}
    }
   
    public Edicion(int id){   
		Conexion c = new Conexion();
		ResultSet rs = c.executeQuery("select * from edicion where idedicion = " + id);
		try {
			if(rs.next()) {
				init(rs);
				rs.close();
			} // else error		
			rs.close();
		} catch (Exception e){}
    }
}
