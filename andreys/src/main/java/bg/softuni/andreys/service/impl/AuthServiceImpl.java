package bg.softuni.andreys.service.impl;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import bg.softuni.andreys.domain.service.UserLoginServiceModel;
import bg.softuni.andreys.domain.service.UserRegisterServiceModel;
import bg.softuni.andreys.domain.service.UserServiceModel;
import bg.softuni.andreys.persistence.entities.JpaUser;
import bg.softuni.andreys.persistence.repositories.UserRepository;
import bg.softuni.andreys.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	private ModelMapper mapper;
	private UserRepository userRepo;
	
	
	public AuthServiceImpl(ModelMapper mapper, UserRepository userRepo) {
		this.mapper = mapper;
		this.userRepo = userRepo;
	}

	@Override
	public UserServiceModel login(UserLoginServiceModel loginUser) {
		JpaUser userFromDB = (JpaUser) this.userRepo.findByUsername(loginUser.getUsername()).orElseThrow(() -> {
			return new EntityNotFoundException("A USER WITH THIS USERNAME DOES NOT EXISTS");
		});
		
		if(!userFromDB.getPassword().equals(loginUser.getPassword())) {
			throw new IllegalArgumentException("FAILED AUTHENTICATION");
		}
		
		return this.mapper.map(userFromDB,UserServiceModel.class);
	}

	@Override
	public UserServiceModel register(UserRegisterServiceModel registerUser) {
		if(this.userRepo.findByUsername(registerUser.getUsername()).isPresent()) {
			throw new IllegalArgumentException("USER ALREADY EXISTS");
		}
		if(!registerUser.getPassword().equals(registerUser.getConfirmPassword())) {
			throw new IllegalArgumentException("PASSWORDS DO NOT MATCH");
		}
		
		JpaUser userToSave = this.mapper.map(registerUser,JpaUser.class);
		
		return this.mapper.map(this.userRepo.save(userToSave),UserServiceModel.class);
	}

}
