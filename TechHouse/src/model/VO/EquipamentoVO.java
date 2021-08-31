package model.vo; // Será corrigido os caminhos dos diretórios para encaixar nas próximas branches

public class EquipamentoVO {
	private String nome;
	private double peso;
	private double preco;
	private String codigo;
	private int quantidade;
	private LocalVO local;
	private FuncionarioVO responsavel;
	private String descricao;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome!=null && !nome.equals("")) {
			this.nome = nome;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("O caixa nome não pode estar vazia!");
		}
	}
	

	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		if(peso>0) {
			this.peso = peso;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("O peso atribuído é inválido!");
		}
	}
	

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		if(codigo != null && !codigo.equals("")) {
			this.cod = cod;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa do código não pode estar vazia!");
		}
	}
	

	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		if(quantidade>=0) {
			this.quantidade = quantidade;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A quantidade atribuída é inválida!");
		}
		
	}
	

	public LocalVO getLocal() {
		return local;
	}
	public void setLocal(LocalVO local) {
		if(local!=null) {
			if(!local.getCasa().equals("") && !local.getCompartimento().equals("")){
				this.local = local;	
			}			
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa local não pode estar vazia!");
		}
	}
	

	public FuncionarioVO getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(FuncionarioVO responsavel) {
		if(responsavel!=null) {
			if(!responsavel.getNome().equals("")){
				if(!responsavel.getEmail().equals("") || !responsavel.getTelefone().equals("")){
					this.responsavel = responsavel;
				}
			}			
		}
		else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("Os atributos do responsável estão inválidos!");
		}
		
	}
	

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		if(descricao!=null && !descricao.equals("")) {
			this.descricao = descricao;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A descrição não pode estar vazia!");
		}
		
	}


	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		if(preco>0) {
			this.preco = preco;
		}else {
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("O preço atribuído está inválido!");
		}
	}	
}
