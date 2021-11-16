package src.controller.TelasPrincipaisController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.controller.TrocarTelas;
import src.model.bo.FuncionarioBO;
import src.model.vo.ClienteVO;
import src.model.vo.FuncionarioVO;
import src.model.vo.LocalVO;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class FuncionariosController extends TrocarTelas implements Initializable{
	
	@FXML private TableView<FuncionarioVO> tableFun;

	@FXML private TableColumn<FuncionarioVO, String> colNome;
	@FXML private TableColumn<FuncionarioVO, String> colEmail;
	@FXML private TableColumn<FuncionarioVO, String> colEndereco;
	@FXML private TableColumn<FuncionarioVO, String> colTelefone;
	@FXML TableColumn<FuncionarioVO, FuncionarioVO> colOptions;
	
	FuncionarioBO bo = new FuncionarioBO();
	ObservableList<FuncionarioVO> index = FXCollections.observableArrayList(bo.index());
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
			colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
			colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
			
			colOptions.setCellValueFactory(
				    param -> new ReadOnlyObjectWrapper<>(param.getValue())
				);
			colOptions.setCellFactory(param -> new TableCell<FuncionarioVO, FuncionarioVO>() {
			    private final Button deleteButton = new Button("excluir");

			    @Override
			    protected void updateItem(FuncionarioVO vo, boolean empty) {
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
			            	tableFun.setItems(index);
			            }
			        );
			    }
			});

			tableFun.setItems(index);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
    public void abrirFuncionariosADD() {
        TelasSecudaria.load(telasSecNome.FuncionariosADD);
    }



}