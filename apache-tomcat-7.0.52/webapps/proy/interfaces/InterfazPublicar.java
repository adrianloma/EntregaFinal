package interfaces;
import controles.*;
import entidades.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.Vector;

public class InterfazPublicar extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
//BuscarArticulos b = new BuscarArticulos();
//CrearNota n = new CrearNota();

	OrdenarPublicacion op = new OrdenarPublicacion();
  
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
	
	String idArt[]=request.getParameterValues("artic");
	String nota=request.getParameter("not");
	
	if(idArt==null && nota==null)
	{
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
		//out.println("							<li><a href=\"Ediciones?tipo=e\">Ediciones Anteriores</a></li>");
		out.println("							<li><a href=\"CrearNota\">Nota Actualidad</a></li>");
		out.println("							<li><a href=\"Aprovar\">Aprobar Art&iacute;culos</a></li>");
		out.println("							<li class=\"active\"><a href=\"Publicar\">Publicaci&oacute;n</a></li>");
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
		out.println("				<H1 align=\"center\">Publicar</H1>	");	

		out.println("	<H3 align=\"center\">Notas de interes</H3>");
		out.println("	<form name=\"forma\" class=\"form-horizontal\" role=\"form\" action=\"Publicar\" method=\"get\">");
		out.println("		<table class=\"table\">");
		out.println("		   <tr style=\"background-color:black; color:white;\">");
		//out.println("			<td></td>");
		out.println("			<td>Titulo</td>");
		out.println("			<td>Nota de interes</td>");
		out.println("			<td>Seleccionar</td>");
		out.println("		  </tr>");
		
		
		out.println("<input name=\"nombrepub\" type=\"text\" class=\"form-control\" placeholder=\"Nombre de la edici&oacute;n\">");
		//		   <!-------------------Se imprimen las notas del editor------------------------------------>
		
		Vector<NotaActualidad> nArt = op.getNotasActualidad();
		for(NotaActualidad na : nArt)
		{
			out.println("					<tr>");
			out.println("						<td>"+na.titulo+"</td>");	
			out.println("						<td>"+na.texto+"</td>");	
			out.println("						<td><input type=\"radio\" name=\"not\" value=\""+na.idNotaActualidad+"\" checked></td>");
			out.println("					 </tr>");
		}
		
		//		   <!------------------------------------------------------->
		out.println("		</table>");
				
		out.println("		<H3 align=\"center\">Articulos</H3>");
		out.println("		<table class=\"table\">");
		out.println("		  <tr style=\"background-color:black; color:white;\">");
		//out.println("			<td></td>");
		out.println("			<td>Titulo</td>");
		out.println("			<td>Abstracto</td>");
		out.println("			<td>Art&iacute;culo</td>	");
		out.println("			<td>Seleccionar</td>");
		out.println("		  </tr>");
		//		  <!--------------------------Se imprimen los Articulos aprovados----------------------------->
		Vector<Articulo> art = op.getArticulosSeleccionados();
		//i=1;
		for(Articulo a : art)
		{
			out.println("					<tr>");
			out.println("						<td>"+a.nombreArticulo+"</td>");	
			out.println("						<td>"+a.abstracto+"</td>");
			out.println("						<td>"+a.textoArticulo+"</td>");	
			out.println("						<td><input name=\"artic\" type=\"checkbox\" value=\""+a.idArticulo+"\"></td>");
			out.println("					 </tr>");
		}	
		//		   <!------------------------------------------------------->
		out.println("		</table>");
		out.println("		<div align=\"center\"><button type=\"submit\" class=\"btn btn-default\">Submit</button></div>");
		out.println("	</form>");

			
		out.println("			</BODY>");
		out.println("		</HTML>");
	}else{
		iniciarConsulta();
	}
  }
  public void iniciarConsulta(){ 
	String idArt[]=thisRequest.getParameterValues("artic");
	
	Vector<Integer> arts = new Vector<Integer>();
	
	for(String s : idArt) {
		arts.add(Integer.parseInt(s));
	}
	
	int nota = Integer.parseInt(thisRequest.getParameter("not")); 
	
	op.publicar(thisRequest.getParameter("nombrepub"), nota, arts/*, out*/);
	
	//b.publicarArt(idArt);
	//n.publicarNota(nota);
	out.println("<script>window.location.replace(\"Publicar\");</script>");
  }  
}
