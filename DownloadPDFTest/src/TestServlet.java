

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/TestServlet")
public class TestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside GET");
		performTask(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		System.out.println("inside Post");
		performTask(request, response);
	}

	private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException 
	{

		System.out.println("inside performTask");
		String pdfFileName = "pdf-test.pdf";
		System.out.println("pdf name:"+pdfFileName);
		String contextPath = getServletContext().getRealPath(File.separator);
		String fileLocation=contextPath +"\\"+ pdfFileName;
		System.out.println("file path:"+fileLocation);
		File pdfFile = new File(fileLocation);

		
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition","attachment; filename=" + pdfFileName);
		response.setContentLength((int) pdfFile.length());
		System.out.println(pdfFile.length());
		FileInputStream fileInputStream = new FileInputStream(pdfFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		System.out.println("out of while");
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
			
		}
		
		System.out.println("out performTask");
	}

}