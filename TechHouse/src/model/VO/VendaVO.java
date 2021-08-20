package model.VO;
import java.util.Calendar;

public class VendaVO {
     private float precoTotal;
     private int id;
     private Calendar dataDecompra;//HOW TO MAKE THIS WHIT CALENDAR 
     private String status;
     private ClienteVO comprador;
     private EquipamentoVO produto[];
     private int quantidadeProduto[];
     private float precoProduto[];
     
     
     
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
	
	public Calendar getDataDecompra() {
		return dataDecompra;
	}
	public void setDataDecompra(Calendar dataDecompra) {
		if(dataDecompra!=null && !dataDecompra.equals("")) {
			this.dataDecompra = dataDecompra;
		}else{
			//RETURN ERROR?
		}
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status!=null && !status.equals("")) {
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
			if(!comprador.getNome().equals("")){
				if(!comprador.getEmail().equals("") || !comprador.getTelefone().equals("")){
					this.comprador = comprador;
				}
			}	
		}else{
			//RETURN ERRO
		}
	}
	public EquipamentoVO[] getProduto() {
		return produto;
	}
	
	public void setProduto(EquipamentoVO[] produto) {
		if(produto!=null) {
			for(int i =0; i<produto.length;i++) {
				if(!produto[i].getNome().equals("") && produto[i].getPreco() > 0) {
					this.produto = produto;
				}
			}
			
		}else{
			//RETURN ERROR?
		}
	}
	public int[] getQuantidadeProduto() {
		return quantidadeProduto;
	}
	
	public void setQuantidadeProduto(int[] quantidadeProduto) {
		if(quantidadeProduto!=null) {
			for(int i=0; i < quantidadeProduto.length ; i++) {
				if(quantidadeProduto[i]>0) {
					this.quantidadeProduto = quantidadeProduto;
				}
			}
		}else{
			//RETURN ERROR?
		}
		
	}
	public float[] getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(float[] precoProduto) {
		if(precoProduto!=null) {
			for(int i=0; i < precoProduto.length ; i++) {
				if(precoProduto[i]>0) {
					this.precoProduto = precoProduto;
				}
			}
			
		}else{
			//RETURN ERROR?
		}
	}
}
