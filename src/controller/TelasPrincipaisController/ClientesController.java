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
import src.model.bo.ClienteBO;
import src.model.vo.ClienteVO;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class ClientesController extends TrocarTelas implements Initializable {
	@FXML private ComboBox<String> clientesComboBox;

	@FXML private TableView<ClienteVO> tableCliente;

	@FXML private TableColumn<ClienteVO, Integer> colID;
	@FXML private TableColumn<ClienteVO, String> colNome;
	@FXML private TableColumn<ClienteVO, String> colCPF;
	@FXML private TableColumn<ClienteVO, String> colEndereco;

	ClienteBO bo = new ClienteBO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<ClienteVO> index = FXCollections.observableArrayList(bo.index());

		ObservableList<String> pesquisa = FXCollections.observableArrayList();

		try {
			pesquisa.addAll("ID", "CPF", "NOME", "ENDEREÇO");
			clientesComboBox.setItems(pesquisa);

			colID.setCellValueFactory(new PropertyValueFactory<>("id"));
			colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

			tableCliente.setItems(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void abrirClientesADD() {
		TelasSecudaria.load(telasSecNome.ClientesADD);
	}
}