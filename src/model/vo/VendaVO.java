package src.model.vo;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class VendaVO {
	 private int id;
     private float precoTotal;
     private String codigo;
     private Calendar dataDeCompra; 
     private String status; 
     private ClienteVO comprador;
	 private ArrayList <EquipamentoVO> carrinhoCompras = new ArrayList<EquipamentoVO>();
	 //carrinho de compras vai ser uma tabela n-n no banco entre venda e produto
	 //ver como fazer isso aq depois 
	 
	 private int quantidadeProduto[]; //mudar pra arrayList depois 
     
     
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


	public String getCodigo(){
		return codigo;
	}
	public void setCodigo(String codigo){
		if (codigo != null && !codigo.equals("")){
			this.codigo = codigo;	
		}else{
			System.out.println("A caixa ID não pode estar vaiza!");
		}	
	}
	
	//ESSA FUNCAO NAO SERA USADA AQUI 
//	public String generateCodigo(){ 
//		Random gerador = new Random();
//
//		String aux = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
//		String cod = "";
//
//		while (cod.length() < 35){
//			cod = cod + aux.charAt(gerador.nextInt(62));
//		} 
//		
//		return cod;
//	}
	

	public Calendar getDataDeCompra() {
		return dataDeCompra;
	}
	
	public void setDataDeCompra() {
		Calendar dataDeCompra = Calendar.getInstance();

		dataDeCompra.get(Calendar.YEAR);
		dataDeCompra.get(Calendar.MONTH);
		dataDeCompra.get(Calendar.DAY_OF_MONTH);
		dataDeCompra.get(Calendar.HOUR_OF_DAY);
		dataDeCompra.get(Calendar.MINUTE);
		dataDeCompra.get(Calendar.SECOND);

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


	public ArrayList <EquipamentoVO> getCarrinhoCompras(){
		return carrinhoCompras;
	}
	
	public void setCarrinhoCompras(EquipamentoVO equipamento){
		if (equipamento != null){
			this.carrinhoCompras.add(equipamento);
		}
	}

	public int[] getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(int[] quantidadeProduto) {
		for(int i =0; i <quantidadeProduto.length; i++ ) {
			if(quantidadeProduto[i]>=0){
				this.quantidadeProduto = quantidadeProduto;
			}else{
				
			}
		}
	}
	
	
}