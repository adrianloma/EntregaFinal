public class appCliente { //This is the modified client
  public static void main(String args[]) {
    //The client belives it will be accesing an AceObject
    TemperaturaToTemperatureAdapter temperaturaObject = new TemperaturaToTemperatureAdapter(); 
    temperaturaObject.setTemperatura(50);
    System.out.println("Temperature: " + temperaturaObject.getTemperatura());
  }
}

interface TemperaturaInterface { //This is the old interface
  public void setTemperatura(float t);
  public float getTemperatura();
}

class TemperaturaClass implements TemperaturaInterface  {
  float temperatura;
  public void setTemperatura(float t) {
    temperatura = t;
  }
  public float getTemperatura() {
    return temperatura;
  }
}

interface TemperatureInterface { //This is the new interface
  public void setTemperature(float t);
  public float getTemperature();
}

class TemperatureClass implements TemperatureInterface {
  float temperature;
  public void setTemperature(float t) {
    temperature = t;
  }
  public float getTemperature() {
    return temperature;
  }
}

class TemperaturaToTemperatureAdapter implements TemperaturaInterface {
  TemperatureClass  temperatureObject;

  TemperaturaToTemperatureAdapter(){
    temperatureObject = new TemperatureClass();
  }
  
  public void setTemperatura(float t) {    
    temperatureObject.setTemperature(t*9/5+32);
  }
  public float getTemperatura	() {
    return (temperatureObject.getTemperature()*9/5+32);
  }
}




