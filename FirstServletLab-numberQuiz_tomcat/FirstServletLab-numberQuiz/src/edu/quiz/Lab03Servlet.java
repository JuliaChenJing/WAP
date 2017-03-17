/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.quiz;

import app.Quiz;
import java.io.*;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;


/**
 *
 * @author levi
 */
@WebServlet("/QuizServlet")
public class Lab03Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* assume goGet is only called on entry to the application.
         * (What about back refreshing page, other ways to return to page?)
         * create a Quiz here, put in session, and call doPost
         */
//        Quiz newQuiz = new Quiz();
//        HttpSession sess = request.getSession();
//        sess.setAttribute("quiz", newQuiz);  //oops  -- violation of REST idempotent principle for Get
//        System.out.println("JUST set the quiz in the session.");
        doPost(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        HttpSession sess = request.getSession();
        Quiz sessQuiz = (Quiz) sess.getAttribute("quiz");
        /* REFACTORed -- now checks for null sessQuiz */
        if (sessQuiz == null) {
        	sessQuiz = new Quiz();
             sess.setAttribute("quiz", sessQuiz);    	
        }



        /* now need to get an input from the user and process it */
        String answer = request.getParameter("txtAnswer");
        System.out.println("Answer is: " + answer);

        boolean error = true;
        /* i.e., if answer is correct then increment the question index and score */
        if ((answer != null) && sessQuiz.isCorrect(answer)) {
            error = false;
            sessQuiz.markAnswerCorrect();
        }

        /* NEED TO see if are at end of quiz and go to finish page if so? 
         * refactor:  probably better if have an isFinished method in Quiz to encapsulate the logic. */
        if (sessQuiz.getTotNumQuestions() == sessQuiz.getCurrentQuestionIndex()) {
            System.out.println("have finished quiz");
            genQuizOverPage(out);
        } else {
            /* get a question and print it out */
            String currQuest = sessQuiz.getCurrentQuestion();
            genQuizPage(sessQuiz, out, currQuest, error, answer);
        }
    }

    /**
     * Used Refactor>Introduce Method to create this method.  Worked great!
     * @param sessQuiz
     * @param out
     * @param currQuest
     * @param error
     */
    private void genQuizPage(Quiz sessQuiz, PrintWriter out, String currQuest, boolean error, String answer) {
        
        out.print("<html>");
	out.print("<head>");
	out.print("	<title>NumberQuiz</title>");
	out.print("</head>");
	out.print("<body>");
	out.print("	<form method='post'>");
	out.print("		<h3>Have fun with NumberQuiz!</h3>");
        out.print("<p>Your current score is: ");
        out.print(sessQuiz.getNumCorrect() + "</br></br>");
        out.print("<p>Guess the next number in the sequence! ");
        out.print(currQuest + "</p>");

        out.print("<p>Your answer:<input type='text' name='txtAnswer' value='' /></p> ");

        /* if incorrect, then print out error message */
        if (error && (answer != null)) {  //REFACTOR?-- assumes answer null only when first open page
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

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
