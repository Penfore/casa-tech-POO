package src.controller.TelasPrincipaisController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import src.controller.TrocarTelas;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class ClientesController extends TrocarTelas {
    @FXML private ComboBox<String> clientesComboBox;

    public void initialize() {
        ObservableList<String> pesquisa = FXCollections.observableArrayList();
        pesquisa.addAll("ID","CPF", "NOME", "ENDEREÇO");

        clientesComboBox.setItems(pesquisa);
    }

    public void abrirClientesADD() {
        TelasSecudaria.load(telasSecNome.ClientesADD);
    }
}