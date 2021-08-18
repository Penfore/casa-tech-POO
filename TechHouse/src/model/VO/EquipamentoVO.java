package model.VO;
public class EquipamentoVO {
	public String nome;
	public Double peso;
	public Integer cod;
	public int quantidade;
	public LocalVO local;
	public FuncionarioVO responsavel;
	public String descricao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome!=null && nome.equals(" ")) {
			this.nome = nome;
		}else{
			//RETURN ERROR?
		}
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(Double peso) {
		if(peso!=null && peso.equals(" ")) {
			this.peso = peso;
		}else{
			//RETURN ERROR?
		}
	}
	
	public int getCod() {
		return cod;
	}
	
	public void setCod(Integer cod) {
		if(cod!=null ) {
			this.cod = cod;
		}else{
			//RETURN ERROR?
		}
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		if(nome!=null && nome.equals(" ")) {
			this.quantidade = quantidade;
		}else{
			//RETURN ERROR?
		}
		
	}
	
	public LocalVO getLocal() {
		return local;
	}
	
	public void setLocal(LocalVO local) {
		if(nome!=null && nome.equals(" ")) {
			this.local = local;
		}else{
			//RETURN ERROR?
		}
		
	}
	
	public FuncionarioVO getResponsavel() {
		return responsavel;
	}
	
	public void setResponsavel(FuncionarioVO responsavel) {
		if(nome!=null && nome.equals(" ")) {
			this.responsavel = responsavel;
		}else{
			//RETURN ERROR?
		}
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		if(nome!=null && nome.equals(" ")) {
			this.descricao = descricao;
		}else{
			//RETURN ERROR?
		}
		
	}
}
