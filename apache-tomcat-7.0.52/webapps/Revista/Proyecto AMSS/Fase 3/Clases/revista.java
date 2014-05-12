import java.util.*;

public class revista{
	private int idRevista;
	private String nombreRevista;
	
	private Vector<juez> jueces;
	private editorJefe editorJefe;
	private Vector<autor> autores;
	private Vector<suscriptor> suscriptores;
	private Vector<edicion> ediciones;
	
}

class cuenta{
	private int idEvento;
	private String nombre;
	private char tipo;
	private int telefono;
	private String direccion;
	private String login;
	private String password;
	
	private Vector<evento> eventos;
}

class suscriptor extends cuenta{
	private float descuento;
	private int finSuscripcion;
	private int saldo;
	
	private revista revista;
	private Vector<edicion> ediciones;
	private Vector<pago> pagos;
}

class juez extends cuenta{
	private String fechaIngreso;
	
	private Vector<articulo> articulos;
	private revista revista;
}

class autor extends cuenta{
	private String fechaAporte;
	
	private Vector<articulo> articulos;
	private revista revista;
}

class editorJefe extends cuenta{
	private String fechaIngreso;
	
	private Vector<articulo> articulos;
	private revista revista;
}



class pago{
	private int idPago;
	private float precio;
	private float descuento;
	private String metodoPago;
	private float total;
	private String fechaPago;
	
	private suscriptor suscriptor;//pk con idPago
}

class articulo{
	private int idArticulo;
	private String nombreArticulo;
	private int seleccionado; // para saber que juez fue el que propuso el articulo (1-8)
	private boolean aprobado;
	
	private edicion edicion;
	private Vector<autor> autores;
	private Vector<juez> jueces;
	private editorJefe editorJefe;
	
}

class edicion{
	private int idEdicion;
	private String fechaEd;
	private String descripcionEdi;
	private String temaEdicion;
	
	private revista revista;
	private Vector<articulo> articulos;
	private Vector<evento> eventos;
	private Vector<suscriptor> suscriptores;
}

class evento{
	private int idEvento;
	private String descripcion;
	private String fechaEvento;
	private String temaEvento;
	
	private edicion edicion;
	private cuenta cuenta;
}