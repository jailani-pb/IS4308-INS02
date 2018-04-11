package week14.loginapplicationdatabasefixed.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import week14.loginapplicationdatabasefixed.model.Product;

public class ProductController {

	@FXML ListView<Product> listViewProduct;
	
	public void initialize() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/adp",
				"root", "Mypassword123-");
		
		String sql = "SELECT * FROM product";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);
			double price = resultSet.getDouble(3);
			boolean instock = resultSet.getBoolean(4);
			
			Product p = new Product(name, price, instock);
			
			listViewProduct.getItems().add(p);
		}
	}
	
}





