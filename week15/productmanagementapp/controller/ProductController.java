package week15.productmanagementapp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import week15.productmanagementapp.RunProgram;
import week15.productmanagementapp.model.Product;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ProductController {

	@FXML ListView<Product> listViewProduct;
	@FXML Label labelUsername;
	@FXML CheckBox checkBoxInStock;
	@FXML TextField textFieldPrice;
	@FXML TextField textFieldName;
	@FXML TextField textFieldId;
	@FXML Label labelNameError;
	@FXML Label labelPriceError;
	@FXML Label labelError;
	
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
			
			Product p = new Product(id, name, price, instock);
			
			listViewProduct.getItems().add(p);
		}
	}
	
	public void setUsername(String username) {
		labelUsername.setText(username);
	}

	@FXML public void logout() throws Exception {
		Parent root = FXMLLoader.load(
				getClass().getResource("../view/Login.fxml"));
		Scene scene = new Scene(root, 400, 400);
		RunProgram.stage.setScene(scene);
	}

	@FXML public void edit() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/adp",
				"root", "Mypassword123-");
		
		String sql = "UPDATE product SET name=?, price=?, instock=? "
				+ "WHERE id=?";
		
		String name = textFieldName.getText();
		double price = Double.parseDouble(textFieldPrice.getText());
		boolean inStock = checkBoxInStock.isSelected();
		int id = Integer.parseInt(textFieldId.getText());
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, name);
		statement.setDouble(2, price);
		statement.setBoolean(3, inStock);
		statement.setInt(4, id);
		
		statement.executeUpdate();
		
		Product product = listViewProduct.getSelectionModel().getSelectedItem();
		product.setName(name);
		product.setPrice(price);
		product.setInStock(inStock);
		
		int selectedIndex = listViewProduct.getSelectionModel().getSelectedIndex();
		listViewProduct.getItems().set(selectedIndex, product);
	}

	@FXML public void retrieve() {
		Product product = listViewProduct.getSelectionModel().getSelectedItem();
		if(product != null) {
			textFieldId.setText("" + product.getId());
			textFieldName.setText(product.getName());
			textFieldPrice.setText("" + product.getPrice());
			if(product.isInStock()) {
				checkBoxInStock.setSelected(true);
			} else {
				checkBoxInStock.setSelected(false);
			}
		}
	}

	@FXML public void delete() throws Exception {
		Product product =
				listViewProduct.getSelectionModel().getSelectedItem();

		if(product == null) {
			labelError.setText("Choose product you want to delete.");
			labelError.setStyle("-fx-text-fill: RED");
		} else {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/adp",
					"root", "Mypassword123-");
			
			String sql = "DELETE FROM product WHERE id=?";
			
			int id = product.getId();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			
			listViewProduct.getItems().remove(product);
		}
	}

	@FXML public void add() throws Exception {
		try {
			String name = textFieldName.getText();
			double price = Double.parseDouble(textFieldPrice.getText());
			boolean inStock = checkBoxInStock.isSelected();
			
			if(name.equals("") || price <= 0) {
				if(name.equals("")) {
					labelNameError.setText("Name should have value.");
					labelNameError.setStyle("-fx-text-fill: RED");
				}
				if(price <= 0) {
					labelPriceError.setText("Price should be more than 0.");
					labelPriceError.setStyle("-fx-text-fill: RED");
				}
			} else {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/adp",
						"root", "Mypassword123-");
				
				String sql = "INSERT INTO product (name, price, instock)"
						+ " VALUES (?, ?, ?)";
				
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, name);
				statement.setDouble(2, price);
				statement.setBoolean(3, inStock);
				
				statement.executeUpdate();
				
				listViewProduct.getItems().clear();
				initialize();
				textFieldName.setText("");
				textFieldPrice.setText("");
			}
		} catch(NumberFormatException e) {
			labelPriceError.setText("Price should only contain number format.");
			labelPriceError.setStyle("-fx-text-fill: BLUE");
		}
	}

}





