package src.controller.TelasPrincipaisController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.controller.TrocarTelas;
import src.model.bo.LocalBO;
import src.model.vo.LocalVO;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class LocalController extends TrocarTelas implements Initializable {
	@FXML
	private ComboBox<String> localComboBox;

	@FXML
	private TableView<LocalVO> tableLocal;
	@FXML
	private TableColumn<LocalVO, String> colCasa;
	@FXML
	private TableColumn<LocalVO, String> colComp;

	LocalBO bo = new LocalBO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<LocalVO> index = FXCollections.observableArrayList(bo.index());

		ObservableList<String> pesquisa = FXCollections.observableArrayList();
		try {
			pesquisa.addAll("CASA", "COMPARTIMENTO");

			localComboBox.setItems(pesquisa);

			colCasa.setCellValueFactory(new PropertyValueFactory<>("casa"));
			colComp.setCellValueFactory(new PropertyValueFactory<>("compartimento"));

			tableLocal.setItems(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void abrirLocalADD() {
		TelasSecudaria.load(telasSecNome.LocalADD);
	}
}
