package src.controller.TelasSecudariaController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.ClienteBO;
import src.model.vo.ClienteVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;
public class ClientesADDController extends FecharTelaSec {
    @FXML private TextField clienteNome;
    @FXML private TextField clienteEmail;
    @FXML private TextField clienteEndereco;
    @FXML private TextField clienteCpf;
    @FXML private TextField clienteTelefone;

    public void novoCliente(ActionEvent e){
        ClienteBO clienteBO = new ClienteBO();
        ClienteVO clienteVO = new ClienteVO();

        clienteVO.setNome(clienteNome.getText());
        clienteVO.setEmail(clienteEmail.getText());
        clienteVO.setEndereco(clienteEndereco.getText());
        clienteVO.setCpf(clienteCpf.getText());
        clienteVO.setTelefone(clienteTelefone.getText());

        clienteBO.store(clienteVO);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.clientes);
    }
}
