package src.controller.TelasPrincipaisController.RelatoriosController;

import java.net.URL;
import java.sql.SQLException;
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
import src.model.bo.EquipamentoBO;
import src.model.vo.EquipamentoVO;

public class RelatoriosEstoqueController extends TrocarTelas implements Initializable{
	@FXML private Label MaisVendido;
	@FXML private Label qtdMaisVendido;
	@FXML private Label qtdEstoque;

	@FXML private TableView<EquipamentoVO> tableEquipamento;	

	@FXML private TableColumn<EquipamentoVO, String> colID;
	@FXML private TableColumn<EquipamentoVO, String> colNome;	
	@FXML private TableColumn<EquipamentoVO, Integer> colQtd;	
	@FXML private TableColumn<EquipamentoVO, Float> colValor;	
	@FXML private TableColumn<EquipamentoVO, Integer> colQtdVendida;	

	EquipamentoBO bo = new EquipamentoBO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<EquipamentoVO> index = FXCollections.observableArrayList(bo.index());
		try {

			MaisVendido.setText(bo.EquipamentoMaisVendido().toUpperCase());
			qtdMaisVendido.setText(bo.TotalEquipamentosVendidos().toString());
			qtdEstoque.setText(bo.quantidadeEstoque().toString());

			tableEquipamento.setItems(index);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
