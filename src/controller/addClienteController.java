package src.controller;

import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import src.model.bo.ClienteBO;
import src.model.vo.ClienteVO;



public class addClienteController {
	private Stage stage;
	@FXML private TextField nome;
	@FXML private TextField email;
	@FXML private TextField endereco;
	@FXML private TextField cpf;
	@FXML private TextField telefone;
	
	public void addCliente(ActionEvent event) throws SQLException {
		ClienteVO vo = new ClienteVO();
		ClienteBO bo = new ClienteBO();
		
		
		vo.setCpf(cpf.getText());
		vo.setEmail(email.getText());
		vo.setEndereco(endereco.getText());
		vo.setNome(nome.getText());
		vo.setTelefone(telefone.getText());
		
		bo.store(vo);
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.close();
	}

}
