package src.controller.TelasSecudariaController;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.controller.FecharTelaSec;
import src.model.bo.CarrinhoBO;
import src.model.bo.VendaBO;
import src.model.vo.CarrinhoVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;

public class ReciboController extends FecharTelaSec implements Initializable{
	@FXML
	private TableView<CarrinhoVO> tableCarrinho;
	@FXML
	private TableColumn<CarrinhoVO, String> colProduto;
	@FXML
	private TableColumn<CarrinhoVO, Integer> colQtd;
	@FXML
	private TableColumn<CarrinhoVO, Float> colValor;

	@FXML
	private TableColumn<CarrinhoVO, CarrinhoVO> colOptions;
	
	@FXML private Label CliNome;
	@FXML private Label ClieEndereco;
	@FXML private Label CliEmail;
	@FXML private Label ClieTelefone;
	@FXML private Label ClieCPF;
	
	
	@FXML private Label VendaID;
	@FXML private Label Pagamento;
	@FXML private Label Total;
	@FXML private Label Data;
	
	VendaBO bo = new VendaBO();

	CarrinhoVO carrinho = new CarrinhoVO();
	CarrinhoBO carrinhoBO = new CarrinhoBO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

        carrinho.setVenda(TelasPrincipal.getRecibo());
		ObservableList<CarrinhoVO> index = FXCollections.observableArrayList(carrinhoBO.listByVenda(carrinho));
		
		colProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
		colQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		colValor.setCellValueFactory(new PropertyValueFactory<>("value"));

		
		tableCarrinho.setItems(index);
		tableCarrinho.setEditable(true);
		tableCarrinho.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tableCarrinho.getSelectionModel().setCellSelectionEnabled(true);		

		VendaID.setText(String.valueOf(TelasPrincipal.getRecibo().getId()));
		Pagamento.setText(String.valueOf(TelasPrincipal.getRecibo().getFormaDePagamento()));
		Total.setText(String.valueOf(TelasPrincipal.getRecibo().getPrecoTotal()));
		Data.setText(String.valueOf(new Date(TelasPrincipal.getRecibo().getDataDeCompra().getTimeInMillis())));
		
		System.out.println(TelasPrincipal.getRecibo().getComprador().getEmail());
		CliNome.setText(String.valueOf(TelasPrincipal.getRecibo().getComprador().getNome()));
		ClieEndereco.setText(String.valueOf(TelasPrincipal.getRecibo().getComprador().getEndereco()));
		CliEmail.setText(String.valueOf(TelasPrincipal.getRecibo().getComprador().getEmail()));
		ClieTelefone.setText(String.valueOf(TelasPrincipal.getRecibo().getComprador().getTelefone()));
		ClieCPF.setText(String.valueOf(TelasPrincipal.getRecibo().getComprador().getCpf()));


		
		
	}
}
