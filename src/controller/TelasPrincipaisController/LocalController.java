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
import src.model.bo.LocalBO;
import src.model.vo.EquipamentoVO;
import src.model.vo.LocalVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class LocalController extends TrocarTelas implements Initializable {
	@FXML private ComboBox<String> localComboBox;	
	@FXML private TextField pesquisa;

	@FXML private Label nomeUsu; 
	
	@FXML private TableView<LocalVO> tableLocal;
	
	@FXML private TableColumn<LocalVO, Integer> colID;
	@FXML private TableColumn<LocalVO, String> colCasa;
	@FXML private TableColumn<LocalVO, String> colComp;
	@FXML TableColumn<LocalVO, LocalVO> colOptions;

	LocalBO bo = new LocalBO();
	ObservableList<LocalVO> index = FXCollections.observableArrayList(bo.index());
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		ObservableList<String> pesquisa = FXCollections.observableArrayList();
		try {
			pesquisa.addAll("FIND BY","CASA", "COMPARTIMENTO");

			localComboBox.setItems(pesquisa);
			
			colID.setCellValueFactory(new PropertyValueFactory<>("id"));
			colCasa.setCellValueFactory(new PropertyValueFactory<>("casa"));
			colComp.setCellValueFactory(new PropertyValueFactory<>("compartimento"));
			
			colOptions.setCellValueFactory(
				    param -> new ReadOnlyObjectWrapper<>(param.getValue())
				);
			colOptions.setCellFactory(param -> new TableCell<LocalVO, LocalVO>() {
			    private final Button deleteButton = new Button("Excluir");

			    @Override
			    protected void updateItem(LocalVO vo, boolean empty) {
					
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
			            	tableLocal.setItems(index);
			            }
			        );
			    }
			});

			tableLocal.setItems(index);

			tableLocal.setOnMouseClicked((MouseEvent event) -> { 
				LocalVO local = tableLocal.getSelectionModel().getSelectedItem();
				 if (event.getClickCount() == 2 && local!=null ) {
					 this.abrirLocalEDIT(local);
				 }
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listBy(ActionEvent event) throws Exception {
	LocalVO vo  = new LocalVO();
	if(!pesquisa.getText().equals("") && pesquisa.getText() !=null) {
		
		switch(localComboBox.getValue()) {
			case "ID":			
				vo.setId(Integer.parseInt(pesquisa.getText()));
				ObservableList<LocalVO> indexID = FXCollections.observableArrayList(bo.show(vo));
				tableLocal.setItems(indexID);
				break;
			
			case "CASA":
				vo.setCasa(pesquisa.getText());
				ObservableList<LocalVO> indexCPF = FXCollections.observableArrayList(bo.findByCasa(vo));
				tableLocal.setItems(indexCPF);
				break;
			
			case "COMPARTIMENTO":
				vo.setCompartimento(pesquisa.getText());
				ObservableList<LocalVO> indexNOME = FXCollections.observableArrayList(bo.listByCompartimento(vo));
				tableLocal.setItems(indexNOME);
				break;
				
			case "FIND BY":
				tableLocal.setItems(index);
				break;
		}
	}
}

	public void abrirLocalADD() {
		TelasSecudaria.load(telasSecNome.LocalADD);
	}

	public void abrirLocalEDIT(LocalVO vo) {
    	TelasPrincipal.setLocal(vo);
        TelasSecudaria.load(telasSecNome.LocalEdit);
    }
}
