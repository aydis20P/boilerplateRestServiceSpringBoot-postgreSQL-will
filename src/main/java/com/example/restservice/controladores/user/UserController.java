package com.example.restservice.controladores.user;

import java.util.List;

import com.example.restservice.servicios.ServicioUserDto;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.datos.dto.UserDto;


@RestController
public class UserController {

	@Autowired
	private ServicioUserDto servicioUsuarios;

    @GetMapping(path = "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<UserDto>> retrieveAll() {
		
		List <UserDto> usuarios =  servicioUsuarios.recuperaUsuarios();
		
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
		
	}


    @PostMapping(path = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> create(@RequestBody UserDto nuevoUsuario) {
				
		UserDto usuarioDto = servicioUsuarios.agregaUsuario(nuevoUsuario);

		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDto);
		
	}
}
