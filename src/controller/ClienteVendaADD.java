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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.model.bo.ClienteBO;
import src.model.bo.VendaBO;
import src.model.vo.ClienteVO;


public class ClienteVendaADD {
	
//	@FXML private TableView<ClienteVO> tableCLientes;
//	@FXML private TableColumn<ClienteVO,Integer> colID;
//	@FXML private TableColumn<ClienteVO,String> colCPF;
//	@FXML private TableColumn<ClienteVO,String> colNome;
//	@FXML private TableColumn<ClienteVO,String> colEndereco;
	
	ClienteBO bo = new ClienteBO();

	
//    public void initialize(URL location, ResourceBundle resources) {
//    	
//    	
//    	colID.setCellValueFactory(new PropertyValueFactory<>("id"));
//    	colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
//    	colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
//    	colEndereco.setCellValueFactory(new PropertyValueFactory<>("rua"));
//    	
//    	tableCLientes.setItems(observableList);
//
//    	tableCLientes.setEditable(true);
//
//    	tableCLientes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//    	tableCLientes.getSelectionModel().setCellSelectionEnabled(true);
//    }
    
    ObservableList<ClienteVO> observableList= FXCollections.observableArrayList(
			bo.index()
    );
    
    public void cadastrarVenda(ActionEvent event) throws SQLException {
    	VendaBO bo = new VendaBO();
    	
    	
    
    }
}
