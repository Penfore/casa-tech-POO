package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import src.model.dao.CarrinhoDao;
import src.model.vo.CarrinhoVO;
import src.model.vo.EquipamentoVO;
import src.model.vo.VendaVO;

public class CarrinhoBO implements BaseInterBO<CarrinhoVO>, CarrinhoInterBO<CarrinhoVO> {
	CarrinhoDao<CarrinhoVO> dao = new CarrinhoDao<CarrinhoVO>();

	public void store(CarrinhoVO vo) {
		try {
			ResultSet rs = dao.listByProdutoVenda(vo);
			if (rs.next()) {
			} else {
				dao.store(vo);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void updateById(CarrinhoVO vo) {
		try {
			ResultSet rs = dao.show(vo);
			if (rs.next()) {
				dao.updateById(vo);
			} else {

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void removeById(CarrinhoVO vo) {
		try {
			dao.removeById(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public CarrinhoVO show(CarrinhoVO vo) {
		ResultSet rs = null;
		CarrinhoVO item = new CarrinhoVO();
		try {
			rs = dao.index();
			while(rs.next()){
				
				VendaVO venda = new VendaVO();
				
				venda.setId(rs.getInt("id"));
				venda.setPrecoTotal(rs.getFloat("precoTotal"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("datadecompra"));
				venda.setDataDeCompra(cal);
				venda.setStatus(rs.getString("status"));
				venda.setFormaDePagamento(rs.getString("formaDePagamento"));
				
				EquipamentoVO equiVO = new EquipamentoVO();
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));

				item.setProduto(equiVO);
				item.setVenda(venda);
				item.setQuantidade(rs.getInt("quantidade"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return item;

	}

	public List<CarrinhoVO> index() {
		ResultSet rs = null;
		List<CarrinhoVO> itens = new ArrayList<CarrinhoVO>();
		try {
			rs = dao.index();
			while(rs.next()){
				CarrinhoVO item = new CarrinhoVO();
				VendaVO venda = new VendaVO();
				
				venda.setId(rs.getInt("id"));
				venda.setPrecoTotal(rs.getFloat("precoTotal"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("datadecompra"));
				venda.setDataDeCompra(cal);
				venda.setStatus(rs.getString("status"));
				venda.setFormaDePagamento(rs.getString("formaDePagamento"));
				
				EquipamentoVO equiVO = new EquipamentoVO();
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));

				item.setProduto(equiVO);
				item.setVenda(venda);
				item.setQuantidade(rs.getInt("quantidade"));
				
				itens.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return itens;
	}

	public List<CarrinhoVO> listByVenda(CarrinhoVO vo) {
		ResultSet rs = null;
		List<CarrinhoVO> itens = new ArrayList<CarrinhoVO>();
		try {
			rs = dao.listByVenda(vo);
			while(rs.next()){
				CarrinhoVO item = new CarrinhoVO();

				EquipamentoVO equiVO = new EquipamentoVO();
				equiVO.setId(rs.getInt("equiId"));
				equiVO.setNome(rs.getString("produto"));
				equiVO.setPreco(rs.getDouble("preco"));

				item.setProduto(equiVO);
				item.setQuantidade(rs.getInt("quantidade"));
				item.setValue(rs.getInt("quantidade")*rs.getDouble("preco"));
				itens.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return itens;
	}

	public List<CarrinhoVO> listByProduto(CarrinhoVO vo) {
		ResultSet rs = null;
		List<CarrinhoVO> itens = new ArrayList<CarrinhoVO>();
		try {
			rs = dao.listByProduto(vo);
			while(rs.next()){
				CarrinhoVO item = new CarrinhoVO();
				VendaVO venda = new VendaVO();
				
				venda.setId(rs.getInt("id"));
				venda.setPrecoTotal(rs.getFloat("precoTotal"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("datadecompra"));
				venda.setDataDeCompra(cal);
				venda.setStatus(rs.getString("status"));
				venda.setFormaDePagamento(rs.getString("formaDePagamento"));
				
				EquipamentoVO equiVO = new EquipamentoVO();
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));

				item.setProduto(equiVO);
				item.setVenda(venda);
				item.setQuantidade(rs.getInt("quantidade"));
				
				itens.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return itens;
	}

	public List<CarrinhoVO> listByProdutoVenda(CarrinhoVO vo) {
		ResultSet rs = null;
		List<CarrinhoVO> itens = new ArrayList<CarrinhoVO>();
		try {
			rs = dao.listByProdutoVenda(vo);
			while(rs.next()){
				CarrinhoVO item = new CarrinhoVO();
				VendaVO venda = new VendaVO();
				
				venda.setId(rs.getInt("id"));
				venda.setPrecoTotal(rs.getFloat("precoTotal"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("datadecompra"));
				venda.setDataDeCompra(cal);
				venda.setStatus(rs.getString("status"));
				venda.setFormaDePagamento(rs.getString("formaDePagamento"));
				
				EquipamentoVO equiVO = new EquipamentoVO();
				equiVO.setId(rs.getInt("id"));
				equiVO.setNome(rs.getString("nome"));
				equiVO.setCodigo(rs.getString("codigo"));
				equiVO.setPeso(rs.getDouble("peso"));
				equiVO.setQuantidade(rs.getInt("quantidade"));
				equiVO.setDescricao(rs.getString("descricao"));
				equiVO.setPreco(rs.getDouble("preco"));

				item.setProduto(equiVO);
				item.setVenda(venda);
				item.setQuantidade(rs.getInt("quantidade"));
				
				itens.add(item);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return itens;
	}
}
