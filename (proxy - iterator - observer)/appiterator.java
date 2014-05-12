import java.util.Iterator;

class Compra{

	private Articulo [] articulos = new Articulo[100];
	public int size = 0;

	public Compra(){}

	public void add(Articulo a){
		articulos[size] = a;
		size++;
	}
	public void add(String a, int b){
		articulos[size] = new Articulo(a, b);
		size++;
	}
	public CompraIterator iterator(){
		return new CompraIterator(articulos);
	}
}

class CompraIterator implements Iterator {
	private Articulo[] articulos;
	int iter=0;
	public CompraIterator(Articulo[] a){
		articulos = a;
	}
	public Articulo next() {
		return articulos[iter++];
	}
	public boolean hasNext() {
		if(iter < articulos.length && articulos[iter] != null){
			return true;
		} else {
			return false; 
		}
	}
  public void remove() {  } //Requerida por la interface Iterator

}

class Articulo{
	private String name;
	private int price;

	public Articulo(String name, int price){
		this.name = name;
		this.price = price;
	}

	public Articulo(){
		//nothin here :-O
	}

	public void print(){
		System.out.println(name + " " + price +" MXN");
	}

	public void setName(String name){
		this.name = name;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public String getName(){
		return name;
	}

	public int getPrice(){
		return price;
	}

}

public class AppIterator {
	Compra compras;
	CompraIterator iterator;
	public static void main(String args[]) {
		AppIterator app = new AppIterator();
	}
	public AppIterator() {
		compras = new Compra();
		compras.add("Leche", 100);
		compras.add("Limones", 200);
		compras.add("Limonada", 10000);
		compras.add("Mermelada", 20);
		iterator = compras.iterator();
		System.out.println("Los articulos disponibles son: ");
		while (iterator.hasNext()){
			System.out.print("\t");
			Articulo art = iterator.next();
			art.print();
		}
	}
}
