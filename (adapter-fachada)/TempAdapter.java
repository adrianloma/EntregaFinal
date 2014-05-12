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
