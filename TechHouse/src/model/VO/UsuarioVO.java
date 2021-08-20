package model.VO;

public class UsuarioVO {
	private String email;
	private String senha;
	private String nome; 

	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		if(nome!=null && !nome.equals("")){
			this.nome=nome;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha!=null && !senha.equals("")) {
			this.senha = senha;
		}else{
			//RETURN ERROR?
		}
	}
}
