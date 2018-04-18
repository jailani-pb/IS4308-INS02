package week15.productmanagementapp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import week15.productmanagementapp.RunProgram;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class LoginController {

	@FXML TextField textfieldUsername;
	@FXML PasswordField textfieldPassword;
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
			FXMLLoader fxmlLoader = 
					new FXMLLoader(getClass()
					.getResource("../view/ProductManagement.fxml"));
			Parent root = fxmlLoader.load();
			ProductController productController =
					fxmlLoader.getController();
			productController.setUsername(resultSet.getString(1));
			Scene scene = new Scene(root, 800, 600);
			RunProgram.stage.setScene(scene);
		} else {
			labelWarning.setText("Wrong Username or Password.");
			labelWarning.setStyle("-fx-text-fill: RED");
		}
	}

}



