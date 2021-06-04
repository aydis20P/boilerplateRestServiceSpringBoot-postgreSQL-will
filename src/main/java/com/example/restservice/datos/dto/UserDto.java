package com.example.restservice.datos.dto;
import com.example.restservice.negocio.modelo.User;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;

    private String name;
  
    private String email;

    public static UserDto creaDto(User user) {
        UserDto dto = new UserDto();

		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());

		return dto;
    }
}
