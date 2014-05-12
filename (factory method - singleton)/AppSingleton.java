//Example of trying to create two connections to databases,
//first to "products", the second to "employees".

//import java.util.*; 

class DatabaseSynchronized  {
  private static DatabaseSynchronized singleObject;
  private int record;
  private String name;

  //The constructor is private, thus cannot be called from clients
  private DatabaseSynchronized(String n) {
    name = n;
    record = 0;
  }

  //getInstance() uses the constructor to create the instance 
  public static synchronized DatabaseSynchronized getInstance(String n) {
    if (singleObject == null){
      singleObject = new DatabaseSynchronized(n);
    }
    return singleObject;
  }
  
  public void editRecord(String operation) {
    System.out.println("Performing a " + operation +
      " operation on record " + record + 
      " in database " + name);
  }
  
  public String getName() {
    return name;
  }
}


class WindowManager {
  private static WindowManager singleObject;
  private String nombre

  private WindowManager(String nomb){
    nombre = nomb;
  }

  public static synchronized WindowManager getInstance(String nomb){
    if (singleObject == null) {
      singleObject = new WindowManager(nomb);
    }
    return singleObject;
  }
}

//Runable is needed to implement threads.
public class AppSingleton implements Runnable {
  Thread thread;

  public static void main(String args[]) {
    AppSingleton t = new AppSingleton();
  }

  public AppSingleton() {
    DatabaseSynchronized database;
    database = DatabaseSynchronized.getInstance("products");
    thread = new Thread(this, "second");
    thread.start(); 
    System.out.println("This is the " + database.getName() + " database.");
  }

  public void run() {
    DatabaseSynchronized database = 
    DatabaseSynchronized.getInstance("employees");
    System.out.println("This is the " + database.getName() + " database.");
  }
}

/*EJERCICIO: Queremos tener una sola instancia de WindowManager que se ocupe de
    coordinar las ventanas que muestra la interfaz del usuario. El ejercicio
    consiste en implementar la clase WindowManager que asegure que los clientes  
    no podrÃ¡n crear mÃ¡s de una instancia. Si ya existe una instancia, los
    clientes tendrÃ¡n acceso a ella a traves de getInstance(), aun cuando se 
    indique un nombre diferente. En resumen, lo que se debe implementar es 
    la clase WindowManager en lugar de DatabaseSynchronized.
*/
      