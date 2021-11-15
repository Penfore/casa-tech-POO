package src.controller.TelasSecudariaController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import src.controller.FecharTelaSec;

public class VendaFinalizarController extends FecharTelaSec{
    @FXML private ComboBox<String> formaPagamentoComboBox;

    public void initialize() {
        ObservableList<String> formaPagamento = FXCollections.observableArrayList();
        formaPagamento.addAll("DINHEIRO","CARTÃO DE DEBITO","CARTÃO DE CRÉDITO","PIX");

        formaPagamentoComboBox.setItems(formaPagamento);
    }
}
