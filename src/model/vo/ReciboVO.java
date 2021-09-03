package src.model.vo;

// Essa classe servirá para gerar os objetos recibos das vendas concluídas. Esses objetos serão salvos em algum lugar que se possa checar;
public class ReciboVO
{
    private VendaVO vendaFinalizada;
    private String id;


    // OBJETO DA VENDA FINALIZADA QUE SERÁ PASSADO POR REFERÊNCIA PARA A CLASSE ReciboVO
    public VendaVO getVendaFinalizada()
    {
        return vendaFinalizada;
    }
    public void setVendaFinalizada(VendaVO vendaFinalizada)
    {
        if (vendaFinalizada != null)
        {
            this.vendaFinalizada = vendaFinalizada;
        } else 
        {
            System.out.println("A venda não foi concluída!");
        }
    }
    //


    // NÚMERO IDENTIFICADO DA VENDA FINALIZADA
    public String getId()
    {
        return id;
    }
    public void setId(VendaVO vendaFinalizada) 
    {
        this.id = vendaFinalizada.getId(); 
    }
    //
}