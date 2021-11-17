package src.controller.TelasPrincipaisController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.controller.TrocarTelas;
import src.model.bo.CarrinhoBO;
import src.model.bo.VendaBO;
import src.model.vo.CarrinhoVO;
import src.model.vo.EquipamentoVO;
import src.model.vo.VendaVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;
import src.view.telas.telasSecundarias.telasSecNome;

public class VendaProdutosController extends TrocarTelas implements Initializable {
	VendaVO vo = new VendaVO();
	@FXML
	private Label NomeCliente;
	@FXML
	private Label Total;

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
	ObservableList<CarrinhoVO> index;
	Integer total = 0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (TelasPrincipal.getVenda() != null) {
			carrinho.setVenda(TelasPrincipal.getVenda());
			this.index = FXCollections.observableArrayList(carrinhoBO.listByVenda(carrinho));

			colProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
			colQtd.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
			colValor.setCellValueFactory(new PropertyValueFactory<>("value"));
			
			tableCarrinho.setItems(index);
			tableCarrinho.setEditable(true);
			tableCarrinho.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			tableCarrinho.getSelectionModel().setCellSelectionEnabled(true);
			
			colOptions.setCellValueFactory(
				    param -> new ReadOnlyObjectWrapper<>(param.getValue())
				);
			colOptions.setCellFactory(param -> new TableCell<CarrinhoVO, CarrinhoVO>() {
			    private final Button deleteButton = new Button("excluir");

			    @Override
			    protected void updateItem(CarrinhoVO vo, boolean empty) {
			        super.updateItem(vo, empty);
			        if (vo == null) {
			            setGraphic(null);
			            return;
			        }
			        setGraphic(deleteButton);
			        deleteButton.setOnAction(
			            event -> {
			            	System.out.println("evento");
			            	vo.setVenda(TelasPrincipal.getVenda());
			            	carrinhoBO.removeById(vo);
			            	index = FXCollections.observableArrayList(carrinhoBO.listByVenda(carrinho));
			            	tableCarrinho.setItems(index);
			            }
			        );
			    }
			});
			NomeCliente.setText(TelasPrincipal.getVenda().getComprador().getNome());
			
			index.forEach(item ->{
				this.total = (int) (this.total + item.getValue());
			});
			
			Total.setText(total.toString());
			TelasPrincipal.getVenda().setPrecoTotal(total);
		}
	}

	public void abrirClienteVendaADD() {
		if (TelasPrincipal.getVenda() == null) {
			TelasSecudaria.load(telasSecNome.ClienteVendaADD);
		}
	}

	public void abrirVendaADD() {
		if (TelasPrincipal.getVenda() != null) {
		TelasSecudaria.load(telasSecNome.VendaADD);
		}
	}

	public void abrirVendaExcluir() {
		if (TelasPrincipal.getVenda() != null) {
			TelasSecudaria.load(telasSecNome.VendaExcluir);
		}
	}

	public void abrirVendaFinalizar() {
		if (TelasPrincipal.getVenda() != null) {
			TelasSecudaria.load(telasSecNome.VendaFinalizar);
		}
	}

}
