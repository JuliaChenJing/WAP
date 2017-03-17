package edu.quiz;

import app.Quiz;
import java.util.Scanner;

/**
 * @since 4/8/09
 * @author levi This class is a "desktop" version of the quiz lab. It is in the
 *         web application becaucse I created this version after the web
 *         application was completed. It uses the exact same classes for the
 *         business logic as does the web application.
 */
public class TestRunner {

	public static void main(String[] args) {
		try {
			Quiz quiz = new Quiz();

			Scanner sc = new Scanner(System.in);
			boolean questionsLeft = true;
			int trying = 0;
			while (questionsLeft) { // They have to keep trying until get the
									// right number.
				/* print out the current score and the question */
				System.out.println();
				System.out.println("Your score is:  " + quiz.getNumCorrect());
				System.out.println("Next sequence is:  " + quiz.getCurrentQuestion());

				System.out.println("Enter the next number for the given sequence.");
				String answer = sc.nextLine();

				if ((answer != null)) {
					if (!quiz.isCorrect(answer)) {
						trying++;
					}
				}
				boolean error = true;
				/*
				 * i.e., if answer is correct then increment the question index
				 * and score
				 */
				if ((answer != null) && quiz.isCorrect(answer)) {
					error = false;
					quiz.markAnswerCorrect(trying);
				}

				/* give error message if wrong */
				if (error == true) {
					System.out.println();
					System.out.println("Wrong answer, please try again.");
					System.out.println();
				}

				/* see if have finished questions */
				if (quiz.getNumCorrect() == quiz.getTotNumQuestions()) {
					questionsLeft = false;
					System.out.println("Congratulations, you have completed the quiz!");
				}

				/*
				 * 5/12/2011kl refactor note: should be able to refactor to keep
				 * more business logic in the model. E.g., quiz should take the
				 * answer and then return a navigation result for either: error
				 * message, next question, or finished.
				 */
			}
		} catch (Exception ex) {
			System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
		}
	}
}
