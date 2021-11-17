package src.controller.TelasSecudariaController;

import javafx.event.ActionEvent;
import src.controller.FecharTelaSec;
import src.model.bo.VendaBO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;

public class VendaExcluirController extends FecharTelaSec{
	
	public void excluir(ActionEvent event) throws Exception {
		VendaBO bo = new VendaBO();
		TelasPrincipal.getVenda().setStatus("CANCELADO");
		TelasPrincipal.getVenda().setFormaDePagamento("--");
		bo.updateById(TelasPrincipal.getVenda());
		TelasPrincipal.setVenda(null);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.venda);
	}
}
