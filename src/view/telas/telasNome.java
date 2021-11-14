package src.view.telas;

public enum telasNome {
    login("login"),
    venda("venda"),
    estoque("estoque"),
    clientes("clientes"),
    local("local"),
    funcionarios("funcionarios"),
    relatorios("relatorios");

    private final String telasNome;

    telasNome(final String telasNome) {
        this.telasNome = telasNome;
    }

    @Override
    public String toString() {
        return telasNome;
    }

}