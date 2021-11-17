package src.model.vo;
import java.util.Calendar;


public class VendaVO {
	 private int id;
     private float precoTotal;
     private Calendar dataDeCompra; 
     private String status; 
     private ClienteVO comprador;
     private String formaDePagamento;

     
     
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id >=0) {
			this.id = id;
		}else {
			System.out.println("id invalido");
		}
		
	}
	
	public float getPrecoTotal() {
		return precoTotal;
	}
	
	public void setPrecoTotal(float precoTotal) {
		if(precoTotal >= 0) {
			this.precoTotal = precoTotal;
		}else{
			
		}
	}

	public Calendar getDataDeCompra() {
		return dataDeCompra;
	}
	
	public void setDataDeCompra(Calendar dataDeCompra) {
		
		dataDeCompra.get(Calendar.YEAR);
		dataDeCompra.get(Calendar.MONTH);
		dataDeCompra.get(Calendar.DAY_OF_MONTH);
		dataDeCompra.get(Calendar.HOUR_OF_DAY);
		dataDeCompra.get(Calendar.MINUTE);


		this.dataDeCompra = dataDeCompra;
	}
	

	 public String getStatus(){ 
		return status;
	}
	 
	public void setStatus(String status){
		if(status!=null && !status.equals("")){
			this.status = status;
		}else{
			System.out.println("A caixa status não pode estar vazia!");
		}
	} 
	

	public ClienteVO getComprador(){
		return comprador;
	}
	
	public void setComprador(ClienteVO comprador){
		if(comprador!=null) {
			this.comprador = comprador;
		} else{
			System.out.println("Os atributos do comprador são inválidos!");
		}
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		if(formaDePagamento!=null && !formaDePagamento.equals("")) {
			this.formaDePagamento = formaDePagamento;
		}else {
			System.out.println("Forma de pagamento vazia");
		}
		
	}	
}