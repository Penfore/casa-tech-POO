package src.view;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RelatoriosVenda extends Application{

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage ps) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("telas/RelatoriosVenda.fxml"));
		
		Scene cena = new Scene(root);
		
		ps.setTitle("CT - Relatorios Venda");
		ps.setScene(cena);
		ps.show();
	}

}