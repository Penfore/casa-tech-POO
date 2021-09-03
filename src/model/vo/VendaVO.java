package src.model.vo; 

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class VendaVO 
{
     private float precoTotal;
     private String id;
     private Calendar dataDeCompra; 
     private String status; // Talvez seja necessário utilizar uma enumeração ou booleanos;
     private ClienteVO comprador;
	 private ArrayList <EquipamentoVO> carrinhoCompras = new ArrayList<EquipamentoVO>();
     
     
	// PREÇO TOTAL DOS ITENS DO CARRINHO 
	public float getPrecoTotal() 
	{
		return precoTotal;
	}
	public void setPrecoTotal() 
	{
		for(int i = 0; i < carrinhoCompras.size(); i++)
		{
			precoTotal = precoTotal + (carrinhoCompras.get(i).getPreco() * carrinhoCompras.get(i).getQuantidadePedido());
		}
	}
	public void zerarPrecoTotal() // Método para zerar o preço caso se desista da compra;
	{
		precoTotal = 0;
	}
	//	


	// NÚMERO IDENTIFICADOR DA COMPRA
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		if (id != null && !id.equals("")) 
		{
			this.id = id;	
		} else 
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa ID não pode estar vaiza!");
		}	
	}
	public void setId() // Gerador de ID
	{
		Random gerador = new Random();

		String aux = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String id = "";

		while (id.lenght() < 35) // Padronizando a quantidade de caracteres do ID em 35;
		{
			id = id + aux.charAt(gerador.nextInt(62));
		}

		this.id = id;
	}
	//


	// REGISTRANDO A DATA DA COMPRA
	public Calendar getDataDeCompra() 
	{
		return dataDeCompra;
	}
	public void setDataDeCompra() 
	{
		Calendar dataDeCompra = Calendar.getInstance();

		dataDeCompra.get(Calendar.YEAR);
		dataDeCompra.get(Calendar.MONTH);
		dataDeCompra.get(Calendar.DAY_OF_MONTH);
		dataDeCompra.get(Calendar.HOUR_OF_DAY);
		dataDeCompra.get(Calendar.MINUTE);
		dataDeCompra.get(Calendar.SECOND);

		this.dataDeCompra = dataDeCompra;
	}
	//


	// STATUS DA COMPRA // Talvez seja necessário utilizar uma enumeração ou booleanos;
	public String getStatus() 
	{ 
		return status;
	}
	public void setStatus(String status) 
	{
		if(status!=null && !status.equals("")) 
		{
			this.status = status;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("A caixa status não pode estar vazia!");
		}
	} 
	//


	// DADOS DO CLIENTE COMPRADOR
	public ClienteVO getComprador() 
	{
		return comprador;
	}
	public void setComprador(ClienteVO comprador) 
	{
		if(comprador!=null) 
		{
			this.comprador = comprador;
		} else
		{
			// No futuro, essa mensagem será trocada por um throw exception;
			System.out.println("Os atributos do comprador são inválidos!");
		}
	}
	//


	// ARRAY DE EQUIPAMENTOS PARA CONTABILIZAR O PREÇO DO CARRINHO
	public ArrayList <EquipamentoVO> getCarrinhoCompras()
	{
		return carrinhoCompras;
	}
	public void setCarrinhoCompras(EquipamentoVO equipamento)
	{
		if (equipamento != null)
		{
			this.carrinhoCompras.add(equipamento);
		}
	}
	//
}
