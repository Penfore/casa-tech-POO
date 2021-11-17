package src.controller.TelasPrincipaisController;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import src.controller.TrocarTelas;
import src.model.bo.ClienteBO;
import src.model.vo.ClienteVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class ClientesController extends TrocarTelas implements Initializable {
	@FXML private ComboBox<String> clientesComboBox;
	@FXML private TextField pesquisa;

	@FXML private TableView<ClienteVO> tableCliente;

	@FXML private TableColumn<ClienteVO, Integer> colID;
	@FXML private TableColumn<ClienteVO, String> colNome;
	@FXML private TableColumn<ClienteVO, String> colCPF;
	@FXML private TableColumn<ClienteVO, String> colEndereco;
	@FXML private TableColumn<ClienteVO, String> colEmail;
	@FXML private TableColumn<ClienteVO, ClienteVO> colOptions;


	ClienteBO bo = new ClienteBO();
	
	ObservableList<ClienteVO> index = FXCollections.observableArrayList(bo.index());

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		ObservableList<String> pesquisa = FXCollections.observableArrayList();

		try {
			pesquisa.addAll("FIND BY", "ID", "CPF", "NOME");
			
			clientesComboBox.setItems(pesquisa);
			

			colID.setCellValueFactory(new PropertyValueFactory<>("id"));
			colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
			colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

			colOptions.setCellValueFactory(
				    param -> new ReadOnlyObjectWrapper<>(param.getValue())
				);
			colOptions.setCellFactory(param -> new TableCell<ClienteVO, ClienteVO>() {
			    private final Button deleteButton = new Button("excluir");

			    @Override
			    protected void updateItem(ClienteVO vo, boolean empty) {
			        super.updateItem(vo, empty);
			        if (vo == null) {
			            setGraphic(null);
			            return;
			        }
			        setGraphic(deleteButton);
			        deleteButton.setOnAction(
			            event -> {
			            	bo.removeById(vo);
			            	index = FXCollections.observableArrayList(bo.index());
			            	tableCliente.setItems(index);
			            }
			        );
			    }
			});

			tableCliente.setItems(index);

			tableCliente.setOnMouseClicked((MouseEvent event) -> { 
				ClienteVO client = tableCliente.getSelectionModel().getSelectedItem();
				 if (event.getClickCount() == 2 && client!=null ) {
					 this.abrirClienteEDIT(client);
				 }
	
			});



		} catch (Exception e) {
			System.out.println(e.getMessage());
		}


		
	}
	
	public void listBy(ActionEvent event) throws Exception {
		ClienteVO vo  = new ClienteVO();
		if(!pesquisa.getText().equals("") && pesquisa.getText() !=null) {
			
			switch(clientesComboBox.getValue()) {
				case "ID":			
					vo.setId(Integer.parseInt(pesquisa.getText()));
					ObservableList<ClienteVO> indexID = FXCollections.observableArrayList(bo.show(vo));
					tableCliente.setItems(indexID);
					break;
				
				case "CPF":
					vo.setCpf(pesquisa.getText());
					ObservableList<ClienteVO> indexCPF = FXCollections.observableArrayList(bo.findByCPF(vo));
					tableCliente.setItems(indexCPF);
					break;
				
				case "NOME":
					vo.setNome(pesquisa.getText());
					ObservableList<ClienteVO> indexNOME = FXCollections.observableArrayList(bo.findByNome(vo));
					tableCliente.setItems(indexNOME);
					break;
					
				case "FIND BY":
					tableCliente.setItems(index);
					break;
			}
		}
	}
	
	public void abrirClientesADD() {
		TelasSecudaria.load(telasSecNome.ClientesADD);
	}

	public void abrirClienteEDIT(ClienteVO vo) {
    	TelasPrincipal.setCliente(vo);
        TelasSecudaria.load(telasSecNome.ClientesEdit);
    }
}