package week14.loginapplicationdatabasefixed.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import week14.loginapplicationdatabasefixed.RunProgram;
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
		
		String username = 
				textfieldUsername.getText().trim().toLowerCase();
		String password =
				textfieldPassword.getText();
		
		String sql = "SELECT * FROM account "
				+ "WHERE username=? AND password=SHA2(?, 256)";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
//			labelWarning.setText("Correct Credentials.");
//			labelWarning.setStyle("-fx-text-fill: GREEN");
			Parent root = FXMLLoader.load(
					getClass()
					.getResource("../view/ProductManagement.fxml"));
			Scene scene = new Scene(root, 800, 600);
			RunProgram.stage.setScene(scene);
		} else {
			labelWarning.setText("Wrong Username or Password.");
			labelWarning.setStyle("-fx-text-fill: RED");
		}
	}

}



