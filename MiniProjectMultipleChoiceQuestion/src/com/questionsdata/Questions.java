package com.questionsdata;

import java.util.ArrayList;
import java.util.Collections;

public class Questions {

	public String question;
	public ArrayList<String> choices;
	public String answer;

	public Questions(String que, String[] ans, String answer2) {
		this.question = que;
		this.choices = new ArrayList<String>();
		for (int i = 0; i < ans.length; i++) {
			this.choices.add(ans[i]);

		}
		Collections.shuffle(this.choices);
		this.answer = answer2;
	}

	public String getQuestion() {
		return question;
	}

	public ArrayList<String> getchoices() {
		return choices;

	}

	public String getAnswer() {
		return answer;

	}

}
