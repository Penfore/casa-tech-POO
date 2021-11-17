package src.controller.TelasPrincipaisController.RelatoriosController;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import src.controller.TrocarTelas;
import src.model.bo.FuncionarioBO;
import src.model.vo.FuncionarioVO;

public class RelatoriosFuncionariosController extends TrocarTelas implements Initializable{
	
	@FXML private Label qtdFun;

	
	FuncionarioBO bo = new FuncionarioBO();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			qtdFun.setText(bo.quantidadeFuncionarios().toString());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
    
}
