
abstract class Connection  {
  public Connection() { }
  public String description() {
    return "Generic";
  }
}

class OracleConnection extends Connection {
  public OracleConnection() { }
  public String description() {
    return "Oracle";
  }
}

class SqlServerConnection extends Connection {
  public SqlServerConnection() { }
  public String description() {
    return "SQL Server";
  }
}

class MySqlConnection extends Connection {
  public MySqlConnection() { }
  public String description() {
      return "MySQL";
  }
}

class Suma extends Connection {
  public Suma() { }
  public String description() {
      return "Suma";
  }
  public int operacion(int prim, int sec){
    return prim+sec;
  }
}

class ConnectionFactory {
  protected String type;
  
  public ConnectionFactory(String t) {
    type = t;
  }
  public Connection createConnection() {
    if (type.equals("Oracle")){
      return new OracleConnection();
    }
    else if (type.equals("SQL Server")){
      return new SqlServerConnection();
    }
    else if (type.equals("MySQL")){
      return new MySqlConnection();
    }
    else return null;
  }
}

public class AppFactory {
  public static void main(String args[]) {
    ConnectionFactory factory;
    factory = new ConnectionFactory("Oracle");
    Connection connection = factory.createConnection();
    System.out.println("Estas conectado a " + connection.description());
  }
}

/* 
EJERCICIO: Implementar el patron Factory para conectarse a un servicio remoto
      que permita aplicar las operaciones aritmeticas basicas (+, -, *, / )
      a dos numeros que se enviarÃ­an como parametros. Solo es necesario que se
      reciba un mensaje sobre la operacion a la que se hizo la conexion.  

public class AppFactory {
  public static void main(String args[]) {
    ConnectionFactory factory;
    factory = new ConnectionFactory("suma");
    Connection connection = factory.createConnection();
    System.out.println("Estas conectado a " + connection.description());
    System.out.println("Resultado de la operacion: " + connection.operation(8, 2));
  }
}

EJERCICIO (opciÃ³n 2): Implementar el ejemplo que se ilustra en el slide 17 de la
      presentacion.
*/