package repository;

import java.awt.print.Pageable;
import java.util.List;

import Model.Categoria;

public interface CategoriaRep extends BaseRep<Categoria> {
	public boolean save(Categoria categoria);
	public boolean update(Categoria categoria);
	public List<Categoria> findAll(Pageable pageable);

}
