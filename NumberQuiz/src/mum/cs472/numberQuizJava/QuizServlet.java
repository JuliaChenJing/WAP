package mum.cs472.numberQuizJava;

import java.io.IOException;
import java.io.PrintWriter;
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
//
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		doAction(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doAction(req, res);
	}
	public void doAction(HttpServletRequest req, HttpServletResponse res) throws IOException{

		PrintWriter out = res.getWriter();
		
		HttpSession session = req.getSession();
		if(session.getAttribute("currentQuestion")==null)
			session.setAttribute("currentQuestion",0);
		
		if(session.getAttribute("quizobj")==null)
			session.setAttribute("quizobj", new Quiz());
			
		int currentQuestion = (int)session.getAttribute("currentQuestion");
		Quiz quiz =(Quiz)session.getAttribute("quizobj");
		if(String.valueOf(currentQuestion).equals(quiz.getNumQuestions())){
			 out.println("Quiz over!!!!");
		}
		
		String answer = req.getParameter("txtAnswer");
		session.setAttribute("currentQuestion",(currentQuestion+1));
		
		 boolean error = true;
         /* i.e., if answer is correct then increment the question index and score */
         if ((answer != null) && quiz.isCorrect(answer)) {
             error = false;
             quiz.scoreAnswer();
             session.setAttribute("quizobj", quiz);
         }
         
         if (quiz.getNumCorrect().equals(quiz.getNumQuestions())) {                 
             genQuizOverPage(out);
         }else{
        	 genQuizPage(quiz,out,quiz.getCurrentQuestion(),error,answer);
         } 
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