// La clase Division contiene varios VicePresidentes (VP)
// El programa lista los VPs de una Division  

import java.util.Iterator;

class VP  { //VicePresident
  private String name;
  private String division;
  public VP(String n, String d) {
    name = n;
    division = d;
  }
  public String getName() {
    return name;
  }
  public void print() {
    System.out.println("Name: " + name + " Division: " + division);
  }
}

class Division { // Division en la que trabajan los VP
  private VP[] VPs = new VP[100]; // Coleccion/Agregado
  private int number = 0;
  private String name;
  public Division(String n) {
    name = n;
  }
  public String getName() {
    return name;
  }
  public void add(String n) {
    VP vp = new VP(n, name);
    VPs[number++] = vp;
  }
  public DivisionIterator iterator() {
    return new DivisionIterator(VPs);
  }
}


class DivisionIterator implements Iterator {
  private VP[] VPs;
  private int location = 0;
  public DivisionIterator(VP[] v) {
    VPs = v;
  }
  public VP next() {
    return VPs[location++];
  }
  public boolean hasNext() {
    if(location < VPs.length && VPs[location] != null){
      return true;
    } else {
      return false; 
    }
  }
  public void remove() {  } //Requerida por la interface Iterator
}


public class AppIterator {
  Division division;
  DivisionIterator iterator;
  public static void main(String args[]) {
    AppIterator app = new AppIterator();
  }
  public AppIterator() {
    division = new Division("Sales");
    division.add("Ted");
    division.add("Bob");
    division.add("Carol");
    division.add("Alice");
    iterator = division.iterator();
    while (iterator.hasNext()){
      VP vp = iterator.next();
      vp.print();
    }
  }
}

/* EJERCICIO: La clase Compra incluye varios Articulos.
      Implementar el patron Iterator para mostrar los articulos a los que
      se refiere una compra.
*/