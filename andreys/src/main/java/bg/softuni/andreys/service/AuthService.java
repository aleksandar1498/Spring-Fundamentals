package bg.softuni.andreys.service;

import bg.softuni.andreys.domain.service.UserLoginServiceModel;
import bg.softuni.andreys.domain.service.UserRegisterServiceModel;
import bg.softuni.andreys.domain.service.UserServiceModel;

public interface AuthService {
	UserServiceModel register(UserRegisterServiceModel registerUser);
	UserServiceModel login(UserLoginServiceModel loginUser);
}
