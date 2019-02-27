package com.fortech.testApp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.testApp.dtos.UserDTO;
import com.fortech.testApp.exceptions.CustomException;
import com.fortech.testApp.models.User;
import com.fortech.testApp.services.IUserService;
import com.fortech.testApp.validation.EmailValidator;
import com.fortech.testApp.validation.PasswordValidator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/users")
@Api(tags = "users")
@Slf4j
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/signin")
	public String login(@ApiParam("Username") @RequestParam String username,
			@ApiParam("Password") @RequestParam String password) {
		return userService.signin(username, password);
	}

	@PostMapping("/signup")
	public String signup(@ApiParam("Signup User") @RequestBody UserDTO user) {
		if(!PasswordValidator.isValid(user)) {
			throw new CustomException("Invalid password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		if(!EmailValidator.isValid(user.getEmail())) {
			throw new CustomException("Invalid email supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return userService.signup(convertToEntity(user));
	}

	@DeleteMapping(value = "/{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String delete(@ApiParam("Username") @PathVariable String username) {
		userService.delete(username);
		return username;
	}

	@GetMapping(value = "/{username}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public UserDTO search(@ApiParam("Username") @PathVariable String username) {
		return convertToDTO(userService.search(username));
	}

	@GetMapping(value = "/me")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public UserDTO whoami(HttpServletRequest req) {
		return convertToDTO(userService.whoami(req));
	}

	@GetMapping("/refresh")
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
	public String refresh(HttpServletRequest req) {
		return userService.refresh(req.getRemoteUser());
	}
	
	private UserDTO convertToDTO( User user) {
		modelMapper.addMappings(new PropertyMap<User, UserDTO>() {
			@Override
			protected void configure() {
				map().setGivenLastName(source.getLastName());
				map().setGivenName(source.getName());
			}
		});
		return modelMapper.map(user, UserDTO.class);
	}
	
	private User convertToEntity( UserDTO userDto) {
		modelMapper.addMappings(new PropertyMap<UserDTO, User>() {
			@Override
			protected void configure() {
				map().setLastName(source.getGivenLastName());
				map().setName(source.getGivenName());
			}
		});
		return modelMapper.map(userDto, User.class);
	}

}