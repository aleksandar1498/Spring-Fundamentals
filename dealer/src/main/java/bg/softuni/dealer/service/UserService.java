package bg.softuni.dealer.service;

import java.util.List;

import bg.softuni.dealer.models.binding.SellerModel;
import bg.softuni.dealer.models.service.UserServiceModel;

public interface UserService {
	UserServiceModel register(UserServiceModel user);

	List<UserServiceModel> findAllUsers();

	UserServiceModel findById(String id);

}
