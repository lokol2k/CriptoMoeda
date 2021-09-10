package br.com.cryptoProject.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.cryptoProject.model.CriptoMoeda;

public interface CriptoMoedaRepository extends JpaRepository<CriptoMoeda, Long>{
	
	@Transactional
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query("delete from CriptoMoeda c where c.id = :id")
	void removerCriptoMoeda(Long id);
}
