package com.questionsdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Quiz {
	public ArrayList<Questions> questionSet;

	public Quiz() {

		questionSet = new ArrayList<Questions>();
		ArrayList<String> questionQuery = new ArrayList<>();
		ArrayList<String> optionAQuery = new ArrayList<>();
		ArrayList<String> optionBQuery = new ArrayList<>();
		ArrayList<String> optionCQuery = new ArrayList<>();
		ArrayList<String> optionDQuery = new ArrayList<>();
		ArrayList<String> correctOptionQuery = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz?characterEncoding=utf8",
					"root", "root");
			PreparedStatement pst1 = con.prepareStatement("Select Question from question_data");
			PreparedStatement pst2 = con
					.prepareStatement("Select option_a,option_b,option_c,option_d,correct_option from options");
			ResultSet rs = pst1.executeQuery();
			ResultSet rs_o = pst2.executeQuery();

			while (rs.next()) {
				questionQuery.add(rs.getString(1));
			}
			while (rs_o.next()) {
				optionAQuery.add(rs_o.getString(1));
				optionBQuery.add(rs_o.getString(2));
				optionCQuery.add(rs_o.getString(3));
				optionDQuery.add(rs_o.getString(4));
				correctOptionQuery.add(rs_o.getString(5));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {

			String que = questionQuery.get(i);
			String[] ans = { optionAQuery.get(i), optionBQuery.get(i), optionCQuery.get(i), optionDQuery.get(i) };
			questionSet.add(new Questions(que, ans, correctOptionQuery.get(i)));
		}

		Collections.shuffle(questionSet, new Random());
	}
}
