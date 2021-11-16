package src.controller.TelasSecudariaController;

import javafx.event.ActionEvent;

//import java.sql.SQLException;

//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.LocalBO;
import src.model.vo.LocalVO;
public class LocalADDController extends FecharTelaSec {
    @FXML private TextField LocalNome;
    @FXML private TextField LocalComp;

    public void novoProduto(ActionEvent e){
        LocalVO localVO = new LocalVO();

        localVO.setCasa(LocalNome.getText());
        localVO.setCompartimento(LocalComp.getText());

        LocalBO localBO = new LocalBO();

        localBO.store(localVO);
        FecharTela();
    }
    
}
