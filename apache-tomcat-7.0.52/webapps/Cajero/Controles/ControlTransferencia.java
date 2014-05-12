package controles;
import entidades.Cuenta;

public class ControlTransferencia {
   Cuenta cuenta;

   public ControlTransferencia(){
     cuenta = new Cuenta(); //Asume que la instancia persiste durante la sesion
   }
   
   //Valida si la cuenta existe en la base de datos
   public boolean validarCuenta(int ncuenta){            
      return(cuenta.validar(ncuenta));
   }

    public boolean validarCuentas(int ncuenta, int ncuenta2){            
      return(cuenta.validar(ncuenta) && cuenta.validar(ncuenta2));
   }
   
   //Implementa una regla de negocio;
   //no se puede transferir mas de $3000 en una transaccion
   public boolean transferirEfectivo(int corigen, int cdestino, float cantidad){
    if (validarCuenta(corigen) && validarCuenta(cdestino)) {

      if(cantidad < 3000.0f) {

       float saldo = cuenta.getSaldo(corigen);
       if (saldo > cantidad) {

         saldo = saldo - cantidad;
         cuenta.setSaldo(corigen,saldo);
         cuenta.setSaldo(cdestino, cuenta.getSaldo(cdestino) + cantidad);
          return true; //Transaccion aceptada
       } else {
        return false; //No hay fondos suficientes en la cuenta
       }
      } else {
     return false; //Cantidad demasiado alta
      }
    } else{
      return false;
    }
  }


   public float consultaSaldo(int ncuenta){
      return cuenta.getSaldo(ncuenta);
   }     

}
