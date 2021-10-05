package src.model.vo;

public abstract class UsuarioVO {
	private int usu_id;
	private String nickName;
	private String senha;

	public int getUsuid() {
		return usu_id;
	}

	public void setUsuid(int id) {
		if (id >= 0) {
			this.usu_id = id;
		}
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		if (nickName != null && nickName != "") {
			this.nickName = nickName;
		} else {

		}

	}

	// SENHA DE USUARIO DO LOGIN
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null && !senha.equals("")) {
			if (senha.length() >= 8) {
				this.senha = senha;
				// VERIFY SENHA LENGTH
			} else {
				System.out.println("A senha precisa ter 8 ou mais caracteres!");
			}
		} else {
			System.out.println("A caixa senha não pode estar vazia ou está incorreta!");
		}
	}
}
