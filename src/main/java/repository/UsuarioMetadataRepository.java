package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Model.UsuarioMetadata;

@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(UsuarioMetadata usuario_metadata) {
		try {
			String sql = String.format(
					"insert into IdPost(IdUsuarioMetadata, IdUsuario, Clave, Valor, Tipo)"
					+ "values('%d', '%d', '%s', '%s', '%s')", 
					usuario_metadata.getIdUsuarioMetadata(), usuario_metadata.getIdUsuario(), usuario_metadata.getClave(), usuario_metadata.getValor(), usuario_metadata.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(UsuarioMetadata usuario_metadata) {
		if (usuario_metadata.getIdUsuarioMetadata() != 0) {
			String sql = String.format("update IdUsuarioMetadata set IdUsuarioMetadata= '%d', IdUsuario='%d', Clave='%s', Valor='%s', Tipo='%d'"
					+ "where IdUsuarioMetadata='%d'", 
					usuario_metadata.getIdUsuarioMetadata(), usuario_metadata.getIdUsuario(), usuario_metadata.getClave(), usuario_metadata.getValor(), usuario_metadata.getTipo()
					);
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioMetadata findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}