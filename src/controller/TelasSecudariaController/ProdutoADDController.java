package src.controller.TelasSecudariaController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.FuncionarioBO;
import src.model.bo.LocalBO;
import src.model.vo.FuncionarioVO;
import src.model.vo.LocalVO;


public class ProdutoADDController extends FecharTelaSec {
    
	@FXML private TextField ProdutoNome;
    @FXML private TextField ProdutoPreco;
    @FXML private TextField ProdutoPeso;
    @FXML private TextField ProdutoCod;
    @FXML private TextField ProdutoQuant;
    @FXML private TextArea ProdutoDescricao;
    
    @FXML private ComboBox<LocalVO> ProdutoLocalCB;
    @FXML private ComboBox<FuncionarioVO> ProdutoResponsavelCB;

    LocalBO localBo = new LocalBO();
    FuncionarioBO FunBo = new FuncionarioBO();

    public void initialize() {          
        ObservableList<LocalVO> indexLocal = FXCollections.observableArrayList(localBo.index());
        ObservableList<FuncionarioVO> indexFuncionario = FXCollections.observableArrayList(FunBo.index());   
		
        ProdutoResponsavelCB.setItems(indexFuncionario);
        ProdutoLocalCB.setItems(indexLocal);
    }

}
