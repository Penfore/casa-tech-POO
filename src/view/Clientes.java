package src.view;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Clientes extends Application{

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage ps) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("telas/clientes.fxml"));
		
		Scene cena = new Scene(root);
		
		ps.setTitle("casatech-clientes");
		ps.setScene(cena);
		ps.show();
	}

}
