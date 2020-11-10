package br.com.luciano.felipe.forum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luciano.felipe.forum.dto.TokenDto;
import br.com.luciano.felipe.forum.form.LoginForm;
import br.com.luciano.felipe.forum.security.TokenService;

@RestController
@RequestMapping(value = "auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private TokenService tokenService;

	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authenticate = authenticationManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
