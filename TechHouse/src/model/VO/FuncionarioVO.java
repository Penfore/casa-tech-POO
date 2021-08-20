package model.VO;

public class FuncionarioVO {
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private int cargo;

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome!=null && !nome.equals("")) {
			this.nome = nome;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa nome não pode estar vazia!");
		}
	}
	

	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco!=null && !endereco.equals("")) {
			this.endereco = endereco;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa endereço não pode estar vazia!");
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
	

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone!=null && !telefone.equals("")) {
			this.telefone = telefone;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa de número de telefone não pode estar vazia!");
		}	
	}


	public int getCargo() {
		return cargo;
	}
	public void setCargo(int cargo) {
		if(cargo >= 0) {
			this.cargo = cargo;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("Cargo inválido!");
		}	
	}
}
