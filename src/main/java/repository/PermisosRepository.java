package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Model.Permisos;

@Repository
public class PermisosRepository implements PermisosRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Permisos permiso) {
		try {
			String sql = String.format(
					"insert into IdPermiso(IdPermiso, Nombre)"
					+ "values('%d', '%s')", 
					permiso.getIdPermiso(), permiso.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Permisos permiso) {
		if (permiso.getIdPermiso() != 0) {
			String sql = String.format("update IdPermiso set IdPermiso= '%d', Nombre='%s'"
					+ "where IdPermiso='%d'", 
					permiso.getIdPermiso(),permiso.getNombre()
					);
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Permisos> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permisos findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}