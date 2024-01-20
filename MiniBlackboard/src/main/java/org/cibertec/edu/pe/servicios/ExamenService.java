package org.cibertec.edu.pe.servicios;

import java.util.List;
import java.util.Set;

import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Examen;


public interface ExamenService {

    Examen agregarExamen(Examen examen);
    Examen actualizarExamen(Examen examen);
    
    Set<Examen> obtenerExamenes();
    Examen obtenerExamen(Long examenId);

    void eliminarExamen(Long examenId);
    
    List<Examen> listarExamenesDeUnaCategoria(Categoria categoria);
    
    List<Examen> obtenerExamenesActivos();
    
    List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria);
}