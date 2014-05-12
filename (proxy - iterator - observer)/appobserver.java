import java.util.*;

interface Subject  {
  public void registerObserver(Observer o);
  public void removeObserver(Observer o);
  public void notifyObservers();
}

interface Observer  {
  public void update(String participante, String mensaje);
}

class Chat implements Subject {
  private Vector<Observer> observers;
  private String mensaje;
  private String participante;
  
  public Chat() {
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
      Observer observer = (Observer)observers.get(loopIndex);
      observer.update(participante, mensaje);
    }
  }

  public void editRecord(String participante, String mensaje) {
    this.mensaje = mensaje;
  this.participante = participante;
    notifyObservers();
  }
}

class Participante implements Observer  {
  public Participante(){ }

  public void update(String Participante, String mensaje) {
    System.out.println(Participante+": " + mensaje);
  }
}

public class AppObserver {
  public static void main(String args[]) {
    Chat chat = new Chat();
    Observer p1 = new Participante();
    Observer p2 = new Participante();
    Observer p3 = new Participante();
    chat.registerObserver(p1);
    chat.registerObserver(p2);
    chat.registerObserver(p3);
    while (true){
      String participante = System.console( ).readLine();
      String mensaje = System.console( ).readLine();
      chat.editRecord(participante, mensaje);
    }
  }
}