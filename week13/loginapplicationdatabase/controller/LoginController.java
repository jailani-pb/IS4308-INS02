package week13.loginapplicationdatabase.controller;

import java.io.IOException;

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
	
	@FXML public void login() throws IOException {
		String username = 
				textfieldUsername.getText().trim().toLowerCase();
		String password =
				textfieldPassword.getText();
		if(username.equals("jailani") && password.equals("rahman")) {
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



