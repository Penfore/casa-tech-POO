package model.VO;
public class EquipamentoVO {
	public String nome;
	public double peso;
	public int cod;
	public int quantidade;
	public LocalVO local;
	public FuncionarioVO responsavel;
	public String descricao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome!=null && !nome.equals(" ")) {
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
			this.local = local;
		}else{
			//RETURN ERROR?
		}
	}
	
	public FuncionarioVO getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(FuncionarioVO responsavel) {
		if(responsavel!=null) {
			this.responsavel = responsavel;
		}else{
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
}
