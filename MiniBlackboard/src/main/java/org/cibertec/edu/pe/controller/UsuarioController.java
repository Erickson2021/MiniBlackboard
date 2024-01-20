package org.cibertec.edu.pe.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.cibertec.edu.pe.model.Rol;
import org.cibertec.edu.pe.model.Usuario;
import org.cibertec.edu.pe.model.UsuarioRol;
import org.cibertec.edu.pe.repository.UsuarioRepository;
import org.cibertec.edu.pe.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
    	//imagen
        usuario.setPerfil("default.png");
        
        //Encriptar password
        usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
        
        Set<UsuarioRol> usuarioRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setRolNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return usuarioService.guardarUsuario(usuario,usuarioRoles);
    }
    
  //LISTAR
  	@GetMapping
  	public List<Usuario> listar(){
  		return usuarioRepository.findAll();
  	}
  	
  	//BUSCAR
  	@GetMapping("/{id}")
  	public ResponseEntity<Usuario> Buscar(@PathVariable Long id) {
  		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

  		if (usuarioOptional.isPresent()) {
  		    Usuario usuario = usuarioOptional.get();
  		    return ResponseEntity.ok(usuario);
  		} else {
  		    return ResponseEntity.notFound().build();
  		}

  	}
  	
  	//MODIFICAR
  	@PutMapping
  	public void modificar(@RequestBody Usuario a) {
  		usuarioRepository.save(a);
  	}
  	
  	//DELETE
  	@DeleteMapping(value = "/{id}")
  	public void eliminar(@PathVariable("id") Long id) {
  		usuarioRepository.deleteById(id);
  	}

}