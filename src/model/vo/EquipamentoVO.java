package src.model.vo;

public class EquipamentoVO {
	private int id;
	private String nome;
	private double peso;
	private double preco;
	private String codigo;
	private int quantidade = 0;
	private LocalVO local;
	private FuncionarioVO responsavel;
	private String descricao;
	private int qtd_Carrinho;
	
    public String toString() {
        return id + " - " + " " + nome.toUpperCase();
    }
    
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null && !nome.equals("")) {
			this.nome = nome;
		} else {
			System.out.println("O caixa nome n?o pode estar vazia!");
		}
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		if (peso > 0) {
			this.peso = peso;
		} else {
			System.out.println("O peso atribu?do ? inv?lido!");
		}
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		if (codigo != null && !codigo.equals("")) {
			this.codigo = codigo;
		} else {
			System.out.println("A caixa do c?digo n?o pode estar vazia!");
		}
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public LocalVO getLocal() {
		return local;
	}

	public void setLocal(LocalVO local) {
		this.local = local;
	}

	public FuncionarioVO getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(FuncionarioVO responsavel) {
		this.responsavel = responsavel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao != null && !descricao.equals("")) {
			if (descricao.length() <= 500) {
				this.descricao = descricao;
			} else {
				System.out.println("A descri??o precisa ter menos de 500 caracteres!");
			}
		} else {
			System.out.println("A descri??o n?o pode estar vazia!");
		}

	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco > 0) {
			this.preco = preco;
		} else {
			System.out.println("O pre?o atribu?do est? inv?lido!");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
		} else {

		}

	}

	public int getQtd_Carrinho() {
		return qtd_Carrinho;
	}

	public void setQtd_Carrinho(int qtd_Carrinho) {
		this.qtd_Carrinho = qtd_Carrinho;
	}

}