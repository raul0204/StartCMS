package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Model.GrupoPermiso;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(GrupoPermiso grupo_permiso) {
		try {
			String sql = String.format(
					"insert into IdGrupo(IdGrupo, IdPermiso)"
					+ "values('%d', '%s')", 
					grupo_permiso.getIdGrupo(), grupo_permiso.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(GrupoPermiso grupo_permiso) {
		if (grupo_permiso.getIdGrupo() != 0) {
			String sql = String.format("update IdGrupo set IdGrupo= '%d', IdPermiso='%s'"
					+ "where IdGrupo='%d'", 
					grupo_permiso.getIdGrupo(),grupo_permiso.getIdPermiso()
					);
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<GrupoPermiso> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoPermiso findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}