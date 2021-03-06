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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import src.controller.TrocarTelas;
import src.model.bo.FuncionarioBO;
import src.model.vo.FuncionarioVO;
import src.model.vo.LocalVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class FuncionariosController extends TrocarTelas implements Initializable{
	@FXML private Label nomeUsu;
	@FXML private ComboBox<String> FunComboBox;	
	@FXML private TextField pesquisa;
	@FXML private TableView<FuncionarioVO> tableFun;

	@FXML private TableColumn<FuncionarioVO, String> colNome;
	@FXML private TableColumn<FuncionarioVO, Integer> colID;
	@FXML private TableColumn<FuncionarioVO, String> colEmail;
	@FXML private TableColumn<FuncionarioVO, String> colEndereco;
	@FXML private TableColumn<FuncionarioVO, String> colTelefone;
	@FXML TableColumn<FuncionarioVO, FuncionarioVO> colOptions;
	
	FuncionarioBO bo = new FuncionarioBO();
	ObservableList<FuncionarioVO> index = FXCollections.observableArrayList(bo.index());
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> pesquisa = FXCollections.observableArrayList();
		try {
			pesquisa.addAll("FIND BY","ID","NOME");

			FunComboBox.setItems(pesquisa);
			colID.setCellValueFactory(new PropertyValueFactory<>("id"));
			colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
			colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
			colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
			
			colOptions.setCellValueFactory(
				    param -> new ReadOnlyObjectWrapper<>(param.getValue())
				);
			colOptions.setCellFactory(param -> new TableCell<FuncionarioVO, FuncionarioVO>() {
			    private final Button deleteButton = new Button("Excluir");

			    @Override
			    protected void updateItem(FuncionarioVO vo, boolean empty) {
					
					deleteButton.setStyle(deleteButton.getStyle() + "-fx-background-color: #F40779;");
					deleteButton.setStyle(deleteButton.getStyle() + "-fx-text-fill: #FFFFFF;");
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
			            	tableFun.setItems(index);
			            }
			        );
			    }
			});

			tableFun.setItems(index);
			
			tableFun.setOnMouseClicked((MouseEvent event) -> { 
				FuncionarioVO fun = tableFun.getSelectionModel().getSelectedItem();
				 if (event.getClickCount() == 2 && fun!=null ) {
					 this.abrirFunEDIT(fun);
				 }
			});
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public void listBy(ActionEvent event) throws Exception {
		FuncionarioVO vo  = new FuncionarioVO();
	if(!pesquisa.getText().equals("") && pesquisa.getText() !=null) {
		
		switch(FunComboBox.getValue()) {
			case "ID":			
				vo.setId(Integer.parseInt(pesquisa.getText()));
				ObservableList<FuncionarioVO> indexID = FXCollections.observableArrayList(bo.show(vo));
				tableFun.setItems(indexID);
				break;
			
			case "NOME":
				vo.setNome(pesquisa.getText());
				ObservableList<FuncionarioVO> indexCPF = FXCollections.observableArrayList(bo.findByNome(vo));
				tableFun.setItems(indexCPF);
				break;
				
			case "FIND BY":
				tableFun.setItems(index);
				break;
		}
	}
}
    public void abrirFuncionariosADD() {
        TelasSecudaria.load(telasSecNome.FuncionariosADD);
    }
	public void abrirFunEDIT(FuncionarioVO vo) {
    	TelasPrincipal.setFuncionario(vo);
        TelasSecudaria.load(telasSecNome.FuncionariosEdit);
    }



}