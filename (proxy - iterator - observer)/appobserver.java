//Una base de datos es el sujeto a observar. Cada vez que una operacion es
//efectuada sobre la base de datos, todos los observadores deben ser notificados
//sobre la operacion realizada.

import java.util.*;

interface Subject  {
  public void registerObserver(Observer o);
  public void removeObserver(Observer o);
  public void notifyObservers();
}

interface Observer  {
  public void update(String operation, String record);
}


class Database implements Subject {
  private Vector<Observer> observers;
  private String operation;
  private String record;
  
  public Database() {
    observers = new Vector<Observer>();
  }

  public void registerObserver(Observer o){
    observers.add(o);
  }
  
  public void removeObserver(Observer o) {
    observers.remove(o);
  }
     
  public void notifyObservers() {
    for (int loopIndex = 0; loopIndex < observers.size(); loopIndex++) {
      Observer observer = observers.get(loopIndex);
      observer.update(operation, record);
    }
  }

  public void editRecord(String operation, String record) {
    this.operation = operation;
    this.record = record;
    notifyObservers();
  }
}

class Archiver implements Observer  {
  public Archiver(){ }

  public void update(String operation, String record) {
    System.out.println("The archiver says a " + operation +
      " operation was performed on " + record);
  }
}


class Client implements Observer {
  public Client() { }

  public void update(String operation, String record) {
    System.out.println("The client says a " + operation +
      " operation was performed on " + record);
  }
} 


class Boss implements Observer {
  public Boss(){ }
  public void update(String operation, String record){
    System.out.println("The boss says a " + operation +
      " operation was performed on " + record);
  }
}

public class AppObserver {
  public static void main(String args[]) {
    Database database = new Database();
    Observer archiver = new Archiver();
    Observer client = new Client();
    Observer boss = new Boss();
    database.registerObserver(archiver);
    database.registerObserver(client);
    database.registerObserver(boss);
    database.editRecord("delete", "record 1");
  }
}

/*
 EJERCICIO: 3 personas (Manager, Seller y Client) participan en una sesion
  multi-chat. Cada vez que una persona envia un mensaje, todos los
  participantes lo reciben. La aplicacion debe desplegar el mensaje que recibe
  cada participante.
 */ 