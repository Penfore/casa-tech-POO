package model.VO;
public class FuncionarioVO {
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private String cargo;
	
	
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
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco!=null && !endereco.equals("")) {
			this.endereco = endereco;
		}else{
			//RETURN ERROR?
		}
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if(email!=null && !email.equals("")) {
			this.email = email;
		}else{
			//RETURN ERROR?
		}
		
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone!=null && !telefone.equals("")) {
			this.telefone = telefone;
		}else{
			//RETURN ERROR?
		}
		
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		if(cargo!=null && !cargo.equals("")) {
			this.cargo = cargo;
		}else{
			//RETURN ERROR?
		}
		
	}
	

}
