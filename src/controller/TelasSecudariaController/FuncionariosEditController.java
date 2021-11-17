package src.controller.TelasSecudariaController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.FuncionarioBO;
import src.model.vo.FuncionarioVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;

public class FuncionariosEditController extends FecharTelaSec implements Initializable{
    @FXML private TextField funcionarioNome;
    @FXML private TextField funcionarioUsuario;
    @FXML private TextField funcionarioSenha;
    @FXML private TextField funcionarioEndereco;
    @FXML private TextField funcionarioEmail;
    @FXML private TextField funcionarioCargo;
    @FXML private TextField funcionarioTelefone;

    FuncionarioBO funcionarioBO = new FuncionarioBO();
    FuncionarioVO funcionarioVO = new FuncionarioVO();
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        funcionarioVO = TelasPrincipal.getFuncionario();

        funcionarioNome.setText(funcionarioVO.getNome());   
        funcionarioUsuario.setText(funcionarioVO.getNickName()); 
        funcionarioSenha.setText(funcionarioVO.getSenha()); 
        funcionarioEndereco.setText(funcionarioVO.getEndereco()); 
        funcionarioEmail.setText(funcionarioVO.getEmail()); 
        funcionarioCargo.setText(String.valueOf(funcionarioVO.getCargo())); 
        funcionarioTelefone.setText(funcionarioVO.getTelefone()); 
    }

    public void Edit(ActionEvent event) throws Exception{
        FuncionarioVO funEditVO = new FuncionarioVO();

        funEditVO.setId(this.funcionarioVO.getId());
        funEditVO.setNickName(funcionarioUsuario.getText());
        funEditVO.setSenha(funcionarioSenha.getText());
        funEditVO.setNome(funcionarioNome.getText());
        funEditVO.setEndereco(funcionarioEndereco.getText());
        funEditVO.setEmail(funcionarioEmail.getText());
        funEditVO.setTelefone(funcionarioTelefone.getText());
        funEditVO.setCargo(Integer.parseInt(funcionarioCargo.getText()));
        funEditVO.setUsuid(funcionarioVO.getUsuid());
        funcionarioBO.updateById(funEditVO);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.funcionarios);
    }

   
}
