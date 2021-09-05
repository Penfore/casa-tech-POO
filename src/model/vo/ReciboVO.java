package src.model.vo;

// Essa classe servirÃ¡ para gerar os objetos recibos das vendas concluÃ­das. 
public class ReciboVO{
    private VendaVO vendaFinalizada;
    private int id;
    
    
    
    public VendaVO getVendaFinalizada(){
        return vendaFinalizada;
    }
    
    
    
    public void setVendaFinalizada(VendaVO vendaFinalizada){
        if (vendaFinalizada != null){
            this.vendaFinalizada = vendaFinalizada;
        } else {
            System.out.println("A venda não foi concluída!");
        }
    }

    public int getId()
    {
        return id;
    }
    public void setId(VendaVO venda) 
    {
        this.id = venda.getId();
    }
}