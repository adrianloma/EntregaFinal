interface AceInterface { //This is the old interface
  public void setName(String n);
  public String getName();
}

class AceClass implements AceInterface  {
  String name;
  public void setName(String n) {
    name = n;
  }
  public String getName() {
    return name;
  }
}

interface AcmeInterface { //This is the new interface to be adapted
  public void setFirstName(String f);
  public void setLastName(String l);
  public String getFirstName();
  public String getLastName();
}


class AcmeClass implements AcmeInterface {
  String firstName;
  String lastName;
  public void setFirstName(String f) {
    firstName = f;
  }
  public void setLastName(String l) {
    lastName = l;
  }
  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
}


class AceToAcmeAdapter implements AceInterface {
  AcmeClass acmeObject;

  AceToAcmeAdapter(){
    acmeObject = new AcmeClass();
  }
  
  public void setName(String name) {
    //The String.split() method returns an array of Strings
    String [] firstLastName = name.split(" ");
    acmeObject.setFirstName( firstLastName[0] );
    acmeObject.setLastName( firstLastName[1] );
  }
  public String getName() {
    return acmeObject.getFirstName()+" " +acmeObject.getLastName();
  }
}

/*
public class AppAdapter { //This is the original client
  public static void main(String args[]) {
    //The client access an AceObject
    AceClass aceObject = new AceClass(); 
    aceObject.setName("Cary Grant");
    System.out.println("Customer's name: " + aceObject.getName());
  }
}
*/

public class AppAdapter { //This is the modified client
  public static void main(String args[]) {
    //The client belives it will be accesing an AceObject
    AceToAcmeAdapter aceObject = new AceToAcmeAdapter(); 
    aceObject.setName("Cary Grant");
    System.out.println("Customer's name: " + aceObject.getName());
  }
}


interface Celsius {
  public void setTemperatura(int t);
  public int getTemperatura();
}

class Temperatura implements Celcius{
  int temp;

  public int getTemperatura(){
    return temp;
  }
  public void setTemperatura(int t){
    temp = t;
  }

}

interface Fahrenheit {
  public void setTemperature(int t);
  public int getTemperature();
}

class Temperature implements Fahrenheit{
  int temp;

  public int getTemperature(){
    return temp;
  }

  public void setTemperature(int t){
    temp = t;
  }
}


class TempAdapter implements Celsius {
  
  Temperature fahrenObject;

  TempAdapter(){
    fahrenObject = new Temperature();
  }

  public void setTemperatura(int t) {
    fahrenObject.temp = t*9/5 + 32;
  }

  public int getTemperatura() {
    return (fahrenObject.temp - 32) * 5/9;
  }

}

public class TemperatureAdapter {
  public static void main(String args[]) {
    TempAdapter celciusObject = new TempAdapter();
    celciusObject.setTemperatura(15);
    System.out.println("Temperatura: " + celciusObject.getTemperatura());
  }
}

// EJERCICIO: Elaborar una aplicacion que utilice el patron Adapter

// Existe una clase Temperatura que opera con temperaturas en grados Celsius, con
// metodos para getTemperatura y setTemperatura.

// La nueva clase Temperature opera con temperaturas en grados Fahrenheit, con
// metodos setTemperature y getTemperature.

// El cliente siempre espera guardar y recibir temperaturas en grados Celsius.

// El adaptador debera convertir las temperaturas de Celsius a Fahernheit y viceversa
// implementando los metodos getTemperatura y setTemperatura.
  
// Probar la clase cliente con acceso a Temperatura y Temperature (esta ultima
// mediante un adatador), para validar que las implementaciones y conversiones son correctas.
