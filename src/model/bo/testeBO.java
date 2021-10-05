package src.model.bo;

import src.model.vo.FuncionarioVO;

public class testeBO {

	public testeBO() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		FuncionarioBO bo = new FuncionarioBO();
		FuncionarioVO funvo = new FuncionarioVO();
		
		funvo.setNickName("testeBO8");
		funvo.setSenha("123456789");
		funvo.setNome("testeBO");
		funvo.setEndereco("testeBO");
		funvo.setEmail("teste123454@gmail.com");
		funvo.setTelefone("1111111111");
		funvo.setCargo(1);
		
		bo.store(funvo);

	}

}
