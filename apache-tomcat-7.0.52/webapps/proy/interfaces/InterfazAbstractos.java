package interfaces;
import controles.*;
import entidades.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.Vector;

public class InterfazAbstractos extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out; 
  
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
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
	out.println("						<form class=\"navbar-form navbar-left\" role=\"search\" action=\"Abstractos\" method=\"GET\">");
	out.println("							<div class=\"form-group\">");
	out.println("								<input name=\"busqueda\" type=\"text\" class=\"form-control\" placeholder=\"Buscar abstractos\">");
	out.println("							</div>");
	out.println("							<button type=\"submit\" class=\"btn btn-default\">Submit</button>");
	out.println("						</form>");
	out.println("						<ul class=\"nav navbar-nav navbar-right\">");
	out.println("						  <li><a href=\"Ingresar\">Ingresar</a></li>");
	out.println("						  <li><a href=\"Suscribirse\">Suscribirse</a></li>");
	out.println("						</ul>");
	out.println("				  </div><!-- /.navbar-collapse  -->");
	out.println("				</nav>		");
	out.println("				<H1 align=\"center\">Abstractos</H1>	");		
	
	String busqueda = request.getParameter("busqueda");
	
	BuscarArticulos b = new BuscarArticulos();
	Vector<Articulo> prueba = b.buscarArticulos(busqueda);
	
	out.println("				<table class=\"table table-hover\" style=\"background-color:white;\">");
	for(Articulo a : prueba)
	{
		out.println("					<tr>");	
		out.println("						<td>"+a.nombreArticulo+"</td>");	
		out.println("						<td>"+a.autores+"</td>");	
		out.println("						<td>"+a.abstracto+"</td>");	
		out.println("			 		</tr>");
	}	
	out.println("				</table>");		
	
	
	
	out.println("			</BODY>");
	out.println("		</HTML>");
  }
}
