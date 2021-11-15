package src.controller.TelasPrincipaisController.RelatoriosController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import src.controller.TrocarTelas;
import src.model.bo.VendaBO;

public class RelatoriosVendasController extends TrocarTelas implements Initializable{
	@FXML private Label VendaMes;
	@FXML private Label Finalizadas;
	@FXML private Label Capital;
	@FXML private Label Canceladas;
	@FXML private Label Pagamento;
	@FXML private Label Total;
	
	VendaBO bo = new VendaBO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			VendaMes.setText(bo.vendasDoMes().toString());
			Finalizadas.setText(bo.vendasFinalizadas().toString());
			Capital.setText(bo.TotalPrecoVendido().toString());
			Canceladas.setText(bo.vendasCanceladas().toString());
			Pagamento.setText(bo.PagamentoMaisUsado().toUpperCase());
			Total.setText(bo.totalVendas().toString());
			
		} catch (SQLException e) {

			e.printStackTrace();
		}

		
	}
    
}
