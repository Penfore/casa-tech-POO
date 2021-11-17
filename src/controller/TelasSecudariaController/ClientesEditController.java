package src.controller.TelasSecudariaController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.ClienteBO;
import src.model.vo.ClienteVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;

public class ClientesEditController extends FecharTelaSec implements Initializable{
    @FXML private TextField clienteNome;
    @FXML private TextField clienteEmail;
    @FXML private TextField clienteEndereco;
    @FXML private TextField clienteCpf;
    @FXML private TextField clienteTelefone;

    ClienteBO bo = new ClienteBO();
    ClienteVO vo = new ClienteVO();
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        vo = TelasPrincipal.getCliente();

        clienteNome.setText(vo.getNome());
        clienteEmail.setText(vo.getEmail());
        clienteEndereco.setText(vo.getEndereco());
        clienteCpf.setText(vo.getCpf());
        clienteTelefone.setText(vo.getTelefone());        
    }

    public void Edit(ActionEvent event) throws Exception{
        ClienteVO voEdit = new ClienteVO();

        voEdit.setId(this.vo.getId());
        voEdit.setNome(clienteNome.getText());
        voEdit.setEmail(clienteEmail.getText());
        voEdit.setEndereco(clienteEndereco.getText());
        voEdit.setCpf(clienteCpf.getText());
        voEdit.setTelefone(clienteTelefone.getText());

        bo.updateById(voEdit);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.clientes);
    }
}
