package src.controller.TelasSecudariaController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.LocalBO;
import src.model.vo.LocalVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;
public class LocalADDController extends FecharTelaSec {
    @FXML private TextField LocalNome;
    @FXML private TextField LocalComp;    

    public void novoLocal(ActionEvent event){
		LocalVO localVO = new LocalVO();
        LocalBO localBO = new LocalBO();

        localVO.setCasa(LocalNome.getText());
        localVO.setCompartimento(LocalComp.getText());        
		
		localBO.store(localVO);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.local);
	}
    
}
