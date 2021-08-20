package model.VO;

public class EquipamentoVO {
	private String nome;
	private double peso;
	private double preco;
	private int cod;
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
			//RETURN ERROR?
		}
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		if(peso>0) {
			this.peso = peso;
		}else{
			//RETURN ERROR?
		}
	}
	
	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		if(cod>=0) {
			this.cod = cod;
		}else{
			//RETURN ERROR?
		}
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		if(quantidade>=0) {
			this.quantidade = quantidade;
		}else{
			//RETURN ERROR?
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
			//RETURN ERROR?
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
			//RETURN ERROR?
		}
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		if(descricao!=null && !descricao.equals(" ")) {
			this.descricao = descricao;
		}else{
			//RETURN ERROR?
		}
		
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if(preco>0) {
			this.preco = preco;
		}else {
			//RETURN ERRO
		}
	}
	
	
}
