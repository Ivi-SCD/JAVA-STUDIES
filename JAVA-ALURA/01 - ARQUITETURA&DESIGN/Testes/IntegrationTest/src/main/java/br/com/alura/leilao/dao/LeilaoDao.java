package br.com.alura.leilao.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

@Repository
public class LeilaoDao {

	@PersistenceContext
	private EntityManager em;

	public void salvar(Leilao leilao) {
		em.merge(leilao);
	}

	public Leilao buscarPorId(Long id) {
		return em.find(Leilao.class, id);
	}

	public List<Leilao> buscarTodos() {
		return em.createQuery("SELECT l FROM Leilao l", Leilao.class)
				.getResultList();
	}

	public List<Leilao> buscarLeiloesDoPeriodo(LocalDate inicio, LocalDate fim) {
		return em.createQuery("SELECT l FROM Leilao l WHERE l.dataAbertura BETWEEN :inicio AND :fim", Leilao.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", inicio)
				.getResultList();
	}

	public List<Leilao> buscarLeiloesDoUsuario(Usuario usuario) {
		return em.createQuery("SELECT l FROM Leilao l WHERE l.usuario = :usuario", Leilao.class)
				.setParameter("usuario", usuario)
				.getResultList();
	}

}
