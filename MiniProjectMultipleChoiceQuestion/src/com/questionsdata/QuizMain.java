package com.questionsdata;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizMain {
	int countAns = 0;
	String grade;

	public void startQuiz() {
		Quiz q = new Quiz();
		Scanner sc = new Scanner(System.in);

		for (int question = 0; question < q.questionSet.size(); question++) {
			System.out.println(q.questionSet.get(question).getQuestion());
			int numChoice = q.questionSet.get(question).getchoices().size();
			for (int choice = 0; choice < numChoice; choice++) {
				System.out.println(choice + 1 + ": " + q.questionSet.get(question).getchoices().get(choice));
			}
			System.out.println("\nChoose your option");
			int userAnswer = sc.nextInt();
			while (userAnswer > 4) {
				System.out.println("Invalid input");
				System.out.println("Enter a valid option\n");
				userAnswer = sc.nextInt();
			}
			ArrayList<String> choiceSet = q.questionSet.get(question).getchoices();

			String correctAns = q.questionSet.get(question).getAnswer();
			int correctAnsIndex = choiceSet.indexOf(correctAns);
			if (userAnswer == correctAnsIndex + 1) {
				System.out.println("Correct answer\n");
				countAns++;
			} else {
				System.out.println("Wrong answer\n");
			}
			if (countAns <= 10 && countAns > 8) {
				System.out.println("Class A");
				grade = "Class A ";
			} else if (countAns <= 8 && countAns >= 6) {
				System.out.println("Class B");
				grade = "Class B";
			} else if (countAns == 5) {
				System.out.println("Class C");
				grade = "Class A";
			} else {
				System.out.println("Fail");
				grade = "Fail";
			}

		}

	}

}
