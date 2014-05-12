class DifficultProduct {
  char nameChars[] = new char[7];
  public DifficultProduct() { }
  public void setFirstNameCharacter(char c) {
    nameChars[0] = c;
  }
  public void setSecondNameCharacter(char c) {
    nameChars[1] = c;
  }
  public void setThirdNameCharacter(char c) {
    nameChars[2] = c;
  }
  public void setFourthNameCharacter(char c) {
    nameChars[3] = c;
  }
  public void setFifthNameCharacter(char c) {
    nameChars[4] = c;
  }
  public void setSixthNameCharacter(char c) {
    nameChars[5] = c;
  }
  public void setSeventhNameCharacter(char c) {
    nameChars[6] = c;
  }
  public char[] getName() {
    return nameChars;
  }
}

class SimpleProductFacade {
  DifficultProduct difficultProduct;
  public SimpleProductFacade() {
    difficultProduct = new DifficultProduct();
  }
  public void setName(String name) {
    char chars[] = name.toCharArray();
    if(chars.length > 0)
      difficultProduct.setFirstNameCharacter(chars[0]);
    if(chars.length > 1)
      difficultProduct.setSecondNameCharacter(chars[1]);
    if(chars.length > 2)
      difficultProduct.setThirdNameCharacter(chars[2]);
    if(chars.length > 3)
      difficultProduct.setFourthNameCharacter(chars[3]);
    if(chars.length > 4)
      difficultProduct.setFifthNameCharacter(chars[4]);
    if(chars.length > 5)
      difficultProduct.setSixthNameCharacter(chars[5]);
    if(chars.length > 6)
      difficultProduct.setSeventhNameCharacter(chars[6]);
  }    
  public String getName() {
    return new String(difficultProduct.getName());
  }
}

public class AppFacade {
  public static void main(String args[]) {
    SimpleProductFacade simpleProductFacade = 
        new SimpleProductFacade();
    simpleProductFacade.setName("printer");
    System.out.println("This product is a " + 
      simpleProductFacade.getName());
  }
}

// EJERCICIO: Implementar una aplicacion que utilice el patron fachada.
// Deseamos preparar la lista de articulos que se surtiran a un cliente.
// El sistema tiene cuatro clases: Cliente, Pedido, Detalle, y Articulo.

// Implementar una clase ControlPedido que haga transparente a la aplicaciÃ³n
// cuales clases deben ser invocadas para tener todos los detalles del pedido,
// solo conociendo la clave del cliente.
// Para ello, crear una intancia de Cliente, una de Pedido, y una de Detalle 
// con los articulos correspondientes.
// La aplicaciÃ³n cliente debera mostrar los datos de cliente y cuales son los
// articulos que deben preparase para enviarse a su direccion y el costo total del pedido.

// El ejercicio se simplifica si utilizamos la clase HashMap en Detalle cuyo 
// contenido serian instancias de Articulo. Para un ejemplo, consultar la liga
//  http://www.mkyong.com/java/how-to-use-hashmap-tutorial-java/
// El constructor de Detalle crea tres intancias de Articulo utilizando hash.put()
// las cuales seran obtenidas mediante un metodo getDetalle() que regrese un
// vector o un arreglo con la lista de articulos.
// El metodo getTotal() en Detalle regresa el costo total del pedido.
 



  