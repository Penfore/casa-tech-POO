package src.controller.TelasSecudariaController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.ClienteBO;
import src.model.vo.ClienteVO;

public class ClientesADDController extends FecharTelaSec {
    @FXML private TextField clienteNome;
    @FXML private TextField clienteEmail;
    @FXML private TextField clienteEndereco;
    @FXML private TextField clienteCpf;
    @FXML private TextField clienteTelefone;

    public void novoCliente(ActionEvent e){

        ClienteVO clienteVO = new ClienteVO();

        //Cliente ID???????????
        clienteVO.setNome(clienteNome.getText());
        clienteVO.setEmail(clienteEmail.getText());
        clienteVO.setEndereco(clienteEndereco.getText());
        clienteVO.setCpf(clienteCpf.getText());
        clienteVO.setTelefone(clienteTelefone.getText());

        ClienteBO clienteBO = new ClienteBO();

        clienteBO.store(clienteVO);
        FecharTela();
    }
}
