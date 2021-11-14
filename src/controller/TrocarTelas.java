package src.controller;

import src.view.TelasPrincipal;
import src.view.telas.telasNome;
public class TrocarTelas {
    //vendasBut
    public void irTelaVenda() {
        TelasPrincipal.load(telasNome.venda);
    }
    //estoqueBut
    public void irTelaEstoque() {
        TelasPrincipal.load(telasNome.estoque);
    }
    //clientesBut
    public void irTelaClientes() {
        TelasPrincipal.load(telasNome.clientes);
    }
    //localBut
    public void irTelaLocal() {
        TelasPrincipal.load(telasNome.local);
    }
    //funcionariosBut
    public void irTelaFuncionarios() {
        TelasPrincipal.load(telasNome.funcionarios);
    }
    //relatoriosBut
    public void irTelaRelatorios() {
        TelasPrincipal.load(telasNome.relatorios);
    }

    public void deslogar() {
        TelasPrincipal.load(telasNome.relatorios);
    }
}
