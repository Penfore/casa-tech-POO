package src.view.telas.telasSecundarias;

public enum telasSecNome {
    ClientesADD("ClientesADD"),
    ClienteVendaADD("ClienteVendaADD"),
    
    FuncionariosADD("FuncionariosADD"),

    LocalADD("LocalADD"),

    ProdutoADD("ProdutoADD"),
    ProdutoExcluir("ProdutoExcluir"),
    ProdutoEdit("ProdutoEdit"),
    VendaADD("VendaADD"),
    VendaExcluir("VendaExcluir"),
    VendaFinalizar("VendaFinalizar"),
    Recibo("Recibo");
	

    private final String telasSecNome;

    telasSecNome(final String telasSecNome) {
        this.telasSecNome = telasSecNome;
    }

    @Override
    public String toString() {
        return telasSecNome;
    }
}
