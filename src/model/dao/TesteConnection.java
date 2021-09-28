package src.model.dao;

import src.model.vo.UsuarioVO;
import src.model.vo.FuncionarioVO;
import src.model.vo.LocalVO;
import src.model.vo.ClienteVO;
import src.model.vo.EquipamentoVO;
import src.model.vo.VendaVO;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class TesteConnection {
	public static void main(String[] args) throws SQLException {

		BaseDao dao = new BaseDao();
		System.out.println(dao.getConnection());

		// teste para inserir usuario
		UsuarioDao usuDao = new UsuarioDao();
		UsuarioVO usuVO = new UsuarioVO();
		usuVO.setNickName("Manteigx");
		usuVO.setSenha("123456789");
		usuVO.setId(2);
		// usuDao.inserir(usuVO);

		/*
		 * List<UsuarioVO> usuarios = usuDao.index();
		 * 
		 * for(UsuarioVO usuList: usuarios){ System.out.println(usuList);
		 * System.out.println(usuList.getId()); }
		 */

		// teste para funcionario
		FuncionarioDao funDao = new FuncionarioDao();
		FuncionarioVO funVO = new FuncionarioVO();

		funVO.setId(1);
		funVO.setNome("Isabele");
		funVO.setEndereco("Rua acula 1234");
		funVO.setEmail("isabeleC@gmail.com");
		funVO.setTelefone("111111111");
		funVO.setCargo(1);
		funVO.setUsuario(usuVO);

		// funDao.inserir(funVO);
		/*
		 * List<FuncionarioVO> funcionarios = funDao.index(); for(FuncionarioVO funList:
		 * funcionarios){ System.out.println(funList.getUsuario().getNickName()); }
		 */

		// teste local
		LocalDao localDao = new LocalDao();
		LocalVO localVO = new LocalVO();

		localVO.setCasa("casaDaIsabele");
		localVO.setCompartimento("quarto1");
		localVO.setId(1);

		// localDao.Inserir(localVO);

		// teste equipamento
		EquipamentoDao equiDao = new EquipamentoDao();
		EquipamentoVO equiVO = new EquipamentoVO();

		equiVO.setNome("Teclado");
		equiVO.setCodigo("ABCDEFG123123");
		equiVO.setPeso(0.2);
		equiVO.setQuantidade(50);
		equiVO.setDescricao("teclado muito bonito com luzinha rgb");
		equiVO.setPreco(200);
		equiVO.setResponsavel(funVO);
		equiVO.setLocal(localVO);

		// equiDao.inserir(equiVO);

//		  List<EquipamentoVO> equipamentos = equiDao.index(); 
//		  for(EquipamentoVO equiList: equipamentos){ 
//			  System.out.println(equiList.getNome()); 
//		  }

		// testar cliente

		ClienteDao cliDao = new ClienteDao();
		ClienteVO cliVO = new ClienteVO();

		cliVO.setId(1);
		cliVO.setNome("Cliente123");
		cliVO.setRua("rua");
		cliVO.setBairro("bairro");
		cliVO.setEmail("email@gmail");
		cliVO.setTelefone("222222222");
		cliVO.setCep("62900000");
		cliVO.setCpf("01000000000");

		// cliDao.Inserir(cliVO);

		// teste venda

		VendaDao vendaDao = new VendaDao();
		VendaVO vendaVO = new VendaVO();

		Calendar dataDeCompra = Calendar.getInstance();

		vendaVO.setId(1);
		vendaVO.setPrecoTotal(0);
		vendaVO.setCodigo("ABCD123");
		vendaVO.setDataDeCompra(dataDeCompra);
		vendaVO.setStatus("Aberto");
		vendaVO.setComprador(cliVO);

		// vendaDao.inserir(vendaVO);

		List<VendaVO> vendas = vendaDao.index();

		for (VendaVO usuList : vendas) {
			System.out.println(vendas);
		}

	}

}