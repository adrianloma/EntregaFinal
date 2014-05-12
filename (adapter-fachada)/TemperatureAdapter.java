interface Celsius {
  public void setTemperatura(float t);
  public float getTemperatura();
}

class Temperatura implements Celsius{
  float temp;

  public float getTemperatura(){
    return temp;
  }
  public void setTemperatura(float t){
    temp = t;
  }

}

interface Fahrenheit {
  public void setTemperature(float t);
  public float getTemperature();
}

class Temperature implements Fahrenheit{
  float temp;

  public float getTemperature(){
    return temp;
  }

  public void setTemperature(float t){
    temp = t;
  }
}


class TempAdapter implements Celsius {
  
  Temperature fahrenObject;

  TempAdapter(){
    fahrenObject = new Temperature();
  }

  public void setTemperatura(float t) {
    fahrenObject.temp = t*9/5 + 32;
  }

  public float getTemperatura() {
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
