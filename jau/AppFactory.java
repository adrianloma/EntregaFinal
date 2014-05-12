abstract class Connection  {
  public Connection() { }
  public String description() {
    return "Generic";
  }
  public abstract int operation (int a, int b);
}

class SumaConnection extends Connection {
  public SumaConnection() { }
  public String description() {
    return "suma";
  }
  public int operation (int a, int b) {
	return a + b;
  }
}

class RestaConnection extends Connection {
  public RestaConnection() { }
  public String description() {
    return "resta";
  }
   public int operation (int a, int b) {
	return a - b;
  }
}

class MultiplicacionConnection extends Connection {
  public MultiplicacionConnection() { }
  public String description() {
    return "multiplicacion";
  }
   public int operation (int a, int b) {
	return a * b;
  }
}

class DivisionConnection extends Connection {
  public DivisionConnection() { }
  public String description() {
    return "division";
  }
   public int operation (int a, int b) {
	return a / b;
  }
}

class ConnectionFactory {
  protected String type;
  
  public ConnectionFactory(String t) {
    type = t;
  }
  public Connection createConnection() {
    if (type.equals("suma")){
      return new SumaConnection();
    }
    else if (type.equals("resta")){
      return new RestaConnection();
    }
    else if (type.equals("multiplicacion")){
      return new MultiplicacionConnection();
    }
  else if (type.equals("division")){
      return new DivisionConnection();
    }
  
    else return null;
  }
}

public class AppFactory {
  public static void main(String args[]) {
    ConnectionFactory factory;
    factory = new ConnectionFactory("suma");
    Connection connection = factory.createConnection();
    System.out.println("Estas conectado a " + connection.description());
    System.out.println("Resultado de la operacion: " + connection.operation(8, 2));
  }
}