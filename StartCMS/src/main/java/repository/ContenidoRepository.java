package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContenidoRepository implements ContenidoRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
}