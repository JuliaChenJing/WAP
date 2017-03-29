
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * Servlet implementation class TestInitParams
 */
@WebServlet("/TestInitParams")
public class TestInitParams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws IOException, ServletException {
    	System.out.println("inside doGet");
    		
    	response.setContentType("text/html");
    		
    	PrintWriter out = response.getWriter();
        out.println("test init parameters<br>");
    	java.util.Enumeration e = getServletConfig().getInitParameterNames();
    	while(e.hasMoreElements())
    	{
    		out.println("<br>param name = " + e.nextElement() + "<br>");
    	}
    		out.println("main email is " + getServletConfig().getInitParameter("mainEmail"));
    		out.println("<br>");
    		out.println("admin email is " + getServletConfig().getInitParameter("adminEmail"));
    	}
    		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
