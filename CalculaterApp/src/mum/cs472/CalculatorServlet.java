package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculate")//annotation way,告诉系统这是一个WebServlet,/calculate is the name and path of the servlet
//这是一个serlvet ，扩展了interface servlet
public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//doGet Method
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String add1 = request.getParameter("add1");//<input type="text" name="add1"/> name is important
		String add2 = request.getParameter("add2");
		String mul1 = request.getParameter("mul1");
		String mul2 = request.getParameter("mul2");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Calculator App</title></head><body>");
	
		if(add1 !="" && add2!=""){
			int add = Integer.parseInt(add1) + Integer.parseInt(add2);

			out.print("<p>"+add1+ " + "+add2+" = "+add+"</p>");
		}
		if(mul1 !="" && mul2!=""){
			int mul = Integer.parseInt(mul1) * Integer.parseInt(mul2);

			out.print("<p>"+mul1+ " * "+mul2+" = "+mul+"</p>");
		}
		out.print("</body></html>");
	}
}
