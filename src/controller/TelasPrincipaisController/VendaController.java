package src.controller.TelasPrincipaisController;

import src.controller.TrocarTelas;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class VendaController extends TrocarTelas { //CONTROLLER DE VENDA E NOVAVENDA
    //Ao tentar trocar a tela inserir botão que leve para "cancelarVenda"
    public void abrirClienteVendaADD() {
        TelasSecudaria.load(telasSecNome.ClienteVendaADD);
    }

    public void abrirVendaADD() {
        TelasSecudaria.load(telasSecNome.VendaADD);
    }
    public void abrirVendaExcluir() {
        TelasSecudaria.load(telasSecNome.VendaExcluir);
    }
    public void abrirVendaFinalizar() {
        TelasSecudaria.load(telasSecNome.VendaFinalizar);
    }
}
