package org.cibertec.edu.pe.servicios;

import java.util.Set;

import org.cibertec.edu.pe.model.Examen;
import org.cibertec.edu.pe.model.Pregunta;


public interface PreguntaService {
	
	Pregunta agregarPregunta(Pregunta pregunta);

    Pregunta actualizarPregunta(Pregunta pregunta);

    Set<Pregunta> obtenerPreguntas();

    Pregunta obtenerPregunta(Long preguntaId);

    Set<Pregunta> obtenerPreguntasDelExamen(Examen examen);

    void eliminarPregunta(Long preguntaId);
    
    Pregunta listarPregunta(Long preguntaId);
}
