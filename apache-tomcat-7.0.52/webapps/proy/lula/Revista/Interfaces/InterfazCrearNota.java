package interfaces;
//import controles.*;
//import entidades.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class InterfazCrearNota extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  String titulo;
  String nota;
  
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
	
	//Para revisar si ya fueron ingresados datos
	titulo = request.getParameter("titulo");
	nota = request.getParameter("nota");
	
	if(titulo == null && nota == null){
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
		out.println("							<li><a href=\"Revista?tipo=e\">Revista del Mes</a></li>");
		out.println("							<li><a href=\"Ediciones?tipo=e\">Ediciones Anteriores</a></li>");
		out.println("							<li class=\"active\"><a href=\"CrearNota\">Nota Actualidad</a></li>");
		out.println("							<li><a href=\"Aprovar\">Aprovar Art&iacute;culos</a></li>");
		out.println("							<li><a href=\"Publicar\">Publicaci&oacute;n</a></li>");
		out.println("						</ul>");
		out.println("						<form class=\"navbar-form navbar-left\" role=\"search\" action=\"Articulos\" method=\"GET\">");
		out.println("							<div class=\"form-group\">");
		out.println("								<input name=\"busqueda\" type=\"text\" class=\"form-control\" placeholder=\"Buscar art&iacute;culos\">");
		out.println("								<input name=\"tipo\" type=\"hidden\" value=\"e\">");
		out.println("							</div>");
		out.println("							<button type=\"submit\" class=\"btn btn-default\">Submit</button>");
		out.println("						</form>");
		out.println("						<ul class=\"nav navbar-nav navbar-right\">");
		out.println("						  <li><a href=\"Salir?tipo=e\">Cerrar Sesi&oacute;n</a></li>");
		out.println("						  <li><a href=\"RenovarSuscripcion?tipo=e\">Renovar Suscripci&oacute;n</a></li>");
		out.println("						</ul>");
		out.println("				  </div><!-- /.navbar-collapse  -->");
		out.println("				</nav>		");
		out.println("				<H1 align=\"center\">Crear nota! (Terminado)</H1>	");	
		out.println("				<form class=\"form-horizontal\" role=\"form\" action=\"CrearNota\" method=\"get\">");	
		out.println("					<input name=\"tipo\" type=\"hidden\" value=\"e\">");
		out.println("					<div class=\"form-group\"><label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Titulo:</label><input name=\"titulo\" type=\"text\" class=\"form-control\" placeholder=\"Titulo\"></div>");	
		out.println("					<div class=\"form-group\"><label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Nota:</label><textarea name=\"nota\" rows=\"5\" cols=\"50\" placeholder=\"Inserte nota de interes\"></textarea><button type=\"submit\" class=\"btn btn-default\">Enviar</button></div>");		
		out.println("				</form>");	
		out.println("			</BODY>");
		out.println("		</HTML>");
	 }else{
		 iniciarConsulta(); 
    }
  }
    public void iniciarConsulta(){  
	//CrearNota ccn;
    //ccn = new CrearNota();
	
	//ccn.crearNota(titulo, nota);
	out.println("<script>window.location.replace(\"Revista?tipo=e\");</script>");
  } 
}
