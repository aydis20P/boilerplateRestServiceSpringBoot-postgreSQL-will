package com.example.restservice.servicios;

import java.util.ArrayList;
import java.util.List;

import com.example.restservice.datos.UserRepository;
import com.example.restservice.datos.dto.UserDto;
import com.example.restservice.negocio.modelo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUserDto {
    @Autowired UserRepository userRepository;

    /**
	 * Recupera todos los usuarios existentes
	 * 
	 * @return Una lista con los usuarios (o lista vacía)
	 */
	public List <UserDto> recuperaUsuarios() {
		
		List <UserDto> usuarios = new ArrayList<>();
		
		for(User usuario:userRepository.findAll()) {
			usuarios.add(UserDto.creaDto(usuario));
		}
				
		return usuarios;
	}

	/**
	 * Permite agregar un usuario
	 *  
	 * @param usuarioDto
	 * @return dto con el id del usuario
	 */
	public UserDto agregaUsuario(UserDto usuarioDto) {
		String nombre = usuarioDto.getName();
		String email = usuarioDto.getEmail();
		
		usuario = new User();
		usuario.setName(nombre);
		usuario.setEmail(email);
		usuario = userRepository.save(usuario);
		
		return UserDto.creaDto(usuario);
	}    
}
