package model.vo; // Será corrigido os caminhos dos diretórios para encaixar nas próximas branches

public class UsuarioVO {
	// private String email; // Ver comentário declaração dos métodos para e-mail;
	private String senha;
	private String nomeUsuario; 


	public String getNomeUsuario(){
		return nome;
	}
	public void setNomeUsuario(String nomeUsuario){
		if(nome!=null && !nomeUsuario.equals("")){
			this.nomeUsuario = nomeUsuario;
		}else {
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa nome não pode estar vazia!");
		}
	}
	

	// Não sei se precisaremos do e-mail para cadastro do usuários, pois imagino que isso trará a necessidade de mais validação e uso de Regex hihi
	/* public String getEmail() { //
		return email;
	}
	public void setEmail(String email) {
		if(email!=null && !email.equals("")) {
			this.email = email;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa email não pode estar vazia!");
		}
	} */


	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha!=null && !senha.equals("")) {
			if (senha.lenght() >= 8)
			{
				this.senha = senha;
			} else 
			{
				// No futuro, essa mensagem será trocada por um throw exception;
				System.out.println("A senha precisa ter 8 ou mais caracteres!");
			}
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa senha não pode estar vazia ou está incorreta!"); // No BO será escrita a lógica para a validação de senha;
		}
	}
}
