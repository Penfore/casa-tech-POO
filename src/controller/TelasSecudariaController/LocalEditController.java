package src.controller.TelasSecudariaController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.LocalBO;
import src.model.vo.LocalVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;

public class LocalEditController extends FecharTelaSec implements Initializable{
    @FXML private TextField LocalCasa;
    @FXML private TextField LocalComp;    

    LocalBO localBO = new LocalBO();
    LocalVO localVO = new LocalVO();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        localVO = TelasPrincipal.getLocal();

        LocalCasa.setText(localVO.getCasa());
        LocalComp.setText(localVO.getCompartimento());
    }

    public void Edit(ActionEvent event) throws Exception{
        LocalVO locEditVO = new LocalVO();

        locEditVO.setCasa(LocalCasa.getText());
        locEditVO.setCompartimento(LocalComp.getText());        
		locEditVO.setId(TelasPrincipal.getLocal().getId());
        localBO.updateById(locEditVO);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.local);
    }
    
}
