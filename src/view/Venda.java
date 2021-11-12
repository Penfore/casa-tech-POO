package src.view;

import java.io.IOException;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.controller.LoginController;
import src.model.vo.FuncionarioVO;

public class Venda extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage ps) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("telas/venda.fxml"));

		Scene cena = new Scene(root);

		ps.setTitle("CT-Venda");
		ps.setScene(cena);
		ps.show();
	}

	public void switchSceneVenda(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("telas/venda.fxml"));
		Parent root;

		try {
			root = (Parent) loader.load();
			stage.setScene(new Scene(root));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public void ModalVendaAdd(Stage stage) {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("telas/ClienteVendaADD.fxml"));
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
