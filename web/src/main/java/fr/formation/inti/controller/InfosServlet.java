package fr.formation.inti.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfosServlet
 */
public class InfosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title> infos Servlet </title></head>");
		String requestUrl = request.getRequestURL().toString();
		out.println("<br><span>requestURL :" +requestUrl);
		out.println("</span>");
		
		String requestUri = request.getRequestURI().toString();
		out.println("<br><span>requestURI :" +requestUri);
		out.println("</span>");
		
		String contextPath = request.getContextPath().toString();
		out.println("<br><span> contextPath:" +contextPath);
		out.println("</span>");
		// header infos
		out.println("<br><br><b>Headers :</b>");
		
		Enumeration<String> headers = request.getHeaderNames();
		while(headers.hasMoreElements()) {
			String header = headers.nextElement();
			out.println("<br> "+header+" : "+request.getHeader(header));
		}

		// emplacement de l'application web dans le disque dur
		out.println("<br><br><b> Real path :</b>");
		ServletContext servletContext = request.getServletContext();
		String realPath = servletContext.getRealPath("");
		out.print(realPath);

		
		}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream out = response.getOutputStream();
		out.println("<html>");
		out.println("<head><title> infos Servlet </title></head>");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		out.println("<h1>Method Post: "+ login +" - "+password+"</h1>");
	
		
		
		
	}
}
