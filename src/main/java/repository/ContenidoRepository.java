package repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Model.Contenido;

@Repository
public class ContenidoRepository implements ContenidoRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Contenido contenido) {
		try {
			String sql = String.format(
					"insert into Contenido(Contenido,Tipo,IdContenido, IdPost)"
					+ "values('%s', '%s', '%d', '%s')", 
					contenido.getContenido(), contenido.getTipo(), contenido.getIdContenido(), contenido.getIdPost());
			jdbcTemplate.execute(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean update(Contenido contenido) {
		if (contenido.getIdContenido() != 0) {
			String sql = String.format("update Contenido set Contenido= '%s', Tipo='%s', IdContenido='%d', IdPost='$s'"
					+ "where IdContenido='%d'", 
					contenido.getContenido(), contenido.getTipo(), contenido.getIdContenido(),contenido.getIdPost()
					);
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Contenido> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contenido findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}