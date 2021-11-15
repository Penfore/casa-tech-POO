package src.controller.TelasPrincipaisController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.controller.TrocarTelas;
import src.model.bo.EquipamentoBO;
import src.model.vo.EquipamentoVO;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class EstoqueController extends TrocarTelas implements Initializable{
    @FXML private ComboBox<String> estoqueComboBox;
    
	@FXML private TableView<EquipamentoVO> tableEquipamento;	

	@FXML private TableColumn<EquipamentoVO, String> colNome;	
	@FXML private TableColumn<EquipamentoVO, String> colDesc;	
	@FXML private TableColumn<EquipamentoVO, Integer> colQtd;	
	@FXML private TableColumn<EquipamentoVO, String> colCOD;	
	@FXML private TableColumn<EquipamentoVO, Float> colPeso;	
	@FXML private TableColumn<EquipamentoVO, Float> colValor;
	
	EquipamentoBO bo = new EquipamentoBO();

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> pesquisa = FXCollections.observableArrayList();

        ObservableList<EquipamentoVO> index = FXCollections.observableArrayList(bo.index());
		
        try {
            pesquisa.addAll("NOME", "CÓDIGO", "RESPONSÁVEL", "LOCAL");
            estoqueComboBox.setItems(pesquisa);
            
        	colCOD.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        	colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        	colDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        	colQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        	colPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        	colValor.setCellValueFactory(new PropertyValueFactory<>("preco"));
        	
        	tableEquipamento.setItems(index);
    
        	tableEquipamento.setEditable(true);
    
        	tableEquipamento.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	tableEquipamento.getSelectionModel().setCellSelectionEnabled(true);
        	
        	
        } catch (Exception e) {
			System.out.println(e.getMessage());
		}

    }

    public void abrirProdutoADD() {
        TelasSecudaria.load(telasSecNome.ProdutoADD);
    }
}