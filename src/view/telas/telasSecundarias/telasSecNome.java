package src.view.telas.telasSecundarias;

public enum telasSecNome {
    ClientesADD("ClientesADD"),
    ClienteVendaADD("ClienteVendaADD"),
    
    Excluir("Excluir"),

    FuncionariosADD("FuncionariosADD"),

    LocalADD("LocalADD"),

    ProdutoADD("ProdutoADD"),

    Recibo("Recibo"),
    VendaADD("VendaADD"),
    VendaFinalizar("VendaFinalizar");

    private final String telasSecNome;

    telasSecNome(final String telasSecNome) {
        this.telasSecNome = telasSecNome;
    }

    @Override
    public String toString() {
        return telasSecNome;
    }
}
