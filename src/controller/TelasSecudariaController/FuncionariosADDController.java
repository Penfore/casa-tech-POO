package src.controller.TelasSecudariaController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.FuncionarioBO;
import src.model.vo.FuncionarioVO;
import src.model.vo.UsuarioVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;

public class FuncionariosADDController extends FecharTelaSec {
    @FXML private TextField funcionarioNome;
    @FXML private TextField funcionarioUsuario;
    @FXML private TextField funcionarioSenha;
    @FXML private TextField funcionarioEndereco;
    @FXML private TextField funcionarioEmail;
    @FXML private TextField funcionarioCargo;
    @FXML private TextField funcionarioTelefone;

    public void novoFuncionario(ActionEvent e) {
        FuncionarioBO funcionarioBO = new FuncionarioBO();
        FuncionarioVO funcionarioVO = new FuncionarioVO();
        UsuarioVO novoUsu = new UsuarioVO(){         

        };
        novoUsu.setNickName(funcionarioUsuario.getText());
        novoUsu.setSenha(funcionarioSenha.getText());

        funcionarioVO.setUsuario(novoUsu);
        funcionarioVO.setNome(funcionarioNome.getText());
        funcionarioVO.setEndereco(funcionarioEndereco.getText());
        funcionarioVO.setEmail(funcionarioEmail.getText());
        funcionarioVO.setTelefone(funcionarioTelefone.getText());
        funcionarioVO.setCargo(Integer.parseInt(funcionarioCargo.getText()));

        funcionarioBO.store(funcionarioVO);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.funcionarios);
    }
}
