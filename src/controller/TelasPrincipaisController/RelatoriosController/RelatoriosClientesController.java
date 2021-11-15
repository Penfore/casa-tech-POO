package src.controller.TelasPrincipaisController.RelatoriosController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.controller.TrocarTelas;
import src.model.bo.ClienteBO;
import src.model.vo.ClienteVO;

public class RelatoriosClientesController extends TrocarTelas implements Initializable{
	@FXML private Label qtdCliente;
	
	@FXML private TableView<ClienteVO> tableCliente;

	@FXML private TableColumn<ClienteVO, Integer> colID;
	@FXML private TableColumn<ClienteVO, String> colNome;
	@FXML private TableColumn<ClienteVO, String> colCPF;
	@FXML private TableColumn<ClienteVO, String> colEndereco;
	
	ClienteBO bo = new ClienteBO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<ClienteVO> index = FXCollections.observableArrayList(bo.index());
		
		try {

			colID.setCellValueFactory(new PropertyValueFactory<>("id"));
			colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
			
			qtdCliente.setText(bo.quantidadeClientes().toString());
			tableCliente.setItems(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
    
}
