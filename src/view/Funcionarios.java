package src.view;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Funcionarios extends Application{

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage ps) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("telas/Funcionarios.fxml"));
		
		Scene cena = new Scene(root);
		
		ps.setTitle("CT - Funcionarios");
		ps.setScene(cena);
		ps.show();
	}

	public void NovoFuncionario(Stage stage) throws SQLException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("telas/funADD.fxml"));
		Parent root;
		Stage modal = new Stage();
		modal.initOwner(stage);
		modal.initModality(Modality.WINDOW_MODAL);
		try {
			root = (Parent) loader.load();
			modal.setScene(new Scene(root));
			modal.showAndWait();
			

		} catch (IOException e) {
			e.printStackTrace();
		}


	}


}
