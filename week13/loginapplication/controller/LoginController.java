package week13.loginapplication.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import week13.loginapplication.RunProgram;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class LoginController {

	@FXML TextField textfieldUsername;
	@FXML TextField textfieldPassword;
	@FXML Label labelWarning;
	
	@FXML public void login() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/adp",
				"root", "Mypassword123-");
		Statement statement = connection.createStatement();
		
		String username = 
				textfieldUsername.getText().trim().toLowerCase();
		String password =
				textfieldPassword.getText();
		
		String sql = "SELECT * FROM account WHERE username='" +
				username + "' AND password=SHA2('" + password +
				"', 256)";
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		if(resultSet.next()) {
//			labelWarning.setText("Correct Credentials.");
//			labelWarning.setStyle("-fx-text-fill: GREEN");
			Parent root = FXMLLoader.load(
					getClass()
					.getResource("../view/ProductManagement.fxml"));
			Scene scene = new Scene(root, 400, 400);
			RunProgram.stage.setScene(scene);
		} else {
			labelWarning.setText("Wrong Username or Password.");
			labelWarning.setStyle("-fx-text-fill: RED");
		}
	}

}



