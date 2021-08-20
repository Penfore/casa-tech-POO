package model.VO;

public class ClienteVO {
	private String nome;
	private String endereco;
	private String bairro;
	private String email;
	private String telefone;
	private String cep;
	private String cpf;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome!=null && !nome.equals("")) {
			this.nome = nome;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("O nome não pode ser vazio!");

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
			System.out.println("A caixa número de telefone não pode estar vazia!");
		}
		
	}


	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		if(bairro!=null && !bairro.equals("")) {
			this.bairro = bairro;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa do baixo não pode estar vazia!");
		}
	
	}
	

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		if(cep!=null && !cep.equals("")) {
			this.cep = cep;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa do CEP não pode estar vazia!");
		}
		
	}	
	

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf!=null && !cpf.equals("")) {
			this.cpf = cpf;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa do CPF não pode estar vazia!");
		}
	}	
}
