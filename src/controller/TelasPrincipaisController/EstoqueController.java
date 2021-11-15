package src.controller.TelasPrincipaisController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import src.controller.TrocarTelas;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class EstoqueController extends TrocarTelas{
    @FXML private ComboBox<String> estoqueComboBox;

    public void initialize() {
        ObservableList<String> pesquisa = FXCollections.observableArrayList();
        pesquisa.addAll("NOME", "CÓDIGO", "RESPONSÁVEL", "LOCAL");

        estoqueComboBox.setItems(pesquisa);
    }

    public void abrirProdutoADD() {
        TelasSecudaria.load(telasSecNome.ProdutoADD);
    }
}