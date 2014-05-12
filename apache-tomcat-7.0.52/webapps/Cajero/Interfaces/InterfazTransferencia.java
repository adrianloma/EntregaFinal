package interfaces;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import controles.ControlTransferencia;

public class InterfazTransferencia extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  ControlTransferencia ce;
  
  //Es importante observar que todos los metodos definen la operacion GET para
  //que el metodo doGet sea el que se ejecuta al presionar el boton "Enviar". 
  public void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
    //Preparar el encabezado de la pagina Web de respuesta
    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
    out.println("<HTML>");
    out.println("<HEAD>");
    out.println("<META http-equiv=Content-Type content=\"text/html\">");
    out.println("</HEAD>");
    out.println("<BODY>");
    out.println("<TITLE>Banco AMSS</TITLE>");
    out.println("<h2>Cajero Electronico</h2>");
    out.println("<h3>Transferir efectivo</h3>");
    
    String operacion = request.getParameter("operacion");
    if(operacion == null){ // El menu nos envia un parametro para indicar el inicio de una transaccion
      iniciarTransferencia();  
    }else if(operacion.equals("validar")){
       validarCuenta();
    } else if (operacion.equals("transferir")){    
      transferirEfectivo();
    }
  }
  
  public void iniciarTransferencia(){  
    out.println("<p>Indique el numero de las cuentas</p>");
    out.println("<form method=\"GET\" action=\"Transferencia\">");
    out.println("<input type=\"hidden\" name=\"operacion\" value=\"validar\"/>");
    out.println("<p> Cuenta Origen <input type=\"text\" name=\"cuentaOrigen\" size=\"15\"></p>");
    out.println("<p> Cuenta Destino <input type=\"text\" name=\"cuentaDestino\" size=\"15\"></p>");
    out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
    out.println("</form>");
 
    out.println("<form method=\"GET\" action=\"menu.html\">");
    out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
    out.println("</form>");

    out.println("</BODY>");
    out.println("</HTML>");    
  }
  
  public void validarCuenta(){  
    ce = new ControlTransferencia();
    //La funcion trim() elimina espacios antes y despues del valor
    int cuentaOrigen = Integer.parseInt(thisRequest.getParameter("cuentaOrigen").trim());
    int cuentaDestino = Integer.parseInt(thisRequest.getParameter("cuentaDestino").trim());
    if (ce.validarCuentas(cuentaOrigen, cuentaDestino)){
       out.println("<p>Indique la cantidad a transferir</p>");
       out.println("<form method=\"GET\" action=\"Transferencia\">");
       out.println("<input type=\"hidden\" name=\"operacion\" value=\"transferir\"/>");
       out.println("<input type=\"hidden\" name=\"cuentaOrg\" value=\"" + cuentaOrigen + "\"/>");
       out.println("<input type=\"hidden\" name=\"cuentaDest\" value=\"" + cuentaDestino+ "\"/>");
       out.println("<p> Cantidad  <input type=\"text\" name=\"cantidad\" size=\"15\"></p>");
       out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
       out.println("</form>");
 
       out.println("<form method=\"GET\" action=\"menu.html\">");
       out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
       out.println("</form>");
       
       out.println("</BODY>");
       out.println("</HTML>");    
    } else {
       iniciarTransferencia();
    }
  }

  public void transferirEfectivo(){  
    int cuentaOrigen = Integer.parseInt(thisRequest.getParameter("cuentaOrg").trim());
    int cuentaDestino= Integer.parseInt(thisRequest.getParameter("cuentaDest").trim());
    float cantidad = Float.valueOf(thisRequest.getParameter("cantidad").trim()).floatValue();
    if (ce.transferirEfectivo(cuentaOrigen, cuentaDestino, cantidad)) {
      out.println("<p>Su efectivo ha sido transferido.</p>");
      out.println("<p>Fue un placer servirlo. Gracias por operar con nuestro banco.</p>");
      out.println("<p>Presione el boton para terminar.</p>");
      out.println("<form method=\"GET\" action=\"index.html\">");
      out.println("<p><input type=\"submit\" value=\"Terminar\"name=\"B1\"></p>");
      out.println("</form>");
      out.println("</BODY>");
      out.println("</HTML>");
    }else {
      out.println("<h3>Esa es una cantidad excesiva, indique una cantidad menor.</h3>");
      out.println("<p>Indique de nuevo la cantidad a extraer</p>");
      out.println("<form method=\"GET\" action=\"Transferencia\">");
      out.println("<input type=\"hidden\" name=\"operacion\" value=\"transferir\"/>");
      out.println("<input type=\"hidden\" name=\"cuentaOrg\" value=\"" + cuentaOrigen + "\"/>");
      out.println("<input type=\"hidden\" name=\"cuentaDest\" value=\"" + cuentaDestino+ "\"/>");
      out.println("<p> Cantidad  <input type=\"text\" name=\"cantidad\" size=\"15\"></p>");
      out.println("<p><input type=\"submit\" value=\"Enviar\"name=\"B1\"></p>");
      out.println("</form>");
 
       out.println("<form method=\"GET\" action=\"menu.html\">");
       out.println("<p><input type=\"submit\" value=\"Cancelar\"name=\"B2\"></p>");
       out.println("</form>");
             
      out.println("</BODY>");
      out.println("</HTML>");            
    }    
  } 
}