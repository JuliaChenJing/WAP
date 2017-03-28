package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.txw2.Document;

@WebServlet("/calculate")//the name of the servlet
public class CalculatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String add1 = "";
		String add2= "";
		String add= "";
		PrintWriter out = response.getWriter();
		try {
			add1 = request.getParameter("add1");
			add2 = request.getParameter("add2");
			add = String.valueOf(Integer.parseInt(add1) + Integer.parseInt(add2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println("<p>Add Arguments has to be number</p>");
		}

		String mul1= "";
		String mul2= "";
		String mul= "";
		try {
			mul1 = request.getParameter("mul1");
			mul2 = request.getParameter("mul2");
			mul = String.valueOf(Integer.parseInt(mul1) * Integer.parseInt(mul2));
	
		}catch (Exception e) {
			out.println("<p>Multiply Arguments has to be number</p>");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("add", add);
        request.setAttribute("add1", add1);
        request.setAttribute("add2", add2);
        
        request.setAttribute("mul", mul);
        request.setAttribute("mul1", mul1);
        
        request.setAttribute("mul2", mul2);
        
        dispatcher.include(request, response);
	}

}
