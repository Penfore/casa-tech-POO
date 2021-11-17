package src.controller.TelasSecudariaController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;
import src.controller.FecharTelaSec;
import src.model.bo.CarrinhoBO;
import src.model.bo.EquipamentoBO;
import src.model.vo.CarrinhoVO;
import src.model.vo.EquipamentoVO;
import src.model.vo.VendaVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;

public class VendaADDController extends FecharTelaSec implements Initializable{
	@FXML private TableView<EquipamentoVO> tableEquipamento;	

	@FXML private TableColumn<EquipamentoVO, Integer> colID;	
	@FXML private TableColumn<EquipamentoVO, Integer> colQtd;	
	@FXML private TableColumn<EquipamentoVO, String> colNome;	
	@FXML private TableColumn<EquipamentoVO, Float> colTotal;
	@FXML TableColumn<EquipamentoVO, EquipamentoVO> colOptions;
	
	 
	EquipamentoBO bo = new EquipamentoBO();
	ObservableList<EquipamentoVO> index = FXCollections.observableArrayList(bo.index());
	
	public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        	colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        	colQtd.setCellValueFactory(new PropertyValueFactory<>("qtd_Carrinho"));
        	
        	colQtd.setOnEditCommit((CellEditEvent<EquipamentoVO, Integer> event) -> {
        	    ((EquipamentoVO)event.getTableView().getItems().get(event.getTablePosition().getRow()))
        	    .setQtd_Carrinho(Integer.valueOf(event.getNewValue()));
        	});
        	colQtd.setCellFactory(TextFieldTableCell.<EquipamentoVO, Integer>forTableColumn(new IntegerStringConverter()));
        	
        	
			colOptions.setCellValueFactory(
				    param -> new ReadOnlyObjectWrapper<>(param.getValue())
			);
			colOptions.setCellFactory(param -> new TableCell<EquipamentoVO, EquipamentoVO>() {
			    private final Button adicionarButton = new Button("Adicionar");
			    
			    @Override
			    protected void updateItem(EquipamentoVO vo, boolean empty) {

					adicionarButton.setStyle(adicionarButton.getStyle() + "-fx-background-color: #07F49E;");
					adicionarButton.setStyle(adicionarButton.getStyle() + "-fx-text-fill: #FFFFFF;");
			        super.updateItem(vo, empty);
			        if (vo == null) {
			            setGraphic(null);
			            return;
			        }
			        setGraphic(adicionarButton);
			        adicionarButton.setOnAction(
			            event -> {
			            	System.out.println(vo.getQtd_Carrinho());
			            	addProdutoOnCarrinho(vo,TelasPrincipal.getVenda());
			            }
			        );
			    }
			});
        	tableEquipamento.setItems(index);
        	tableEquipamento.setEditable(true);
        	tableEquipamento.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	tableEquipamento.getSelectionModel().setCellSelectionEnabled(true);
        	
        } catch (Exception e) {
			System.out.println(e.getMessage());
		}
	} 
	
	public void addProdutoOnCarrinho(EquipamentoVO equip, VendaVO venda) {
		CarrinhoVO carrinho = new CarrinhoVO();
		carrinho.setVenda(venda);
		carrinho.setProduto(equip);
		carrinho.setQuantidade(equip.getQtd_Carrinho());
		CarrinhoBO add = new CarrinhoBO();
		
		add.store(carrinho);
	}
	public void finalizar(ActionEvent event) throws Exception {
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.NovaVenda);
	
	}
}
