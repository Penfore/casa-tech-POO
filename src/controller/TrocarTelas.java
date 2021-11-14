package src.controller;

import src.view.TelasPrincipal;
import src.view.telas.telasNome;

public class TrocarTelas {
    public void irTelaVenda() {
        TelasPrincipal.load(telasNome.venda);
    }
    public void irTelaEstoque() {
        TelasPrincipal.load(telasNome.estoque);
    }
    public void irTelaClientes() {
        TelasPrincipal.load(telasNome.clientes);
    }
    public void irTelaLocal() {
        TelasPrincipal.load(telasNome.local);
    }
    public void irTelaFuncionarios() {
        TelasPrincipal.load(telasNome.funcionarios);
    }
    public void irTelaRelatorios() {
        TelasPrincipal.load(telasNome.relatorios);
    }

    public void deslogar() {
        TelasPrincipal.load(telasNome.relatorios);
    }
}
