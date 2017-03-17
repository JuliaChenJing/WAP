/*
 * Quiz has a set of questions that can be presented to a person.
 * it also tracks the number of correct responses.
 * also tracks where in the quiz the person is at.
 */

package app;

import java.util.ArrayList;

/**
 *
 * @author levi
 */
public class Quiz {
    private ArrayList<Question> questions = new ArrayList<Question>();
    private int numCorrect = 0;
    /* 0 based index for the current question */
    private int currentQuestionIndex = 0;  
    
    /**
     * 
     */
    public int getTotNumQuestions() {
        return questions.size();
    }
    /**
     * Create a new Quiz with questions
     */
    public Quiz() {
        questions.add(new Question("[3 1 4 1 5]", "9","Pie-Value"));
        questions.add(new Question("[1 1 2 3 5]", "8","Fibonacii"));
        questions.add(new Question("[1, 4, 9, 16, 25]", "36","Square number"));
        questions.add(new Question("[2, 3, 5, 7, 11]", "13","Prime numbers"));
        questions.add(new Question("[1 2 4 8 16]", "32","Multiply of 2"));
    }
    
    /**
     * return true or false if answer is correct or false for current question
     * @param ans
     * @return
     */
    public boolean isCorrect(String ans) {
    	if(!ans.equals(null)){
        if (ans.equals(questions.get(currentQuestionIndex).getAnswer())) {
            return true;
        }
        else {
            return false;
        }
    	}
    	return false;
        
    }    
    public String getCurrQuestHint(){
    	return questions.get(currentQuestionIndex).getHint();
    }
    /**
     * increment the currentQuestion index 
     * and also increment the score (should be called if
     * answer is correct.
     */
  

    /**
     * getter
     * @return
     */
    public int getNumCorrect() {
        return this.numCorrect;
    }

    /**
     * getter
     */ 
    public int getCurrentQuestionIndex() {
        return this.currentQuestionIndex;
    }
    
    /**
     * return the text for the current question
     */
    public String getCurrentQuestion(){
        return questions.get(currentQuestionIndex).getQuestion();
    }
	public void markAnswerCorrect(int trying) {
		this.currentQuestionIndex++;
	    if(trying == 0){
         numCorrect += 10;
        }else if(trying == 1){
     	   numCorrect += 5;
        }else if(trying == 2){
     	   numCorrect += 2;
        }else{
     	   numCorrect++;
        }
	}
   
}
