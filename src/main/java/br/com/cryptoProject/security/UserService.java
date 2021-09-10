package br.com.cryptoProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.cryptoProject.dao.UserRepository;
import br.com.cryptoProject.model.User;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository dao;
	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		User user = dao.findByNome(nome);
		if (user==null) {
			throw new UsernameNotFoundException("Login invalido");
		}
		UserDetailsLocal usd = new UserDetailsLocal(user);
		return usd;
	}
}

