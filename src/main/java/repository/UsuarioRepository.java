package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Model.Usuario;

@Repository
public class UsuarioRepository implements UsuarioRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Usuario usuario) {
		try {
			String sql = String.format(
					"insert into IdUsuario(IdUsuario, Nombre, Apellido, Contraseña, Correo, IdGrupo)"
					+ "values('%d', '%s', '%s', '%s', '%s', '%d')", 
					usuario.getIdUsuario(), usuario.getNombre(), usuario.getApellido(), usuario.getContraseña(), usuario.getCorreo(), usuario.getIdGrupo());
			jdbcTemplate.execute(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Usuario usuario) {
		if (usuario.getIdUsuario() != 0) {
			String sql = String.format("update IdUsuario set IdUsuario= '%d', Nombre='%s', Apellido='%s', Contraseña='%s', Correo='%s', IdGrupo='%d'"
					+ "where IdUsuario='%d'", 
					usuario.getIdUsuario(), usuario.getNombre(), usuario.getApellido(), usuario.getContraseña(), usuario.getCorreo(), usuario.getIdGrupo()
					);
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}