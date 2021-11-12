package src.controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import src.model.bo.ClienteBO;
import src.model.bo.FuncionarioBO;
import src.model.bo.VendaBO;
import src.model.vo.ClienteVO;
import src.model.vo.VendaVO;
import src.view.Clientes;
import src.view.Login;
import src.view.Venda;

public class ClienteController implements Initializable {
	Clientes cliente = new Clientes();
	private Stage stage;
	@FXML private TableView<ClienteVO> tableCliente;
	@FXML private TableColumn<ClienteVO, Integer> colID;
	@FXML private TableColumn<ClienteVO, String> colCPF;
	@FXML private TableColumn<ClienteVO, String> colNOME;
	@FXML private TableColumn<ClienteVO, String> colENDERECO;
	

	
	ClienteBO bo = new ClienteBO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		colID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		colNOME.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colENDERECO.setCellValueFactory(new PropertyValueFactory<>("endereco"));

		tableCliente.setItems(observableList);

		tableCliente.setEditable(true);

		tableCliente.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tableCliente.getSelectionModel().setCellSelectionEnabled(true);
		
	}
	
	ObservableList<ClienteVO> observableList = FXCollections.observableArrayList(bo.index());

	public void NovoCliente(ActionEvent event) throws SQLException {
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		cliente.NovoCliente(stage);

	}
	
	public void addCliente(ActionEvent event)throws SQLException {
		System.out.println("chegou aqui");
	}

}
