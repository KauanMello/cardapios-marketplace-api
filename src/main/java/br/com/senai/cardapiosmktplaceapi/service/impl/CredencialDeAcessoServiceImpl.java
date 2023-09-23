package br.com.senai.cardapiosmktplaceapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import br.com.senai.cardapiosmktplaceapi.entity.Usuario;
import br.com.senai.cardapiosmktplaceapi.repository.UsuarioRepository;
import br.com.senai.cardapiosmktplaceapi.security.CredencialDeAcesso;

@Service
public class CredencialDeAcessoServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.buscarPor(login);
		Preconditions.checkNotNull(usuario, "Não foi encontrado nenhum usuario para o login informado. ");
		return new CredencialDeAcesso(usuario);
	}

}
