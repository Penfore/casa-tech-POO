package model.VO;

public class LocalVO {
	private long id;
	private String casa;
	private String compartimento;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		if(id>=0) {
		  this.id = id;
		}	
	}
	
	public String getCasa() {
		return casa;
	}
	
	public void setCasa(String casa) {
		if(casa!=null && !casa.equals("")) {
			this.casa = casa;
		}else{
			//RETURN ERROR?
		}
	}
	
	public String getCompartimento() {
		return compartimento;
	}
	public void setCompartimento(String compartimento) {
		if(compartimento!=null && !compartimento.equals("")) {
			this.compartimento = compartimento;
		}else{
			//RETURN ERROR?
		}
	}

}
