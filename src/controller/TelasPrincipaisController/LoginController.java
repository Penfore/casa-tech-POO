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
	@FXML
	private PasswordField senha;
	@FXML
	private TextField usu;
	FuncionarioVO authfunvo = new FuncionarioVO();

	public void auth(ActionEvent event) throws Exception {

		FuncionarioBO bo = new FuncionarioBO();
		FuncionarioVO funvo = new FuncionarioVO();

		funvo.setNickName(usu.getText());
		funvo.setSenha(senha.getText());

		this.authfunvo = bo.autenticar(funvo);

		if (authfunvo == null) {
			usu.setStyle(usu.getStyle() + "-fx-border-color: #F40779;");
			senha.setStyle(senha.getStyle() + "-fx-border-color: #F40779;");
		} else {
			TelasPrincipal.load(telasNome.venda);
		}

	}

	public FuncionarioVO returnFuncionario(FuncionarioVO vo) {
		return (vo);
	}
}
