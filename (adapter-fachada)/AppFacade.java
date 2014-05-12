import java.util.HashMap;

public class AppFacade{
	
	public static void main(String[] args) {
		ControlPedido controlPedido = new ControlPedido();
		controlPedido.setClave(666);
		controlPedido.setNombre("Julio Alvarado");
		System.out.println("Clave del cliente: " + controlPedido.getClave());
		System.out.println("Nombre del cliente: " + controlPedido.getNombre() + "\n");
		controlPedido.printInfo();
		System.out.println("\nTotal: $" + controlPedido.getPedidoTotal() + " MXN");		
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
	
	public void setClave(int c){
		
		cliente.setClave(c);
	}

	public void setNombre(String n){
		
		cliente.setNombre(n);
	}

	public int getClave(){
		return cliente.getClave();
	}
	
	public String getNombre(){
		return cliente.getNombre();
	}
	
	public double getPedidoTotal(){
		return pedido.getTotal();
	}
	
	public int getNumProductos(){
		return pedido.getProductos();
	}

	public void printInfo(){
		Articulo [] articulo = detalle.getDetalle();
		pedido.setProductos(3);
		System.out.println("Detalles: " + "\n");
		System.out.println("Productos: " + getNumProductos());
		System.out.println(articulo[0].getNombre() + " $" + articulo[0].getCosto() + " MXN");
		System.out.println(articulo[1].getNombre() + " $" + articulo[1].getCosto() + " MXN");
		System.out.println(articulo[2].getNombre() + " $" + articulo[2].getCosto() + " MXN");
		pedido.setTotal(articulo[0].getCosto()+ articulo[1].getCosto() + articulo[2].getCosto());
			
	}
}

class Cliente{
	int clave;
	String nombre;
	
	public Cliente(){ 
		//vacio
	}
	
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
	public Pedido(){ 
		//vacio
	}
	
	
	public void setProductos(int p){
		productos = p;
	}

	public void setTotal(double t){
		total = t;
	}

	public int getProductos(){
		return productos;
	}
	
	public double getTotal(){
		return total;
	}
	
}

class Detalle{
	HashMap<Integer, Articulo> articulos;
	
	public Detalle(){
		articulos = new HashMap<Integer, Articulo>();
		articulos.put(1, new Articulo("Leche", 60));
		articulos.put(2, new Articulo("Cervezas", 20));
		articulos.put(3, new Articulo("Llantas", 2500));
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
	//sets
	public void setNombre(String n){
		nombre = n;
	}

	public void setCosto(double d){
		costo = d;
	}//end sets	
	
	//gets
	public String getNombre(){
		return nombre;
		
	}
	
	public double getCosto(){
		return costo;
	}//end gets

}