package src.controller.TelasSecudariaController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.FuncionarioBO;
import src.model.vo.FuncionarioVO;

public class FuncionariosADDController extends FecharTelaSec {
    @FXML private TextField funcionarioNome;
    @FXML private TextField funcionarioUsuario;
    @FXML private TextField funcionarioSenha;
    @FXML private TextField funcionarioEndereco;
    @FXML private TextField funcionarioEmail;
    @FXML private TextField funcionarioCargo;
    @FXML private TextField funcionarioTelefone;

    public void novoFuncionario(ActionEvent e) {
        FuncionarioVO funcionarioVO = new FuncionarioVO();

        //Cliente ID???????????
        funcionarioVO.setNome(funcionarioNome.getText());
        //USUARIOVO
        funcionarioVO.setEndereco(funcionarioEndereco.getText());
        funcionarioVO.setEmail(funcionarioEmail.getText());
        //funcionarioVO.setCargo(funcionarioCargo.getText());
        funcionarioVO.setTelefone(funcionarioTelefone.getText());

        FuncionarioBO funcionarioBO = new FuncionarioBO();

        funcionarioBO.store(funcionarioVO);
        FecharTela();
    }
}
