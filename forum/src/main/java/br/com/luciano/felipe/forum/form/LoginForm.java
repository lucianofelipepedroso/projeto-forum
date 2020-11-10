package br.com.luciano.felipe.forum.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class LoginForm {

	private String email;
	private String senha;

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public UsernamePasswordAuthenticationToken converter() {

		return new UsernamePasswordAuthenticationToken(getEmail(), getSenha());
	}

}
