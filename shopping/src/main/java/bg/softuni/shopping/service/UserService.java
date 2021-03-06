package bg.softuni.shopping.service;

import bg.softuni.shopping.domain.service.UserLoginServiceModel;
import bg.softuni.shopping.domain.service.UserRegisterServiceModel;
import bg.softuni.shopping.domain.service.UserServiceModel;

public interface UserService {
	
	UserServiceModel register(UserRegisterServiceModel user);

	UserServiceModel login(UserLoginServiceModel user);
}
