package src.model.vo; 

public class ClienteVO {
	private String nome;
	private String enderecoRua; 
	private String bairro;
	private String email;
	private String telefone;
	private String cep;
	private String cpf;
	
	
	// NOME
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
	//

	
	// NOME DA RUA
	public String getEnderecoRua() {
		return enderecoRua;
	}
	public void setEnderecoRua(String enderecoRua) { 
		if(enderecoRua!=null && !enderecoRua.equals("")) { // Deveríamos permitir que fosse opcional o cadastro desse dado?
			this.enderecoRua = enderecoRua;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa rua não pode estar vazia!");
		}
		
	}
	//
	

	// E-MAIL
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email!=null && !email.equals("")) { // Deveríamos permitir que fosse opcional o cadastro desse dado?
			this.email = email;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa email não pode estar vazia!");
		}
		
	}
	//


	// TELEFONE
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone!=null && !telefone.equals("")) { // Deveríamos permitir que fosse opcional o cadastro desse dado?
			this.telefone = telefone;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa número de telefone não pode estar vazia!");
		}
		
	}
	//


	// BAIRRO
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		if(bairro!=null && !bairro.equals("")) { // Deveríamos permitir que fosse opcional o cadastro desse dado?
			this.bairro = bairro;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa do baixo não pode estar vazia!");
		}
	
	}
	//


	// CEP
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		if(cep!=null && !cep.equals("")) { // Deveríamos permitir que fosse opcional o cadastro desse dado?
			this.cep = cep;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa do CEP não pode estar vazia!");
		}
		
	}	
	//


	// CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) { 
		if(cpf!=null && !cpf.equals("")) { // Deveríamos permitir que fosse opcional o cadastro desse dado?
			if (cpf.length() == 11)
			{
				if (cpf.substring(0, 10).matches("[0-9]*"))
				{
					if ((!cpf.equals("00000000000")) && (!cpf.equals("11111111111")) // Sinalizando expressão para melhorar visualização
							&& (!cpf.equals("22222222222")) && (!cpf.equals("33333333333")) //
							&& (!cpf.equals("44444444444")) && (!cpf.equals("55555555555")) //
							&& (!cpf.equals("66666666666")) && (!cpf.equals("77777777777")) //
							&& (!cpf.equals("88888888888"))&& (!cpf.equals("99999999999"))) //
					{
						this.cpf = cpf;
					} else
					{
						System.out.println("Os números do CPF não podem ser todos igual!");
					}		
							
				} else
				{
					System.out.println("O CPF não pode conter letras, apenas números!");
				}
			} else 
			{
				System.out.println("O CPF precisa ter 11 caracteres!");
			}
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa do CPF não pode estar vazia!");
		}
	}	
}
//