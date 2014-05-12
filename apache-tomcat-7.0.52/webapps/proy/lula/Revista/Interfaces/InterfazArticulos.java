package interfaces;
//import controles.*;
//import entidades.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.Vector;

public class InterfazArticulos extends HttpServlet {
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
	out.println("						  <li><a href=\"RenovarSuscripcion?tipo="+tipo+"\">Renovar Suscripci&oacute;n</a></li>");
	out.println("						</ul>");
	out.println("				  </div><!-- /.navbar-collapse  -->");
	out.println("				</nav>		");
	out.println("				<H1 align=\"center\">Articulos! (Terminado)</H1>	");	

	String busqueda = request.getParameter("busqueda");
	
	//BuscarArticulos b = new BuscarArticulos();
	//Vector<Articulo> art = b.buscarArticulos(busqueda);
	int i=1;
	out.println("				<table class=\"table table-hover\" style=\"background-color:white;\">");
	//for(Articulo a : art)
	//{
		out.println("					<tr>");	
		out.println("						<td>"+i+"</td>");	
	//	out.println("						<td>"+a.getTitulo()+"</td>");	
	//	out.println("						<td>"+a.getAutores()+"</td>");	
	//	out.println("						<td>"+a.getAbstractos()+"</td>");
	//	out.println("						<td>"+a.getArticulo()+"</td>");	
		out.println("			 		</tr>");
	//}	
	out.println("				</table>");	
	
	out.println("			</BODY>");
	out.println("		</HTML>");
  }
}
