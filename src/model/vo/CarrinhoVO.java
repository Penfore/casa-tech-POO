package src.model.vo;


public class CarrinhoVO{
    private VendaVO venda;
    private EquipamentoVO produto;
    private int quantidade;
    
    
	public VendaVO getVenda() {
		return venda;
	}
	
	
	public void setVenda(VendaVO venda) {
		if(venda.getStatus().equals("Aberto")) {
			this.venda = venda;
		}else {
			System.out.println("essa compra está encerrada!");
		}
		
	}
	public EquipamentoVO getProduto() {
		return produto;
	}
	
	public void setProduto(EquipamentoVO produto) {
		if(produto.getQuantidade()>0) {
			this.produto = produto;
		}else {
			System.out.println("Produto Sem estoque");
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

}