package model.vo;

// Essa classe servirá para gerar os objetos recibos das vendas concluídas. Esses objetos serão salvos em algum lugar que se possa checar;
public class ReciboVO
{
    private VendaVO vendaFinalizada;
    private String id;

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

    public String getId()
    {
        return id;
    }
    public void setId(String VendaVO.id) // Não sei como demosntrar que quero utilizar o id de um objeto de VendaVO;
    {
        this.id = VendaVO.id; // Não sei se é assim, preciso de ajudar;
    }
}