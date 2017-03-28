

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside GET");
		 PrintWriter out = response.getWriter();
		 //String one = request.getParameterValues("sizes")[0];
		 String [] sizes = request.getParameterValues("sizes");
		// If you want to see everything in the array, just for fun or testing, you can use:
		 for(int x=0; x < sizes.length ; x++) {
		 out.println("<br>sizes: " + sizes[x]);
		 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside POST");
		doGet(request, response);
	}

}
