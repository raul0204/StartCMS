package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Model.PostMetadata;

@Repository
public class PostMetadataRepository implements PostMetadataRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(PostMetadata post_metadata) {
		try {
			String sql = String.format(
					"insert into PostMetadata( Clave, Valor, Tipo)"
					+ "values('%s', '%s', '%s')", 
					 post_metadata.getClave(), post_metadata.getValor(), post_metadata.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(PostMetadata post_metadata) {
		if (post_metadata.getIdPost() != 0) {
			String sql = String.format("update PostMetadata set Clave='%s', Valor='%s', Tipo='%s'"
					+ "where IdPostMetadata='%d'", 
					post_metadata.getIdPost(), post_metadata.getClave(), post_metadata.getValor(), post_metadata.getTipo()
					);
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<PostMetadata> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostMetadata findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}