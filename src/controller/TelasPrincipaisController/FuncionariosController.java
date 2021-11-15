package src.controller.TelasPrincipaisController;

import src.controller.TrocarTelas;
import src.view.TelasSecudaria;
import src.view.telas.telasSecundarias.telasSecNome;

public class FuncionariosController extends TrocarTelas {
    public void abrirFuncionariosADD() {
        TelasSecudaria.load(telasSecNome.FuncionariosADD);
    }
}