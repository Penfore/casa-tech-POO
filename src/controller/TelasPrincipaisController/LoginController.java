package src.controller.TelasPrincipaisController;

import java.sql.SQLException;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.model.bo.FuncionarioBO;
import src.model.vo.FuncionarioVO;
import src.view.TelasPrincipal;
import src.view.telas.telasNome;
import src.controller.TrocarTelas;

public class LoginController extends TrocarTelas {
	@FXML private TextField login;
	@FXML private PasswordField senha;
	
	FuncionarioVO authfunvo = new FuncionarioVO();
	
	public void auth(ActionEvent event) throws Exception {
		//Venda venda = new Venda();
		FuncionarioBO bo = new FuncionarioBO();
		FuncionarioVO funvo = new FuncionarioVO();
		
		//stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		funvo.setNickName(login.getText());
		funvo.setSenha(senha.getText());
		
	
		this.authfunvo = bo.autenticar(funvo);
		
		if(authfunvo == null) {
            login.setStyle(login.getStyle() + "-fx-border-color: #F40779;");
            senha.setStyle(senha.getStyle() + "-fx-border-color: #F40779;");
        } else {
            TelasPrincipal.load(telasNome.venda);
        }

		//venda.switchSceneVenda(stage);

	}
	public FuncionarioVO returnFuncionario(FuncionarioVO vo) {
		return(vo); 
	}
}
