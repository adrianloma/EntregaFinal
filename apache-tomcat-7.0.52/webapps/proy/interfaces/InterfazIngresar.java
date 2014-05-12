package interfaces;
import controles.*;
import entidades.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class InterfazIngresar extends HttpServlet {
  HttpServletResponse thisResponse;
  HttpServletRequest thisRequest;
  PrintWriter out;
  
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    thisResponse = response;
    thisRequest = request;
    thisResponse.setContentType("text/html");
    out = thisResponse.getWriter();
	
	//Para revisar si ya fueron ingresados datos para poder asi revisar si existe ese usuario
	String email = request.getParameter("email");
	String pass = request.getParameter("pass");
    if((email == null && pass == null)||(email == "" && pass == "")){ // Si es null significa que no se ha mandado solicitud
      //Encabezado donde sale la navbar dependiendo de que usuario sea
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
		out.println("						  <li class=\"active\"><a href=\"Ingresar\">Ingresar</a></li>");
		out.println("						  <li><a href=\"Suscribirse\">Suscribirse</a></li>");
		out.println("						</ul>");
		out.println("				  </div><!-- /.navbar-collapse  -->");
		out.println("				</nav>		");
		out.println("				<H1 align=\"center\">Ingrese a su cuenta</H1>	");
		//Forma donde se llenan los datos de ingreso al sistema
		out.println("	<form class=\"form-horizontal\" role=\"form\" action=\"Ingresar\" method=\"get\">");
		out.println("	  <div class=\"form-group\">");
		out.println("		<label for=\"inputEmail3\" class=\"col-sm-2 control-label\">Email:</label>");
		out.println("		<div class=\"col-sm-10\">");
		out.println("		  <input name=\"email\" type=\"email\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"*Email\" style=\"width:20%;\">");
		out.println("		</div>");
		out.println("	  </div>");
		out.println("	  <div class=\"form-group\">");
		out.println("		<label  for=\"inputPassword3\" class=\"col-sm-2 control-label\">Password:</label>");
		out.println("		<div class=\"col-sm-10\">");
		out.println("		  <input name=\"pass\" type=\"password\" class=\"form-control\" id=\"inputPassword3\" placeholder=\"*Password\" style=\"width:20%;\">");
		out.println("		</div>");
		out.println("	  </div>");
		out.println("	  <div class=\"form-group\">");
		out.println("		<div class=\"col-sm-offset-2 col-sm-10\">");
		out.println("		  <button type=\"submit\" class=\"btn btn-default\">Sign in</button>");
		out.println("		</div>");
		out.println("	  </div>");
		out.println("	</form>");
		out.println("			</BODY>");
		out.println("		</HTML>"); 
    }else{
		 iniciarConsulta(); 
    }
  }
  
    public void iniciarConsulta(){
	Ingresar ci;
    ci = new Ingresar();
	String email = thisRequest.getParameter("email");
	String pass = thisRequest.getParameter("pass");
	String tipo = ci.accesar(email,pass);
    if (tipo != null){
		out.println("<script>window.location.replace('Revista?tipo="+tipo+"');</script>");
	}
	out.println("<script>window.location.replace(\"Ingresar\")</script>");
  } 
  
}
