package src.view;


import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Venda extends Application{

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage ps) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("telas/vendas.fxml"));
		
		Scene cena = new Scene(root);
		
		ps.setTitle("casatech-vendas");
		ps.setScene(cena);
		ps.show();
	}
}
