package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PostMetadataRepository implements PostMetadataRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
}