package src.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import src.model.bo.FuncionarioBO;
import src.model.bo.VendaBO;
import src.model.vo.VendaVO;
import src.view.Login;
import src.view.Venda;

public class VendaController implements Initializable {
	Venda venda = new Venda();
	Login t = new Login();
	private Stage stage;

	@FXML
	private TableView<VendaVO> tableVenda;
	@FXML
	private TableColumn<VendaVO, Integer> colCOD;
	@FXML
	private TableColumn<VendaVO, Calendar> colData;
	@FXML
	private TableColumn<VendaVO, String> colStatus;
	@FXML
	private TableColumn<VendaVO, Float> colTotal;
	
	@FXML private Label NomeUsuario;
	VendaBO bo = new VendaBO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {

			colCOD.setCellValueFactory(new PropertyValueFactory<>("id"));
			colData.setCellValueFactory(new PropertyValueFactory<>("datadecompra"));
			colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
			colTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));

			tableVenda.setItems(observableList);

			tableVenda.setEditable(true);

			tableVenda.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			tableVenda.getSelectionModel().setCellSelectionEnabled(true);

			t.start(new Stage());
			System.out.println(t.controller.authfunvo.getNickName());
			
			NomeUsuario.setText(t.controller.authfunvo.getNickName());

			
		} catch (Exception e) {

		}

	}

	ObservableList<VendaVO> observableList = FXCollections.observableArrayList(bo.index());

	public void NovaVenda(ActionEvent event) throws SQLException {
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		venda.ModalVendaAdd(stage);

	}

}
