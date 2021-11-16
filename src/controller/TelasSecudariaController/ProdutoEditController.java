package src.controller.TelasSecudariaController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
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

public class ProdutoEditController extends FecharTelaSec implements Initializable{
	@FXML private TextField nome;
	@FXML private TextField peso;
	@FXML private TextField valor;
	@FXML private TextField codigo;
	@FXML private TextField quantidade;
	@FXML private TextArea descricao;
    @FXML private ChoiceBox<LocalVO> local;
    @FXML private ChoiceBox<FuncionarioVO> responsavel;
    
	EquipamentoBO bo = new EquipamentoBO();
	EquipamentoVO vo = new EquipamentoVO();
	
	FuncionarioBO Fbo = new FuncionarioBO();
	ObservableList<FuncionarioVO> indexRES = FXCollections.observableArrayList(Fbo.index());
	
	LocalBO Lbo = new LocalBO();
	ObservableList<LocalVO> indexLOCAL = FXCollections.observableArrayList(Lbo.index());
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		vo = TelasPrincipal.getEquipamento();
		
		nome.setText(vo.getNome());
		peso.setText(String.valueOf(vo.getPeso()));
		valor.setText(String.valueOf(vo.getPreco()));
		descricao.setText(vo.getDescricao());
		codigo.setText(vo.getCodigo());
		quantidade.setText(String.valueOf(vo.getQuantidade()));
		
		local.setValue(vo.getLocal());
		responsavel.setValue(vo.getResponsavel());
		
		local.setItems(indexLOCAL);
		responsavel.setItems(indexRES);
	}
	
	public void Edit(ActionEvent event) throws Exception {
		EquipamentoVO voEdit = new EquipamentoVO();
		
		voEdit.setNome(nome.getText());
		voEdit.setCodigo(codigo.getText());
		voEdit.setDescricao(descricao.getText());
		voEdit.setPreco(Double.parseDouble(valor.getText()));
		voEdit.setPeso(Double.parseDouble(peso.getText()));
		voEdit.setQuantidade(Integer.parseInt(quantidade.getText()));
		voEdit.setLocal(local.getValue());
		voEdit.setResponsavel(responsavel.getValue());
		voEdit.setId(this.vo.getId());
		
		bo.updateById(voEdit);
		TelasSecudaria.fechar();
		TelasPrincipal.load(telasNome.estoque);
	}
    
}
