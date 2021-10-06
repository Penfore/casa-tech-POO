package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.model.dao.CarrinhoDao;
import src.model.vo.CarrinhoVO;

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
			ResultSet rs = dao.show(vo);
			if (rs.next()) {
				dao.removeById(vo);
			} else {

			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void show(CarrinhoVO vo) {
		try {
			dao.show(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void index() {
		try {
			dao.index();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void listByVenda(CarrinhoVO vo) {
		try {
			dao.listByVenda(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void listByProduto(CarrinhoVO vo) {
		try {
			dao.listByProduto(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void listByProdutoVenda(CarrinhoVO vo) {
		try {
			dao.listByProdutoVenda(vo);
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

}
