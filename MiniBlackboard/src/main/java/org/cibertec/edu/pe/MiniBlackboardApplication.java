package org.cibertec.edu.pe;

import org.cibertec.edu.pe.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class MiniBlackboardApplication implements CommandLineRunner {
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(MiniBlackboardApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/*
			Usuario usuario = new Usuario();

			usuario.setNombre("Erick");
			usuario.setApellido("Espinoza");
			usuario.setUsername("erick");
			usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
			usuario.setEmail("erick@gmail.com");
			usuario.setTelefono("998741321");
			usuario.setPerfil("foto.png");

			Rol rol = new Rol();
			rol.setRolId(2L);
			rol.setRolNombre("ADMIN");

			Set<UsuarioRol> usuariosRoles = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuariosRoles.add(usuarioRol);

			Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuariosRoles);
			System.out.println(usuarioGuardado.getUsername());
		*/
	}

}
 