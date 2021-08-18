package model.VO;
import java.util.Calendar;

public class VendaVO {
     public float precoTotal;
     public int id;
     public String dataDecompra;//HOW TO MAKE THIS WHIT CALENDAR 
     public String status;
     public ClienteVO comprador;
     public EquipamentoVO produto[];
     public int quantidadeProduto[];
     public float precoProduto[];
     
     
     
	public float getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal(float precoTotal) {
		if(precoTotal >0) {
			this.precoTotal = precoTotal;
		}
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if(id>=0) {
			this.id = id;
		}	
	}
	
	public String getDataDecompra() {
		return dataDecompra;
	}
	public void setDataDecompra(String dataDecompra) {
		if(dataDecompra!=null && !dataDecompra.equals(" ")) {
			this.dataDecompra = dataDecompra;
		}else{
			//RETURN ERROR?
		}
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status!=null && !status.equals(" ")) {
			this.status = status;
		}else{
			//RETURN ERROR?
		}
	}
	
	public ClienteVO getComprador() {
		return comprador;
	}
	public void setComprador(ClienteVO comprador) {
		if(comprador!=null) {
			this.comprador = comprador;
		}else{
			//RETURN ERROR?
		}
	}
	
	public EquipamentoVO[] getProduto() {
		return produto;
	}
	
	public void setProduto(EquipamentoVO[] produto) {
		if(produto!=null) {
			this.produto = produto;
		}else{
			//RETURN ERROR?
		}
	}
	public int[] getQuantidadeProduto() {
		return quantidadeProduto;
	}
	
	public void setQuantidadeProduto(int[] quantidadeProduto) {
		if(quantidadeProduto!=null) {
			this.quantidadeProduto = quantidadeProduto;
		}else{
			//RETURN ERROR?
		}
		
	}
	public float[] getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(float[] precoProduto) {
		if(precoProduto!=null) {
			this.precoProduto = precoProduto;
		}else{
			//RETURN ERROR?
		}
	}
     
     
}
