package src.controller.TelasPrincipaisController.RelatoriosController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import src.controller.TrocarTelas;
import src.model.bo.EquipamentoBO;

public class RelatoriosEstoqueController extends TrocarTelas implements Initializable{
	@FXML private Label MaisVendido;
	@FXML private Label qtdMaisVendido;
	@FXML private Label qtdEstoque;

	EquipamentoBO bo = new EquipamentoBO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			MaisVendido.setText(bo.EquipamentoMaisVendido().toUpperCase());
			qtdMaisVendido.setText(bo.TotalEquipamentosVendidos().toString());
			qtdEstoque.setText(bo.quantidadeEstoque().toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
