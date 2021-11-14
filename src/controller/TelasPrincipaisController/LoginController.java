package src.controller.TelasPrincipaisController;

import java.sql.SQLException;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.model.bo.FuncionarioBO;
import src.model.vo.FuncionarioVO;

public class LoginController {
	@FXML private TextField login;
	@FXML private TextField senha;
	private Stage stage;
	FuncionarioVO authfunvo = new FuncionarioVO();
	
	public void auth(ActionEvent event) throws Exception {
		//Venda venda = new Venda();
		FuncionarioBO bo = new FuncionarioBO();
		FuncionarioVO funvo = new FuncionarioVO();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		funvo.setNickName(login.getText());
		funvo.setSenha(senha.getText());
		
	
		this.authfunvo = bo.autenticar(funvo);
		
		//venda.switchSceneVenda(stage);

	}
	public FuncionarioVO returnFuncionario(FuncionarioVO vo) {
		return(vo); 
	}
}
