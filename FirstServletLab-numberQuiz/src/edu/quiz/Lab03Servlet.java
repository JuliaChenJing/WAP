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

	private int trying = 0;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * assume goGet is only called on entry to the application. (What about
		 * back refreshing page, other ways to return to page?) create a Quiz
		 * here, put in session, and call doPost
		 */

		doPost(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		
		/*
		 * i.e., if answer is correct then increment the question index and
		 * score
		 */
		if((answer != null) && !sessQuiz.isCorrect(answer)){
			trying++;
		}
		System.out.println("trying------->>>"+trying);
		if ((answer != null) && sessQuiz.isCorrect(answer)) {
			error = false;
			sessQuiz.markAnswerCorrect(trying);
			trying = 0;
		}
		if (error && (answer != null)) { // REFACTOR?-- assumes answer null only
											// when
			// request.setAttribute("error", error);
			request.setAttribute("error", "Your last answer was not correct! Please try again");
		} else
			request.setAttribute("error", "");

		/*
		 * NEED TO see if are at end of quiz and go to finish page if so?
		 * refactor: probably better if have an isFinished method in Quiz to
		 * encapsulate the logic.
		 */
		RequestDispatcher dispatcher = request.getRequestDispatcher("Quiz.jsp");

		if (sessQuiz.getTotNumQuestions() == sessQuiz.getCurrentQuestionIndex()) {
			System.out.println("have finished quiz");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("QuizOver.jsp");

			sess.invalidate();
			dispatcher2.forward(request, response);
		} else {
			/* get a question and print it out */
			String currQuest = sessQuiz.getCurrentQuestion();
			request.setAttribute("curQuest", currQuest);

			String currQuestHint = sessQuiz.getCurrQuestHint();
			request.setAttribute("hint", currQuestHint);
			request.setAttribute("score", sessQuiz.getNumCorrect());
			try {
				System.out.println("------age value--->" + sess.getAttribute("ageValue"));
				if (sess.getAttribute("ageValue") == null) {
					int age = Integer.parseInt(request.getParameter("age"));
					if (age < 4 || age > 100) {
						sess.setAttribute("errorAge", "Your age should be between 4 - 100");
						request.setAttribute("disable", "");
					} else {
						sess.setAttribute("ageValue", age);
						request.setAttribute("disable", "disabled");
					}
				} else {
					int age = Integer.parseInt(request.getParameter("age"));
					sess.setAttribute("ageValue", age);
					sess.setAttribute("disable", "disabled");
				}

			} catch (NumberFormatException e) {
				request.setAttribute("errorAge", "Give age in number");
			}

			dispatcher.forward(request, response);
		}
	}
}
