package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {

			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
			 int x = Integer.parseInt(request.getParameter("edad"));
			 x=x+1;
			 out.println(docType +
			 "<html>\n" +
			 "<head><title> Bicing Free Slots Notifier </title></head>\n" +
			 "<body>\n" +
			 "<h1></h1>\n" +
			 "<button type=button onclick= >Agregar estaciones</button>"+
			 request.getParameter("nombre") + "</p>"+
			 "<button type=button onclick= >Eliminar estaciones</button>"+
			 request.getParameter("apellido") + "</p>"+
			 "<button type=button onclick= >Mostrar estadísticas</button>"+
			 request.getParameter("edad") + "</p>"+
			 "<button type=button onclick= >Salir</button>"+
			 x + "</p>"+ "<p><b> Cabecera HTTP: </b>"+
			 "\n\n\n"+
			"<p><b> Host: </b>" + request.getHeader("Host") +"</p>" +
			"<p><b> Accept: </b>" + request.getHeader("Accept") +"</p>" +
			"<p><b> Accept-Encoding: </b>" + request.getHeader("Accept-Encoding") +"</p>" +
			"<p><b> Connection: </b>" + request.getHeader("Connection") +"</p>" +
			"<p><b> Cookie: </b>" + request.getHeader("Cookie") +"</p>" +
			"<p><b> Referer: </b>" + request.getHeader("Referer") +"</p>" +
			"<p><b> User-Agent: </b>" + request.getHeader("User-Agent") +"</p>" +
			 
			
			 "</body>" + 
			 "</html>");
			 
			 }
}