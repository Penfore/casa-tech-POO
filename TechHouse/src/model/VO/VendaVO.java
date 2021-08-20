package model.VO;
import java.util.Calendar;

public class VendaVO {
     private float precoTotal;
     private String id;
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
		if(precoTotal > 0) {
			this.precoTotal = precoTotal;
		}else {
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("O preço atribuído é inválido!");
		}
	}
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id != null && !id.equals("")) {
			this.id = id;
		}else {
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa ID não pode estar vaiza!");
		}	
	}
	

	public Calendar getDataDecompra() {
		return dataDecompra;
	}
	public void setDataDecompra(Calendar dataDecompra) {
		if(dataDecompra!=null && !dataDecompra.equals("")) {
			this.dataDecompra = dataDecompra;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa da data de compra não estar vazia ou é inválida!");
		}
	}
	

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status!=null && !status.equals("")) {
			this.status = status;
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa status não pode estar vazia!");
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
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("Os atributos do comprador são inválidos!");
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
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("Os atributos do protudo são inválidos!");
		}
	}


	public int[] getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(int[] quantidadeProduto) {
		if(quantidadeProduto > 0) {
			for(int i=0; i < quantidadeProduto.length ; i++) { // MARCAÇÃO para rever como será o uso desses vetores na aplicação;
				if(quantidadeProduto[i]>0) {
					this.quantidadeProduto = quantidadeProduto;
				}
			}
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A quantidade do produto é inválida!");
		}
	}


	public float[] getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(float[] precoProduto) {
		if(precoProduto!=null) {
			for(int i=0; i < precoProduto.length ; i++) { // MARCAÇÃO para rever como será o uso desses vetores na aplicação;
				if(precoProduto[i]>0) {
					this.precoProduto = precoProduto;
				}
			}		
		}else{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("O preço do produto é inválido!");
		}
	}
}
