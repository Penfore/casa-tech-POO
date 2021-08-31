package model.vo; // Será corrigido os caminhos dos diretórios para encaixar nas próximas branches

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

public class VendaVO {
     private float precoTotal;
     private String id;
     private Calendar dataDeCompra; //HOW TO MAKE THIS WHIT CALENDAR // Solved ;)
     private String status;
     private ClienteVO comprador;
	 private ArrayList <EquipamentoVO> carrinhoCompras = new ArrayList<EquipamentoVO>();
     
     
	public float getPrecoTotal() {
		return precoTotal;
	}
	public void setPrecoTotal() {
		for(int i = 0; i < carrinhoCompras.size(); i++)
		{
			precoTotal = precoTotal + (carrinhoCompras.get(i).getPreco() * carrinhoCompras.get(i).getQuantidadePedido());
		}
	}
	public void zerarPrecoTotal() 
	{
		precoTotal = 0;
	}
	

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

		while (id.lenght() < 35)
		{
			id = id + aux.charAt(gerador.nextInt(62));
		}

		this.id = id;
	}
	

	public Calendar getDataDeCompra() {
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
}
