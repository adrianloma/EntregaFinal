package entidades;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.sql.Date;

public class Evento{
	public int idEvento;
	public String descripcionEvento;
	public Date fechaEvento;
	public String temaEvento;
	public int publicadoPor;
	
	
	public Evento(ResultSet rs){   
		init(rs);
	}
	
	public void init(ResultSet rs){   
		try {
			idEvento = rs.getInt("idevento");
			descripcionEvento = rs.getString("descripcionevento");
			fechaEvento = rs.getDate("fechaevento");
			temaEvento = rs.getString("temaevento");
			publicadoPor = rs.getInt("publicadoPor");
		} catch (Exception e){}
    }
   
    public Evento(int id){   
     	Conexion c = new Conexion();
		ResultSet rs = c.executeQuery("select * from evento where idevento = " + id);
		try {
			if(rs.next()) {
				init(rs);
				rs.close();
			} // else error		
			rs.close();
		} catch (Exception e){}
    }
}
