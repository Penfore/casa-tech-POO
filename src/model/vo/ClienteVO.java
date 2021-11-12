package src.model.vo; 

public class ClienteVO {
	private int id;
	private String nome;
	private String endereco; 
	private String email;
	private String telefone;
	private String cpf;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		if(id>=0) {
			this.id = id;
		}else {
			System.out.println("ID invalido!");
		}
	}
	
	
	// NOME
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome!=null && !nome.equals("")) {
			this.nome = nome;
		}else{
			System.out.println("O nome não pode ser vazio!");

		}
	}


	// E-MAIL
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email!=null && !email.equals("")){ 
			this.email = email;
		}else{
			System.out.println("A caixa email não pode estar vazia!");
		}
		
	}
	// TELEFONE
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone!=null && !telefone.equals("")) { 
			this.telefone = telefone;
		}else{
			
			System.out.println("A caixa número de telefone não pode estar vazia!");
		}
		
	}
	
	// CPF
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) { 
		if(cpf!=null && !cpf.equals("")) { 
			if (cpf.length() == 11){
				if (cpf.substring(0, 10).matches("[0-9]*")){
					if ((!cpf.equals("00000000000")) && (!cpf.equals("11111111111")) // Sinalizando expressão para melhorar visualização
							&& (!cpf.equals("22222222222")) && (!cpf.equals("33333333333")) 
							&& (!cpf.equals("44444444444")) && (!cpf.equals("55555555555")) 
							&& (!cpf.equals("66666666666")) && (!cpf.equals("77777777777")) 
							&& (!cpf.equals("88888888888"))&& (!cpf.equals("99999999999"))){
						
						this.cpf = cpf;
						
					}else{
						System.out.println("Os números do CPF não podem ser todos igual!");
					}		
							
				} else{
					System.out.println("O CPF não pode conter letras, apenas números!");
				}
			} else{
				System.out.println("O CPF precisa ter 11 caracteres!");
			}
		} else{
			System.out.println("A caixa do CPF não pode estar vazia!");
		}
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if(endereco!=null && !endereco.equals("")){ 
			this.endereco = email;
		}else{
			System.out.println("A caixa endereco não pode estar vazia!");
		}
	}	
}
