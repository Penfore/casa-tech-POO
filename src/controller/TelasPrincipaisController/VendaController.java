package src.controller.TelasPrincipaisController;

import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.controller.TrocarTelas;
import src.model.bo.VendaBO;
import src.model.vo.VendaVO;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class VendaController extends TrocarTelas implements Initializable{ 
	@FXML private TableView<VendaVO> tableVenda;

	@FXML private TableColumn<VendaVO, Integer> colCOD;
	@FXML private TableColumn<VendaVO, Calendar> colData;
	@FXML private TableColumn<VendaVO, String> colStatus;
	@FXML private TableColumn<VendaVO, Float> colTotal;
	
	VendaBO bo = new VendaBO();
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			ObservableList<VendaVO> index = FXCollections.observableArrayList(bo.index());

			colCOD.setCellValueFactory(new PropertyValueFactory<>("id"));
			colData.setCellValueFactory(new PropertyValueFactory<>("datadecompra"));
			colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
			colTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));

			tableVenda.setItems(index);

			tableVenda.setEditable(true);

			tableVenda.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			tableVenda.getSelectionModel().setCellSelectionEnabled(true);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

    //Ao tentar trocar a tela inserir botão que leve para "cancelarVenda"
    public void abrirClienteVendaADD() {
        TelasSecudaria.load(telasSecNome.ClienteVendaADD);
    }

    public void abrirVendaADD() {
        TelasSecudaria.load(telasSecNome.VendaADD);
    }
    public void abrirVendaExcluir() {
        TelasSecudaria.load(telasSecNome.VendaExcluir);
    }
    public void abrirVendaFinalizar() {
        TelasSecudaria.load(telasSecNome.VendaFinalizar);
    }


}
