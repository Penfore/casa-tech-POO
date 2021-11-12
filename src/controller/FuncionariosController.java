package src.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import src.model.bo.FuncionarioBO;
import src.model.vo.FuncionarioVO;

public class FuncionariosController implements Initializable {
    private Stage stage;
	@FXML private TableView<FuncionarioVO> funTable;
	@FXML private TableColumn<FuncionarioVO, String> funNome;
	@FXML private TableColumn<FuncionarioVO, String> funEmail;
	@FXML private TableColumn<FuncionarioVO, String> funEndereco;
	@FXML private TableColumn<FuncionarioVO, String> funTelefone;

    FuncionarioBO bo = new FuncionarioBO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		funNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		funEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
		funEndereco.setCellValueFactory(new PropertyValueFactory<>("Endereco"));
		funTelefone.setCellValueFactory(new PropertyValueFactory<>("Telefone"));

        //funTable.setItems(observableList);

		funTable.setEditable(true);

		funTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		funTable.getSelectionModel().setCellSelectionEnabled(true);
		
	}
}
