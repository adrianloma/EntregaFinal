package interfaces;
//import controles.*;
//import entidades.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class InterfazRenovarSuscripcion extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
	
	String usu = request.getParameter("tipo");
	char tipo = usu.charAt(0);
	
	//Para revisar si ya fueron ingresados datos para poder asi revisar si existe ese usuario
	String tarjeta = request.getParameter("tarjeta");
	String codigo = request.getParameter("codigo");
	if((tarjeta == null && codigo == null)||(tarjeta == "" && codigo == "")){ // Si es null significa que no se ha mandado solicitud	
    //Preparar el encabezado de la pagina Web de respuesta
    out.println("		<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
	out.println("		<HTML>");
	out.println("			<HEAD>");
	out.println("				<TITLE>SEng Bytes and Bits</TITLE>");
	out.println("				<META http-equiv=Content-Type content=\"text/html\">");
	out.println("				<link rel=\"stylesheet\" type=\"text/css\" href=\"dist/css/bootstrap.css\">");
	out.println("			</HEAD>");
	out.println("			<BODY>");
	out.println("				<nav class=\"navbar navbar-inverse\" role=\"navigation\">");
	out.println("				  <!-- Brand and toggle get grouped for better mobile display -->");
	out.println("					<div class=\"navbar-header\">");
	out.println("						<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#bs-example-navbar-collapse-1\">");
	out.println("							  <span class=\"sr-only\">Toggle navigation</span>");
	out.println("							  <span class=\"icon-bar\"></span>");
	out.println("							  <span class=\"icon-bar\"></span>");
	out.println("							  <span class=\"icon-bar\"></span>");
	out.println("						</button>");
	out.println("						<a class=\"navbar-brand\" href=\"\">SEng Bytes and Bits</a>");
	out.println("					</div>");
	out.println("				  <!-- Collect the nav links, forms, and other content for toggling -->");
	out.println("				  <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">");
	out.println("						<ul class=\"nav navbar-nav\">");
	out.println("							<li><a href=\"Revista?tipo="+tipo+"\">Revista del Mes</a></li>");
	out.println("							<li><a href=\"Ediciones?tipo="+tipo+"\">Ediciones Anteriores</a></li>");
	
	if(tipo == 'j'){
	out.println("							<li><a href=\"Sugerir\">Sugerir Art&iacute;culo</a></li>");
	}
	
	if(tipo == 'e'){
	out.println("							<li><a href=\"CrearNota\">Nota Actualidad</a></li>");
	out.println("							<li><a href=\"Aprovar\">Aprovar Art&iacute;culos</a></li>");
	out.println("							<li><a href=\"Publicar\">Publicaci&oacute;n</a></li>");
	}
	
	out.println("						</ul>");
	out.println("						<form class=\"navbar-form navbar-left\" role=\"search\" action=\"Articulos\" method=\"GET\">");
	out.println("							<div class=\"form-group\">");
	out.println("								<input name=\"busqueda\" type=\"text\" class=\"form-control\" placeholder=\"Buscar art&iacute;culos\">");
	out.println("								<input name=\"tipo\" type=\"hidden\" value=\""+tipo+"\">");
	out.println("							</div>");
	out.println("							<button type=\"submit\" class=\"btn btn-default\">Submit</button>");
	out.println("						</form>");
	out.println("						<ul class=\"nav navbar-nav navbar-right\">");
	out.println("						  <li><a href=\"Salir?tipo="+tipo+"\">Cerrar Sesi&oacute;n</a></li>");
	out.println("						  <li class=\"active\"><a href=\"RenovarSuscripcion?tipo="+tipo+"\">Renovar Suscripci&oacute;n</a></li>");
	out.println("						</ul>");
	out.println("				  </div><!-- /.navbar-collapse  -->");
	out.println("				</nav>		");
	out.println("				<H1 align=\"center\">Renovar! (Terminado)</H1>	");
	out.println("	<form class=\"form-horizontal\" role=\"form\" action=\"RenovarSuscripcion\" method=\"get\">	");
	out.println("		<div class=\"form-group\">	");
	out.println("			<div class=\"col-sm-10\" align=\"center\">	");
	out.println("				<input name=\"tarjeta\" type=\"text\" class=\"form-control\" placeholder=\"N&uacute;mero de tarjeta\" style=\"width:30%;\"></br>	");
	out.println("				<input name=\"mes\" type=\"text\" class=\"form-control\" placeholder=\"Mes expiraci&oacute;n\" style=\"width:30%;\"></br>	");
	out.println("				<input name=\"ano\" type=\"text\" class=\"form-control\" placeholder=\"A&ntilde;o Expiraci&oacute;n\" style=\"width:30%;\"></br>	");
	out.println("				<input name=\"cod\" type=\"text\" class=\"form-control\" placeholder=\"C&oacute;digo\" style=\"width:30%;\"></br>	");
	out.println("				<input name=\"tipo\" type=\"hidden\" value=\""+tipo+"\">");
	out.println("				<select class=\"form-control\" name=\"tiempo\" style=\"width:30%;\">	");
	out.println("				  <option value=\"0\">-Cuantos Meses-</option><option value=\"1\">1</option><option value=\"2\">2</option><option value=\"3\">3</option>	");
	out.println("				</select></br>	");
	out.println("				<button type=\"submit\" class=\"btn btn-default\">Suscribir</button>	");
	out.println("			</div>	");
	out.println("		</div>	");
	out.println("	</form>	");	
	out.println("			</BODY>");
	out.println("		</HTML>");
    }else{
		 iniciarConsulta(); 
    }
  }
  
    public void iniciarConsulta(){  
	//Suscribir crs;
    //crs = new Subscribir();
	String tarjeta = thisRequest.getParameter("tarjeta");
	String mes = thisRequest.getParameter("mes");
	String ano = thisRequest.getParameter("ano");
	String codigo = thisRequest.getParameter("codigo");
	String t = thisRequest.getParameter("tiempo");
	int tiempo = t.charAt(0)-48;
	String usu = thisRequest.getParameter("tipo");
	char tipo = usu.charAt(0);
	//crs.renovar(tarjeta,mes,ano,codigo,tiempo);
	out.println("<script>window.location.replace('Revista?tipo="+tipo+"');</script>");
  } 
}
