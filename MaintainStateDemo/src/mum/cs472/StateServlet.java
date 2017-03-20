package mum.cs472;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StateServlet")
public class StateServlet extends HttpServlet {// 建立一个类，扩展HttpServlet接口
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//how to set request attribute
		request.setAttribute("requestState", "requestState");
		// how to set sesson attribute
		request.getSession().setAttribute("sessionState", "sessionState");
		//how to set context attribute
		this.getServletContext().setAttribute("applicationState", "applicationState");
		
		//cookies
		Cookie c = new Cookie("cookiePermanentState", "cookiePermanentState");
		//set cookie age
		c.setMaxAge(3600);
		response.addCookie(c);
		c = new Cookie("cookieTemporaryState", "cookieTemporaryState");
		response.addCookie(c);
		
		//out put html form 
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Test</title></head><body>");
		//after submit, this form will be submited to doPost method
		out.print("<form method='post'>");
		out.print("<p>Please click the button,<br>this is from doGet method</p>");
		//hidden fields
		out.print("<input type='hidden' name='hiddenState' value='hiddenState'>");
		out.print("<input type='submit' value='Click me'/>");
		out.print("</form>");
		out.print("</body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print(
				"<html><head><title>Maintain State Demo </title></head><body><p>This is from the doPost method: <br> See the Bundled Tomcat(5.5.17)window</p></body></html>");
		//output the attribute got in doGet method
		System.out.format("requestState: %s\r\n", request.getAttribute("requestState"));
		System.out.format("sessionState: %s\r\n", request.getSession().getAttribute("sessionState"));
		System.out.format("applicationState: %s\r\n", this.getServletContext().getAttribute("applicationState"));
		
		//cookie :Name/value pair of strings sent as message header between client and server 	
		Cookie[] cookies = request.getCookies();
		int cnt = 0;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("cookiePermanentState"))
					System.out.format("cookiePermanentState: %s\r\n", cookie.getValue());
				else if (cookie.getName().equals("cookieTemporaryState"))
					System.out.format("cookieTemporaryState: %s\r\n", cookie.getValue());
			}
		}
		System.out.format("hiddenState: %s\r\n", request.getParameter("hiddenState"));
	}
}
