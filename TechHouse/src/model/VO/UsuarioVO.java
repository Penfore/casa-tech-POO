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
		}else {
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa nome não pode estar vazia!");
		}
	}
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email!=null && !email.equals("")) {
			this.email = email;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa email não pode estar vazia!");
		}
	

	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha!=null && !senha.equals("")) {
			this.senha = senha;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa senha não pode estar vazia ou está incorreta!"); // No BO será escrita a lógica para a validação de senha;
		}
	}
}
