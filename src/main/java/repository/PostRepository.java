package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Model.Post;

@Repository
public class PostRepository implements PostRep {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Post post) {
		try {
			String sql = String.format(
					"insert into IdPost(IdPost, Titulo, Slug, Extracto, IdUsuario, Categoria, ImagenDestacada, Tipo)"
					+ "values('%d', '%s', '%s', '%s', '%d', '%d','%s','%s' )", 
					post.getIdPost(), post.getTitulo(), post.getSlug(), post.getExtractor(), post.getIdUsuario(), post.getCategoria(), post.getImagenDestacada() , post.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Post post) {
		if (post.getIdPost() != 0) {
			String sql = String.format("update IdPost set IdPost= '%d', Titulo='%s', Slug='%s', Extracto='%s', IdUsuario='%d',  Categoria='%d', ImagenDestacada='%s' Tipo='%s'"
					+ "where IdPost='%d'", 
					post.getIdPost(), post.getTitulo(), post.getSlug(), post.getExtractor(), post.getIdUsuario(), post.getCategoria(), post.getImagenDestacada() , post.getTipo()
					);
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Post> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}