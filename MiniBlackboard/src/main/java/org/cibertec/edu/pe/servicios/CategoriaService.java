package org.cibertec.edu.pe.servicios;

import java.util.Set;

import org.cibertec.edu.pe.model.Categoria;



public interface CategoriaService {
	
	Categoria agregarCategoria(Categoria categoria);

    Categoria actualizarCategoria(Categoria categoria);

    Set<Categoria> obtenerCategorias();

    Categoria obtenerCategoria(Long categoriaId);

    void eliminarCategoria(Long categoriaId);
}
