package src.view.telas;

public enum telasNome {
    login("login"),
    
    venda("venda"),
    NovaVenda("NovaVenda"),

    estoque("estoque"),

    clientes("clientes"),

    local("local"),

    funcionarios("funcionarios"),

    relatorios("relatorios"),

    relatoriosFuncionarios("relatoriosFuncionarios"),
    relatoriosClientes("relatoriosClientes"),
    relatoriosEstoque("relatoriosEstoque"),
    relatoriosVendas("relatoriosVendas")
    ;

    private final String telasNome;

    telasNome(final String telasNome) {
        this.telasNome = telasNome;
    }

    @Override
    public String toString() {
        return telasNome;
    }

}