package mum.cs472.numberQuizJava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/quiz")
public class QuizServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int score = 0;
//
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		Quiz sessQuiz = new Quiz();
	
		PrintWriter out = res.getWriter();
		String currentQuestion = sessQuiz.getCurrentQuestion();
	
		Boolean error = false;
		req.setAttribute("quizobj", new Quiz());
		genQuizPage(sessQuiz, out, currentQuestion, error, req.getParameter("txtAnswer"));
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//		HttpSession session = req.getSession();
		if(req.getAttribute("quizobj")==null){
			System.out.println("--->chireko cha--");
			req.setAttribute("quizobj", new Quiz());
		}
		
//		System.out.println("test---"+req.getAttribute("test"));
//		
//		if(req.getAttribute("test")==null){
//			req.setAttribute("test", 1);
//			
//		}
		
//		int te = (int)req.getAttribute("test");
//		te++;
//		req.setAttribute("test", te);
		
	
		Quiz sessQuiz = (Quiz) req.getAttribute("quizobj");
		System.out.println("------>>quiz obj--"+sessQuiz);
		PrintWriter out = res.getWriter();
		String answer = req.getParameter("txtAnswer");
		Boolean error = true;
		
		System.out.println("---------------------->>>>>>2");
		
		String currentQuestion = sessQuiz.getCurrentQuestion();
		
		System.out.println("---------------------->>>>>>3");
		
		if ((answer != null) && sessQuiz.isCorrect(answer)) {
			error = false;
			sessQuiz.scoreAnswer();
			req.setAttribute("quizobj", sessQuiz);
		}
		System.out.println("----dsdsdsd---"+req.getAttribute("quizobj"));
		System.out.println("----------esko ans--->"+(sessQuiz.getNumCorrect()));
		System.out.println("---------------------->>>>>>4");
		genQuizPage(sessQuiz, out, currentQuestion, error, answer);
	}

	private void genQuizPage(Quiz sessQuiz, PrintWriter out, String currQuest, boolean error, String answer) {
		System.out.println(currQuest);
		System.out.println("error-->"+error);
		System.out.println("text-answer-->"+answer);
		
		out.print("<html>");
		out.print("<head>");
		out.print("	<title>NumberQuiz</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("	<form method='post'>");
		out.print("		<h3>Have fun with NumberQuiz!</h3>");
		out.print("<p>Your current score is: ");
		out.print(sessQuiz.getNumCorrect() + "</br></br>");
		out.print("<p>Guess the next number in the sequence! <br /> ");
		out.print(currQuest + "</p>");

		out.print("<p>Your answer:<input type='text' name='txtAnswer' value='' /></p> ");
		
		/* if incorrect, then print out error message */
		if (error && (answer != null)) { // REFACTOR?-- assumes answer null only
											// when first open page
			out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
		}
		out.print("<p><input type='submit' name='btnNext' value='Next' /></p> ");

		out.print("</form>");
		out.print("</body></html>");
	}

	private void genQuizOverPage(PrintWriter out) {
		out.print("<html> ");
		out.print("<head >");
		out.print("<title>NumberQuiz is over</title> ");
		out.print("</head> ");
		out.print("<body> ");
		out.print("<p style='color:red'>The number quiz is over!</p>	</body> ");
		out.print("</html> ");
	}
}