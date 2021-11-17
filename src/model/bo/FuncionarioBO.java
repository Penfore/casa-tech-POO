package src.model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.model.dao.FuncionarioDao;
import src.model.dao.UsuarioDao;
import src.model.vo.FuncionarioVO;

public class FuncionarioBO
		implements BaseInterBO<FuncionarioVO>, FuncionarioInterBO<FuncionarioVO>, UsuarioInterBO<FuncionarioVO> {
	UsuarioDao<FuncionarioVO> dao = new FuncionarioDao();
	FuncionarioDao fundao = new FuncionarioDao();

	public void store(FuncionarioVO vo) {
		try {
			ResultSet rs = dao.findByNickName(vo);
			if (rs.next()) {

			} else {
				dao.store(vo);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public void updateById(FuncionarioVO vo) {
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

	public void removeById(FuncionarioVO vo) {
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

	public FuncionarioVO show(FuncionarioVO vo) {
		ResultSet rs = null;
		FuncionarioVO funVO = new FuncionarioVO();
		try {
			rs = dao.index();
			while (rs.next()) {
				funVO.setNickName(rs.getString("nickName"));
				funVO.setSenha(rs.getString("senha"));
				funVO.setId(rs.getInt("id"));
				funVO.setNome(rs.getString("nome"));
				funVO.setEndereco(rs.getString("endereco"));
				funVO.setEmail(rs.getString("email"));
				funVO.setTelefone(rs.getString("telefone"));
				funVO.setCargo(rs.getInt("telefone"));

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return funVO;
	}

	public List<FuncionarioVO> index() {
		ResultSet rs = null;
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			rs = dao.index();
			while (rs.next()) {
				FuncionarioVO funVO = new FuncionarioVO();
				funVO.setNickName(rs.getString("nickName"));
				funVO.setSenha(rs.getString("senha"));
				funVO.setUsuid(rs.getInt("usuario_id"));
				funVO.setId(rs.getInt("id"));
				funVO.setNome(rs.getString("nome"));
				funVO.setEndereco(rs.getString("endereco"));
				funVO.setEmail(rs.getString("email"));
				funVO.setTelefone(rs.getString("telefone"));
				funVO.setCargo(rs.getInt("cargo"));

				funcionarios.add(funVO);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return funcionarios;
	}

	public List<FuncionarioVO> findByEmail(FuncionarioVO vo) {
		ResultSet rs = null;
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			rs = fundao.findByEmail(vo);
			while (rs.next()) {
				FuncionarioVO funVO = new FuncionarioVO();

				funVO.setId(rs.getInt("id"));
				funVO.setNome(rs.getString("nome"));
				funVO.setEndereco(rs.getString("endereco"));
				funVO.setEmail(rs.getString("email"));
				funVO.setTelefone(rs.getString("telefone"));
				funVO.setCargo(rs.getInt("telefone"));

				funcionarios.add(funVO);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return funcionarios;
	}

	public List<FuncionarioVO> listByCargo(FuncionarioVO vo) {
		ResultSet rs = null;
		List<FuncionarioVO> funcionarios = new ArrayList<FuncionarioVO>();
		try {
			rs = fundao.listByCargo(vo);
			while (rs.next()) {
				FuncionarioVO funVO = new FuncionarioVO();

				funVO.setId(rs.getInt("id"));
				funVO.setNome(rs.getString("nome"));
				funVO.setEndereco(rs.getString("endereco"));
				funVO.setEmail(rs.getString("email"));
				funVO.setTelefone(rs.getString("telefone"));
				funVO.setCargo(rs.getInt("telefone"));

				funcionarios.add(funVO);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return funcionarios;
	}

	public FuncionarioVO autenticar(FuncionarioVO vo) {
		ResultSet rs = null;
		FuncionarioVO funvo = new FuncionarioVO();
		try {
			rs = fundao.autenticar(vo);
			while (rs.next()) {
				if (vo.getNickName().equals(rs.getString("nickname")) && vo.getSenha().equals(rs.getString("senha"))) {
					funvo.setId(rs.getInt("id"));
					funvo.setNome(rs.getString("nome"));
					funvo.setEndereco(rs.getString("endereco"));
					funvo.setEmail(rs.getString("email"));
					funvo.setTelefone(rs.getString("telefone"));
					funvo.setCargo(rs.getInt("cargo"));
					funvo.setNickName(rs.getString("nickname"));
					funvo.setSenha(rs.getString("senha"));
				} else {
					// RETURN ERRO
				}
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return funvo;
	}

	@Override
	public Integer quantidadeFuncionarios() throws SQLException {
		ResultSet rs = null;
		int quantidade = 0;
		try {
			rs = fundao.quantidadeFuncionarios();
			while (rs.next()) {
				quantidade = rs.getInt("count");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return quantidade;
	}
}
