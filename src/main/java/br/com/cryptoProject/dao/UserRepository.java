package br.com.cryptoProject.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.cryptoProject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByNome(String nome);
	
	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from User u where u.id = :id")
	void removerUser(Long id);
}
