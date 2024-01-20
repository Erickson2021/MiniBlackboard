package org.cibertec.edu.pe.repository;

import java.util.Set;

import org.cibertec.edu.pe.model.Examen;
import org.cibertec.edu.pe.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PreguntaRepository extends JpaRepository<Pregunta,Long> {

    Set<Pregunta> findByExamen(Examen examen);

}

