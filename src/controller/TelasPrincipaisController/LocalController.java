package src.controller.TelasPrincipaisController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import src.controller.TrocarTelas;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class LocalController extends TrocarTelas {
    @FXML private ComboBox<String> localComboBox;

    public void initialize() {
        ObservableList<String> pesquisa = FXCollections.observableArrayList();
        pesquisa.addAll("CASA","COMPARTIMENTO");

        localComboBox.setItems(pesquisa);
    }

    public void abrirLocalADD() {
        TelasSecudaria.load(telasSecNome.LocalADD);
    }
}
