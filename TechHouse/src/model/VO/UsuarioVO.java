package model.VO;

public class UsuarioVO {
	private String email;
	private String senha;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email!=null && !email.equals(" ")) {
			this.email = email;
		}else{
			//RETURN ERROR?
		}
	
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha!=null && !senha.equals(" ")) {
			this.senha = senha;
		}else{
			//RETURN ERROR?
		}
	}
}
