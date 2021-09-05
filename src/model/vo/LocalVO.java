package src.model.vo; 

public class LocalVO 
{ 
	private int id;
	private String casa;
	private String compartimento;
	

	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		if(id>=0){
			this.id = id;
		}else{
			System.out.println("A caixa ID nÃ£o pode estar vazia!");
		}	
	}


	// CASA EM QUE O EQUIPAMENTO ESTÃ� ARMAZENADO
	public String getCasa(){
		return casa;
	}
	
	public void setCasa(String casa){
		if(casa!=null && !casa.equals("")){
			this.casa = casa;
		}else{
			System.out.println("A caixa casa nÃ£o pode estar vazia!");
		}
	}



	// COMPARTIMENTO DA CASA 
	public String getCompartimento(){
		return compartimento;
	}
	public void setCompartimento(String compartimento){
		if(compartimento!=null && !compartimento.equals("")){
			this.compartimento = compartimento;
		}else{
			System.out.println("A caixa compartimento nÃ£o pode estar vazia!");
		}
	}
}
