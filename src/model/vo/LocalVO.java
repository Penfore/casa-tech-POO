package src.model.vo; 

public class LocalVO 
{ 
	private String id;
	private String casa;
	private String compartimento;
	

	// NÚMERO DE IDENTIFICAÇÃO DO LOCAL
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		if(id != null && !id.equals("")) 
		{
			this.id = id;
		} else 
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa ID não pode estar vazia!");
		}	
	}
	//


	// CASA EM QUE O EQUIPAMENTO ESTÁ ARMAZENADO
	public String getCasa() 
	{
		return casa;
	}
	public void setCasa(String casa) 
	{
		if(casa!=null && !casa.equals("")) 
		{
			this.casa = casa;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa casa não pode estar vazia!");
		}
	}
	//


	// COMPARTIMENTO DA CASA EM QUE O COMPARTIMENTO ESTÁ ARMAZENADO
	public String getCompartimento() 
	{
		return compartimento;
	}
	public void setCompartimento(String compartimento) 
	{
		if(compartimento!=null && !compartimento.equals("")) 
		{
			this.compartimento = compartimento;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa compartimento não pode estar vazia!");
		}
	}
	//
}
