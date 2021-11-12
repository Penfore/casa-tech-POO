package src.view;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import src.controller.LoginController;

public class Login extends Application{ 
	public LoginController controller;
	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage ps) throws Exception {
		FXMLLoader loader = new  FXMLLoader(getClass().getResource("telas/login.fxml"));
		Parent root = (Parent) loader.load();
		
		this.controller = (LoginController)loader.getController();
		
		Scene cena = new Scene(root);
		
		ps.setTitle("Casa Tech");
		ps.setScene(cena);
		ps.show();
	}

}
