package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Model.Grupo;

@Repository
public class GrupoRepository implements GrupoRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Grupo grupo) {
		try {
			String sql = String.format(
					"insert into IdGrupo(IdGrupo, Nombre)"
					+ "values('%d', '%s')", 
					grupo.getIdGrupo(), grupo.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Grupo grupo) {
		if (grupo.getIdGrupo() != 0) {
			String sql = String.format("update IdGrupo set IdGrupo= '%d', Nombre='%s'"
					+ "where IdGrupo='%d'", 
					grupo.getIdGrupo(),grupo.getNombre()
					);
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Grupo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Grupo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}