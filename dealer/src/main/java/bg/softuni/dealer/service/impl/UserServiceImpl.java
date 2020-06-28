package bg.softuni.dealer.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.dealer.models.service.ModelServiceModel;
import bg.softuni.dealer.models.service.UserServiceModel;
import bg.softuni.dealer.persistence.entities.JpaUser;
import bg.softuni.dealer.persistence.repositories.UserRepository;
import bg.softuni.dealer.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	private ModelMapper modelMapper;

	@Autowired
	public UserServiceImpl(UserRepository userRepo, ModelMapper modelMapper) {
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserServiceModel register(UserServiceModel user) {

		user.setActive(true);
		user.setCreated(LocalDateTime.now());
		user.setModified(LocalDateTime.now());

		JpaUser userToSave = userRepo.save(modelMapper.map(user, JpaUser.class));

		return modelMapper.map(userToSave, UserServiceModel.class);
	}

	@Override
	public List<UserServiceModel> findAllUsers() {
		return this.userRepo.findAll().stream().map(u -> this.modelMapper.map(u, UserServiceModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public UserServiceModel findById(String id) {
		return this.userRepo.findById(id).map(u -> {
			if (u == null) {
				return null;
			}

			return this.modelMapper.map(u, UserServiceModel.class);
		}).orElse(null);
	}

}
