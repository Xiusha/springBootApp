package com.fortech.testApp.dtos;

import java.io.Serializable;
import java.util.List;

import com.fortech.testApp.models.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable{

	private static final long serialVersionUID = -6612372204848034743L;

	private Long id;

    private String givenName;

    private String givenLastName;

    private String email;

    private String username;

    private String password;

    private String status;

    private int age;

    private String phone;

    private List<AddressDTO> address;
    
    private List<Role> role;
}
