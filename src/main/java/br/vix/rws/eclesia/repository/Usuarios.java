package br.vix.rws.eclesia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.vix.rws.eclesia.model.Usuario;
import br.vix.rws.eclesia.repository.helper.usuario.UsuariosQueries;

public interface Usuarios extends JpaRepository<Usuario, Long>, UsuariosQueries {

	public Optional<Usuario> findByEmail(String email);

	public List<Usuario> findByCodigoIn(Long[] codigos);

}
