package org.cibertec.edu.pe.repository;

import java.util.List;

import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExamenRepository extends JpaRepository<Examen,Long> {
	
	List<Examen> findByCategoria(Categoria categoria);
	
	List<Examen> findByActivo(Boolean estado);
	
	List<Examen> findByCategoriaAndActivo(Categoria categoria, Boolean estado);
	
}
