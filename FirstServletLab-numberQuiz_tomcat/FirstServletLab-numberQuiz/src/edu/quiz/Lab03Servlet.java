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
            RequestDispatcher dispatcher2 = request.getRequestDispatcher("QuizOver.jsp");
            		dispatcher2.forward(request, response);
        } else {
            /* get a question and print it out */
            String currQuest = sessQuiz.getCurrentQuestion();
          request.setAttribute("curQuest", currQuest);
          
          request.setAttribute("score", sessQuiz.getCurrentQuestionIndex());
          System.out.println("------>>>--score->>--"+sessQuiz.getCurrentQuestionIndex());
       
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Quiz.jsp");
    	dispatcher.forward(request, response);
        }
    }
}
