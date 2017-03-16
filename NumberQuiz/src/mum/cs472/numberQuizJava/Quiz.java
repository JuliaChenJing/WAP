package mum.cs472.numberQuizJava;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

	List<String> questionsList = new ArrayList<String>(5);
	{
	questionsList.add("3 , 1, 4, 1, 5, ?");
	questionsList.add("1, 1, 2, 3, 5, ?");
	questionsList.add("1, 4, 9, 16, 25, ?");
	questionsList.add("2, 3, 5, 7, 11, ?");
	questionsList.add("1, 2, 4, 8, 16, ?");
	}
	
	
	private int score = 0;
	public String getNumCorrect() {
		// TODO Auto-generated method stub
		return String.valueOf(score);
	}

	public String getCurrentQuestion() {
		return questionsList.get(this.score);
	}

	public boolean isCorrect(String answer) {
		if(score == 0 && answer.equals("9")){
			return true;
		}else if(score == 1 && answer.equals("8")){
			return true;
		}else if(score == 2 && answer.equals("36")){
			return true;
		}else if(score == 3 && answer.equals("13")){
			return true;
		}else if(score == 4 && answer.equals("32")){
			return true;
		}
		return false;
	}

	public void scoreAnswer() {
		score++;
		
	}

	public String getNumQuestions() {
		return String.valueOf(questionsList.size());
	}

}
