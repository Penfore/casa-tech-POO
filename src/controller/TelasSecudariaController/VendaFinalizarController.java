package src.controller.TelasSecudariaController;

import java.net.URL;
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

public class VendaFinalizarController extends FecharTelaSec implements Initializable{
    @FXML private ComboBox<String> formaPagamentoComboBox;
	@FXML private Label Total;
	@FXML
	private Label NomeCliente;

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
	
	VendaBO bo = new VendaBO();

	CarrinhoVO carrinho = new CarrinhoVO();
	CarrinhoBO carrinhoBO = new CarrinhoBO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	 ObservableList<String> formaPagamento = FXCollections.observableArrayList();
        formaPagamento.addAll("DINHEIRO","CARTÃO DE DEBITO","CARTÃO DE CREDITO","PIX");
        formaPagamentoComboBox.setItems(formaPagamento);
        
        carrinho.setVenda(TelasPrincipal.getVenda());
		ObservableList<CarrinhoVO> index = FXCollections.observableArrayList(carrinhoBO.listByVenda(carrinho));
		
		colProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
		colQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		colValor.setCellValueFactory(new PropertyValueFactory<>("value"));

		
		tableCarrinho.setItems(index);
		tableCarrinho.setEditable(true);
		tableCarrinho.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		tableCarrinho.getSelectionModel().setCellSelectionEnabled(true);
		
		NomeCliente.setText(TelasPrincipal.getVenda().getComprador().getNome());
		Total.setText(String.valueOf(TelasPrincipal.getVenda().getPrecoTotal()));
		
	}
	public void finalizar(ActionEvent event) throws Exception {
		
		TelasPrincipal.getVenda().setFormaDePagamento(formaPagamentoComboBox.getValue().toString());
		TelasPrincipal.getVenda().setStatus("FINALIZADO");
		System.out.println(TelasPrincipal.getVenda().getFormaDePagamento());
		bo.updateById(TelasPrincipal.getVenda());
		TelasPrincipal.setVenda(null);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.venda);
	}
}
