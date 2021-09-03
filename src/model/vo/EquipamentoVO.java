package src.model.vo; 

public class EquipamentoVO {
	private String nome;
	private double peso;
	private double preco;
	private String codigo;
	private int quantidade = 0; // Inicializando com valor zerado para evitar erros;
	private int quantidadePedido = 0; // Inicializando com valor zerado para evitar erros; // Esse atributo é necessário para uso na classe VendaVO;
	private LocalVO local;
	private FuncionarioVO responsavel;
	private String descricao;
	
	
	// NOME DO EQUIPAMENTO
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
			System.out.println("O caixa nome não pode estar vazia!");
		}
	}
	//


	// PESO DO EQUIPAMENTO
	public double getPeso() 
	{
		return peso;
	}
	public void setPeso(double peso) 
	{
		if(peso>0) 
		{
			this.peso = peso;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("O peso atribuído é inválido!");
		}
	}
	//


	// CODIGO DO EQUIPAMENTO
	public String getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(String codigo) 
	{
		if(codigo != null && !codigo.equals("")) 
		{
			this.codigo = codigo;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa do código não pode estar vazia!");
		}
	}
	//


	// QUANTIDADE EM ESTOQUE
	public int getQuantidade() 
	{
		return quantidade;
	}
	public void setQuantidade(int quantidade) 
	{
		this.quantidade += quantidae; // Adicionando mais equipamentos ao estoque;
	}
	// Outro método será criado para diminuir a quantidade de equipamentos no estoque ao se confirmar a compra;


	// QUANTIDADE DE EQUIPAMENTOS NO PEDIDO // Método utilizado na classe VendaVO;
	public int getQuantidadePedido()
	{
		return quantidadePedido;
	}
	public void setQuantidadePedido(int quantidadePedido)
	{
		if (quantidadePedido > 0)
		{
			if (quantidadePedido <= quantidade)
			{
				this.quantidadePedido = quantidadePedido;
			} else
			{
				// No futuro, essa mensagem será trocada por um throw exception;
				System.out.println("A quantidade do equipamento no pedido não pode ser maior do que a quantidade do estoque"); 
			}
		}
	}
	//


	//	LOCAL ONDE OS EQUIPAMENTOS ESTÃO ARMAZENADOS NO ESTOQUE
	public LocalVO getLocal() 
	{ 
		return local;
	}
	public void setLocal(LocalVO local) 
	{
		if(local!=null) 
		{
			if(!local.getCasa().equals("") && !local.getCompartimento().equals(""))
			{
				this.local = local;	
			}			
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa local não pode estar vazia!");
		}
	}
	//
	

	// RESPONSAVEL PELO EQUIPAMENTO NO ESTOQUE
	public FuncionarioVO getResponsavel() 
	{
		return responsavel;
	}
	public void setResponsavel(FuncionarioVO responsavel) 
	{
		if(responsavel!=null) 
		{
			this.responsavel = responsavel;		
		}			
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("Os atributos do responsável estão inválidos!");
		}
		
	}
	//


	// DESCRIÇÃO DO EQUIPAMENTO
	public String getDescricao() 
	{
		return descricao;
	}
	public void setDescricao(String descricao) 
	{
		if(descricao!=null && !descricao.equals("")) 
		{
			if (descricao.length() <= 500) // Limitando em 500 caracteres o tamanho da descrição;
			{
				this.descricao = descricao;
			} else 
			{
				// No futuro, essa mensagem será trocada por um throw exception;
				System.out.println("A descrição precisa ter menos de 500 caracteres!");
			}
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A descrição não pode estar vazia!");
		}
		
	}
	//


	// PREÇO DO EQUIPAMENTO	
	public double getPreco() 
	{
		return preco;
	}
	public void setPreco(double preco) 
	{
		if(preco>0) 
		{
			this.preco = preco;
		} else 
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("O preço atribuído está inválido!");
		}
	}	
	//
}
