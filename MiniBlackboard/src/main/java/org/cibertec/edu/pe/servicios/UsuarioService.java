package org.cibertec.edu.pe.servicios;

import java.util.Set;
import org.cibertec.edu.pe.model.Usuario;
import org.cibertec.edu.pe.model.UsuarioRol;


public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}

