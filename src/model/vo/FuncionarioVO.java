package src.model.vo; 

public class FuncionarioVO extends UsuarioVO // Visto que todo funcionÃ¡rio deverÃ¡ ter um login como usuÃ¡rio do sistema;
{
	private int id;
	private String nome;
	private String endereco;
	private String email;
	private String telefone;
	private int cargo;
	private int usuario_id;

	
	//ID
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		if(id >= 0) {
			this.id = id;
		}else {
			System.out.println("ID nao valido");
		}
		
	}
	
	// OBJETO USUARIO
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		if(usuario_id >=0) {
			this.usuario_id = usuario_id;
		}else{
			System.out.println("Usuario_id invalido");
		}
		
	}
	
	// NOME DO FUNCIONÃ�RIO
	public String getNome(){
		return nome;
	}
	
	
	public void setNome(String nome){
		if(nome!=null && !nome.equals("")) 
		{
			this.nome = nome;
		} else{
			System.out.println("A caixa nome nÃ£o pode estar vazia!");
		}
	}



	// ENDEREÃ‡O DO FUNCIONARIO // NÃ£o Ã© opcional
	public String getEndereco(){
		return endereco;
	}
	
	public void setEndereco(String endereco){
		if(endereco!=null && !endereco.equals("")){
			this.endereco = endereco;
		} else{
			System.out.println("A caixa endereÃ§o nÃ£o pode estar vazia!");
		}	
	}


	// E-MAIL DO FUNCIONÃ�RIO 
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email) {
		if(email!=null && !email.equals("")){
			this.email = email;
		} else{
			System.out.println("A caixa email nÃ£o pode estar vazia!");
		}	
	}

	// TELEFONE DO FUNCIONÃ�RIO 
	public String getTelefone(){
		return telefone;
	}
	
	public void setTelefone(String telefone){
		if(telefone!=null && !telefone.equals("")){
			this.telefone = telefone;
		} else{
			System.out.println("A caixa de nÃºmero de telefone nÃ£o pode estar vazia!");
		}	
	}

	// CARGO DO FUNCIONÃ�RIO 
	public int getCargo(){
		return cargo;
	}
	
	public void setCargo(int cargo) 
	{
		if(cargo >= 0){ // && cargo <= 4;
			this.cargo = cargo;
		} else{
			System.out.println("Cargo invÃ¡lido!");
		}	
	}
}
