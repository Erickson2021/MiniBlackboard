package org.cibertec.edu.pe.servicios.Impl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.cibertec.edu.pe.model.Categoria;
import org.cibertec.edu.pe.model.Examen;
import org.cibertec.edu.pe.repository.ExamenRepository;
import org.cibertec.edu.pe.servicios.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Override
    public Examen agregarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Examen actualizarExamen(Examen examen) {
        return examenRepository.save(examen);
    }

    @Override
    public Set<Examen> obtenerExamenes() {
        return new LinkedHashSet<>(examenRepository.findAll());
    }

    @Override
    public Examen obtenerExamen(Long examenId) {
        return examenRepository.findById(examenId).get();
    }

    @Override
    public void eliminarExamen(Long examenId) {
        Examen examen = new Examen();
        examen.setExamenId(examenId);
        examenRepository.delete(examen);
    }

	@Override
	public List<Examen> listarExamenesDeUnaCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return this.examenRepository.findByCategoria(categoria);
	}

	@Override
	public List<Examen> obtenerExamenesActivos() {
		// TODO Auto-generated method stub
		return examenRepository.findByActivo(true);
	}

	@Override
	public List<Examen> obtenerExamenesActivosDeUnaCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return examenRepository.findByCategoriaAndActivo(categoria, true);
	}
}
