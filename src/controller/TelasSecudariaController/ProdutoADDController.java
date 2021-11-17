package src.controller.TelasSecudariaController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import src.controller.FecharTelaSec;
import src.model.bo.EquipamentoBO;
import src.model.bo.FuncionarioBO;
import src.model.bo.LocalBO;
import src.model.vo.EquipamentoVO;
import src.model.vo.FuncionarioVO;
import src.model.vo.LocalVO;
import src.view.TelasPrincipal;
import src.view.TelasSecudaria;
import src.view.telas.telasNome;


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
    EquipamentoBO EquiBo = new EquipamentoBO();

    public void initialize() {          
        ObservableList<LocalVO> indexLocal = FXCollections.observableArrayList(localBo.index());
        ObservableList<FuncionarioVO> indexFuncionario = FXCollections.observableArrayList(FunBo.index());   
		
        ProdutoResponsavelCB.setItems(indexFuncionario);
        ProdutoLocalCB.setItems(indexLocal);
    }
   
	public void Add(ActionEvent event) throws Exception {
		EquipamentoVO voEdit = new EquipamentoVO();
        
		voEdit.setNome(ProdutoNome.getText());
		voEdit.setCodigo(ProdutoCod.getText());
		voEdit.setDescricao(ProdutoDescricao.getText());
		voEdit.setPreco(Double.parseDouble(ProdutoPreco.getText()));
		voEdit.setPeso(Double.parseDouble(ProdutoPeso.getText()));
		voEdit.setQuantidade(Integer.parseInt(ProdutoQuant.getText()));
		voEdit.setLocal(ProdutoLocalCB.getValue());
		voEdit.setResponsavel(ProdutoResponsavelCB.getValue());

		
		EquiBo.store(voEdit);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.estoque);
	}

}
