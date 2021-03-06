package src.controller.TelasSecudariaController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import src.controller.FecharTelaSec;
import src.model.bo.ClienteBO;
import src.model.bo.VendaBO;
import src.model.vo.ClienteVO;
import src.model.vo.VendaVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;

public class ClienteVendaADDController extends FecharTelaSec implements Initializable {
	@FXML
	private TableView<ClienteVO> tableCliente;
	@FXML
	private TextField pesquisa;
	@FXML
	private TableColumn<ClienteVO, Integer> colID;
	@FXML
	private TableColumn<ClienteVO, String> colNome;
	@FXML
	private TableColumn<ClienteVO, String> colCPF;
	@FXML
	private TableColumn<ClienteVO, String> colEndereco;

	ClienteVO vo = new ClienteVO();
	ClienteBO Cbo = new ClienteBO();
	VendaBO Vbo = new VendaBO();
	VendaBO bo = new VendaBO();
	ObservableList<ClienteVO> index = FXCollections.observableArrayList(Cbo.index());

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			colID.setCellValueFactory(new PropertyValueFactory<>("id"));
			colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

			tableCliente.setItems(index);

			tableCliente.setEditable(true);
			tableCliente.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			tableCliente.getSelectionModel().setCellSelectionEnabled(true);

			tableCliente.setOnMouseClicked((MouseEvent event) -> {
				if (event.getClickCount() == 1) {
					if (tableCliente.getSelectionModel().getSelectedItem() != null) {
						this.vo = tableCliente.getSelectionModel().getSelectedItem();
					}
				}
			});

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Add(ActionEvent event) throws Exception {

		VendaVO venda = new VendaVO();
		venda.setComprador(this.vo);

		Vbo.store(venda);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.NovaVenda);
	}

	public void listBy(ActionEvent event) throws Exception {
		ClienteVO vo = new ClienteVO();
		if (!pesquisa.getText().equals("") && pesquisa.getText() != null) {
			vo.setNome(pesquisa.getText());
			ObservableList<ClienteVO> indexNOME = FXCollections.observableArrayList(Cbo.findByNome(vo));
			tableCliente.setItems(indexNOME);
		}else {
			ObservableList<ClienteVO> indexNOME = FXCollections.observableArrayList(Cbo.index());
			tableCliente.setItems(indexNOME);
		}
	}
}
