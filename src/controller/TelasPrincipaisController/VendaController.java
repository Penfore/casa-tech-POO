package src.controller.TelasPrincipaisController;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

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
import src.model.bo.VendaBO;
import src.model.vo.ClienteVO;
import src.model.vo.VendaVO;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class VendaController extends TrocarTelas implements Initializable{ 
	@FXML private ComboBox<String> vendasComboBox;
	@FXML private TextField pesquisa;
	
	@FXML private TableView<VendaVO> tableVenda;
	
	@FXML private TableColumn<VendaVO, Integer> colID;
	@FXML private TableColumn<VendaVO, String> colData;
	@FXML private TableColumn<VendaVO, String> colStatus;
	@FXML private TableColumn<VendaVO, Float> colTotal;
	@FXML private TableColumn<VendaVO, String> colCliente;
	@FXML TableColumn<VendaVO, VendaVO> colOptions;
	
	VendaBO bo = new VendaBO();
	ObservableList<VendaVO> index = FXCollections.observableArrayList(bo.index());
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> pesquisa = FXCollections.observableArrayList();
		
		try {
			pesquisa.addAll("FIND BY", "ID", "CLIENTE");
			vendasComboBox.setItems(pesquisa);
			
			colID.setCellValueFactory(new PropertyValueFactory<>("id"));
			colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
			colTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
			
			colData.setCellValueFactory((data -> 
			new SimpleStringProperty( 
				new Date(data.getValue().getDataDeCompra().getTimeInMillis())	
    			.toString()
			)));
			
			colCliente.setCellValueFactory((comprador -> 
    		new SimpleStringProperty(comprador.getValue().getComprador().getNome())));
			
			colOptions.setCellValueFactory(
				    param -> new ReadOnlyObjectWrapper<>(param.getValue())
				);
			colOptions.setCellFactory(param -> new TableCell<VendaVO, VendaVO>() {
				    private final Button deleteButton = new Button("excluir");

				    @Override
				    protected void updateItem(VendaVO vo, boolean empty) {
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
				            	tableVenda.setItems(index);
				            }
				        );
				    }
				});

			tableVenda.setItems(index);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listBy(ActionEvent event) throws Exception {
		VendaVO vo  = new VendaVO();
		
		if(!pesquisa.getText().equals("") && pesquisa.getText() !=null) {
			
			switch(vendasComboBox.getValue()) {
				case "ID":	

					vo.setId(Integer.parseInt(pesquisa.getText()));
					System.out.println(vo.getId());
					ObservableList<VendaVO> indexID = FXCollections.observableArrayList(bo.show(vo));
					tableVenda.setItems(indexID);
					break;
				
				case "CLIENTE":
					ClienteVO voC  = new ClienteVO();
					voC.setNome(pesquisa.getText());
					voC.setId(1);
					vo.setComprador(voC);
					ObservableList<VendaVO> indexCliente = FXCollections.observableArrayList(bo.findByCliente(vo));
					tableVenda.setItems(indexCliente);
					break;
				
					
				case "FIND BY":
					tableVenda.setItems(index);
					break;
			}
		}
	}

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
