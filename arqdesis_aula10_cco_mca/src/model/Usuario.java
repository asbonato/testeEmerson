package model;

import dao.UsuarioDAO;
import to.UsuarioTO;

public class Usuario {
	private String username, password;

	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Usuario() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + "]";
	}
	
	public boolean validar(UsuarioTO to){
		UsuarioDAO dao = new UsuarioDAO();
		return dao.validar(getTO());
	}

	public UsuarioTO getTO() {
		UsuarioTO to = new UsuarioTO();
		to.setUsername(username);
		to.setPassword(password);
		return to;
	}

}
