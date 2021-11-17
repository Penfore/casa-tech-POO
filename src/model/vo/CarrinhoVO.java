package src.model.vo;


public class CarrinhoVO{
    private VendaVO venda;
    private EquipamentoVO produto;
    private int quantidade;
    private Double value;
    
    
	public VendaVO getVenda() {
		return venda;
	}
	
	
	public void setVenda(VendaVO venda) {
		if(venda!= null) {
			this.venda = venda;
		}else {
			System.out.println("venda null");
		}
		
	}
	public EquipamentoVO getProduto() {
		return produto;
	}
	
	public void setProduto(EquipamentoVO produto) {
		if(produto !=null) {
			this.produto = produto;
		}else {
			System.out.println("Produto null");
		}
		this.produto = produto;
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if(quantidade >0) {
			this.quantidade = quantidade;
		}else {
			
		}
		
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}

}