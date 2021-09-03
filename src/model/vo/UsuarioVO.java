package src.model.vo; 

public class UsuarioVO 
{
	private String nomeUsuario; 
	private String senha;


	// NOME DE USUARIO DO LOGIN
	public String getNomeUsuario()
	{
		return nome;
	}
	public void setNomeUsuario(String nomeUsuario)
	{
		if(nome!=null && !nomeUsuario.equals(""))
		{
			this.nomeUsuario = nomeUsuario;
		} else 
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa nome não pode estar vazia!");
		}
	}
	//


	// SENHA DE USUARIO DO LOGIN
	public String getSenha() 
	{
		return senha;
	}
	public void setSenha(String senha) 
	{
		if(senha!=null && !senha.equals("")) 
		{
			if (senha.lenght() >= 8) // Senha precisa ter no mínimo 8 caracteres por questões de segurança; Mais padrões podem ser adicionados;
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
	//
}
