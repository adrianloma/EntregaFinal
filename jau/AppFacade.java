import java.util.HashMap;

public class AppFacade{
	
	public static void main(String[] args) {
		ControlPedido controlPedido = new ControlPedido();
		controlPedido.setClave(123);
		controlPedido.setNombre("Manuel");
		System.out.println("Clave cliente: " + controlPedido.getClave()+ "\n");
		System.out.println("Nombre cliente: " + controlPedido.getNombre()+ "\n");
		controlPedido.desplegarDetalle();
		System.out.println("\nProductos a preparar: " + controlPedido.getNumProductos());
		System.out.println("Costo total a pagar: " + controlPedido.getPedidoTotal());		
	}
}

class ControlPedido{
	Cliente cliente;
	Pedido pedido;
	Detalle detalle;
	
	public ControlPedido(){
		cliente = new Cliente();
		pedido = new Pedido();
		detalle = new Detalle();
	}
	
	public int getClave(){
		return cliente.getClave();
	}
	
	public void setClave(int c){
		
		cliente.setClave(c);
	}
	
	public String getNombre(){
		return cliente.getNombre();
	}
	
	public void setNombre(String n){
		
		cliente.setNombre(n);
	}
		
	public void desplegarDetalle(){
		Articulo [] articulo = detalle.getDetalle();
		System.out.println("Detalle de Pedido: " + "\n");
		System.out.println(articulo[0].getNombre() + " " + articulo[0].getCosto());
		System.out.println(articulo[1].getNombre() + " " + articulo[1].getCosto());
		System.out.println(articulo[2].getNombre() + " " + articulo[2].getCosto());
		pedido.setProductos(3);
		pedido.setTotal(articulo[0].getCosto()+ articulo[1].getCosto() + articulo[2].getCosto());
			
	}
	
	public double getPedidoTotal(){
		return pedido.getTotal();
	}
	
	public int getNumProductos(){
		return pedido.getProductos();
	}
}

class Cliente{
	int clave;
	String nombre;
	
	public Cliente(){ }
	
	public int getClave(){
		return clave;
	}
	
	public void setClave(int c){
		clave = c;
	}	

	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String n){
		nombre = n;
	}	
}

class Pedido{
	double total;
	int productos;
	public Pedido(){ }
	
	public int getProductos(){
		return productos;
	}
	
	public void setProductos(int p){
		productos = p;
	}
	
	public double getTotal(){
		return total;
	}
	
	public void setTotal(double t){
		total = t;
	}
	
	
	
}

class Detalle{
	HashMap<Integer, Articulo> articulos;
	
	public Detalle(){
		articulos = new HashMap<Integer, Articulo>();
		articulos.put(1, new Articulo("Laptop", 10000));
		articulos.put(2, new Articulo("Monitor", 2000));
		articulos.put(3, new Articulo("iPhone", 5000));
	}
	
	public Articulo[] getDetalle(){
		
		Articulo articulo1 = articulos.get(1);
		Articulo articulo2 = articulos.get(2);		
		Articulo articulo3 = articulos.get(3);
		Articulo [] art = {articulo1, articulo2, articulo3};
		return art;
	}
	
	
}

class Articulo{	
	String nombre;
	double costo;
	public Articulo(String n, double c){
		nombre = n;
		costo = c;
	}
	
	public void setNombre(String n){
		nombre = n;
	}
	
	public String getNombre(){
		return nombre;
		
	}
	
	public double getCosto(){
		return costo;
	}
	
	public void setCosto(double d){
		costo = d;
	}	
}