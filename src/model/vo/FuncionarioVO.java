package src.model.vo; 

public class FuncionarioVO extends UsuarioVO // Visto que todo funcionário deverá ter um login como usuário do sistema;
{
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private int cargo; // Cargo está como inteiro pois será uma enumeração;

	
	// NOME DO FUNCIONÁRIO
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		if(nome!=null && !nome.equals("")) 
		{
			this.nome = nome;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa nome não pode estar vazia!");
		}
	}
	//


	// ENDEREÇO DO FUNCIONARIO // Não é opcional
	public String getEndereco() 
	{
		return endereco;
	}
	public void setEndereco(String endereco) 
	{
		if(endereco!=null && !endereco.equals("")) 
		{
			this.endereco = endereco;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa endereço não pode estar vazia!");
		}	
	}
	//


	// E-MAIL DO FUNCIONÁRIO // Não é opcional
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		if(email!=null && !email.equals("")) 
		{
			this.email = email;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa email não pode estar vazia!");
		}	
	}
	//


	// TELEFONE DO FUNCIONÁRIO // Não é opcional
	public String getTelefone() 
	{
		return telefone;
	}
	public void setTelefone(String telefone) 
	{
		if(telefone!=null && !telefone.equals("")) 
		{
			this.telefone = telefone;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa de número de telefone não pode estar vazia!");
		}	
	}
	//


	// CARGO DO FUNCIONÁRIO 
	public int getCargo() 
	{
		return cargo;
	}
	public void setCargo(int cargo) 
	{
		if(cargo >= 0) // && cargo <= 4; O número máximo de cargos dependerá de cada empresa 
		{
			this.cargo = cargo;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("Cargo inválido!");
		}	
	}
	//
}
