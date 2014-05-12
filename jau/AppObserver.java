import java.util.*;


public class AppObserver {
  public static void main(String args[]) {
    ChatRoom chatRoom = new ChatRoom();
    Observer participante1 = new Participante();
    Observer participante2 = new Participante();
    Observer participante3 = new Participante();
    chatRoom.registerObserver(participante1);
    chatRoom.registerObserver(participante2);
    chatRoom.registerObserver(participante3);
    while (true){
		String participante = System.console( ).readLine();
		String mensaje = System.console( ).readLine();
		chatRoom.editRecord(participante, mensaje);
	}
  }
}

interface Subject  {
  public void registerObserver(Observer o);
  public void removeObserver(Observer o);
  public void notifyObservers();
}

interface Observer  {
  public void update(String participante, String mensaje);
}


class ChatRoom implements Subject {
  private Vector<Observer> observers;
  private String mensaje;
  private String participante;
  
  public ChatRoom() {
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



/*
 EJERCICIO: 3 personas participan en una sesion multi-chat. Cada vez que una
 persona envia un mensaje, todos los participantes lo reciben. La aplicacion
 debe desplegar el mensaje que recibe cada participante.
 */ 