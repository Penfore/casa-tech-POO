package src.controller.TelasPrincipaisController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import src.controller.TrocarTelas;
import src.model.bo.EquipamentoBO;
import src.model.vo.ClienteVO;
import src.model.vo.EquipamentoVO;
import src.model.vo.FuncionarioVO;
import src.model.vo.LocalVO;
import src.model.vo.VendaVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class EstoqueController extends TrocarTelas implements Initializable{
    @FXML private ComboBox<String> estoqueComboBox;
	@FXML private TextField pesquisa;
	@FXML private TableView<EquipamentoVO> tableEquipamento;	

	@FXML private TableColumn<EquipamentoVO, String> colNome;	
	@FXML private TableColumn<EquipamentoVO, String> colDesc;	
	@FXML private TableColumn<EquipamentoVO, Integer> colQtd;	
	@FXML private TableColumn<EquipamentoVO, String> colID;
	@FXML private TableColumn<EquipamentoVO, String> colCOD;	
	@FXML private TableColumn<EquipamentoVO, Float> colPeso;	
	@FXML private TableColumn<EquipamentoVO, Float> colValor;
	@FXML private TableColumn<EquipamentoVO, String> colRes;	
	@FXML private TableColumn<EquipamentoVO, String> colLocal;	
	@FXML TableColumn<EquipamentoVO, EquipamentoVO> colOptions;
	
	
	EquipamentoBO bo = new EquipamentoBO();
	ObservableList<EquipamentoVO> index = FXCollections.observableArrayList(bo.index());
	  
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> pesquisa = FXCollections.observableArrayList();
        try {
            pesquisa.addAll("FIND BY", "ID","NOME", "CÓDIGO", "RESPONSÁVEL", "LOCAL");
            estoqueComboBox.setItems(pesquisa);
            
            colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        	colCOD.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        	colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        	colLocal.setCellValueFactory(local -> Bindings.createStringBinding(
        			()-> local.getValue().getLocal().getCasa() + " - " + 
        					local.getValue().getLocal().getCompartimento()
        			));
        	colRes.setCellValueFactory((responsavel -> 
        		new SimpleStringProperty(responsavel.getValue().getResponsavel().getNome())));
        	
			colOptions.setCellValueFactory(
				    param -> new ReadOnlyObjectWrapper<>(param.getValue())
				);
			colOptions.setCellFactory(param -> new TableCell<EquipamentoVO, EquipamentoVO>() {
			    private final Button deleteButton = new Button("excluir");

			    @Override
			    protected void updateItem(EquipamentoVO vo, boolean empty) {
			        super.updateItem(vo, empty);
			        if (vo == null) {
			            setGraphic(null);
			            return;
			        }
			        setGraphic(deleteButton);
			        deleteButton.setOnAction(
			            event -> {
			            	bo.removeById(vo);
			            	index = FXCollections.observableArrayList(bo.index());
			            	tableEquipamento.setItems(index);
			            }
			        );
			    }
			});
        	tableEquipamento.setItems(index);
        	tableEquipamento.setEditable(true);
        	tableEquipamento.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        	tableEquipamento.getSelectionModel().setCellSelectionEnabled(true);
        	
			tableEquipamento.setOnMouseClicked((MouseEvent event) -> { 
				EquipamentoVO equip = tableEquipamento.getSelectionModel().getSelectedItem();
				 if (event.getClickCount() == 2 && equip!=null ) {
					 this.abrirProdutoEDIT(equip);
				 }

			});
        } catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }
	public void listBy(ActionEvent event) throws Exception {
		EquipamentoVO vo  = new EquipamentoVO();
		if(!pesquisa.getText().equals("") && pesquisa.getText() !=null) {
			
			switch(estoqueComboBox.getValue()) {
				case "ID":			
					vo.setId(Integer.parseInt(pesquisa.getText()));
					ObservableList<EquipamentoVO> indexID = FXCollections.observableArrayList(bo.show(vo));
					tableEquipamento.setItems(indexID);
					break;
				
				case "CÓDIGO":
					vo.setCodigo(pesquisa.getText());
					ObservableList<EquipamentoVO> indexCOD = FXCollections.observableArrayList(bo.findByCOD(vo));
					tableEquipamento.setItems(indexCOD);
					break;
				
				case "NOME":
					vo.setNome(pesquisa.getText());
					ObservableList<EquipamentoVO> indexNOME = FXCollections.observableArrayList(bo.findByNome(vo));
					tableEquipamento.setItems(indexNOME);
					break;
				
				case "RESPONSÁVEL":
					FuncionarioVO Fvo = new FuncionarioVO();
					Fvo.setNome(pesquisa.getText());
					vo.setResponsavel(Fvo);
					ObservableList<EquipamentoVO> indexRES = FXCollections.observableArrayList(bo.listByResponsavel(vo));
					tableEquipamento.setItems(indexRES);
					break;
					
				case "LOCAL":
					LocalVO Lvo = new LocalVO();
					Lvo.setCasa(pesquisa.getText());
					Lvo.setCompartimento(pesquisa.getText());
					vo.setLocal(Lvo);
					ObservableList<EquipamentoVO> indexLOCAL = FXCollections.observableArrayList(bo.listByLocal(vo));
					tableEquipamento.setItems(indexLOCAL);
					break;
					
				case "FIND BY":
					tableEquipamento.setItems(index);
					break;
					
				default:
					tableEquipamento.setItems(index);
					break;
			}
		}
	}
    public void abrirProdutoADD() {
        TelasSecudaria.load(telasSecNome.ProdutoADD);
    }
    public void abrirProdutoEDIT(EquipamentoVO vo) {
    	TelasPrincipal.setEquipamento(vo);
        TelasSecudaria.load(telasSecNome.ProdutoEdit);
    }
}