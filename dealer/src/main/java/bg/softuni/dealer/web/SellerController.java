package bg.softuni.dealer.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bg.softuni.dealer.models.binding.SellerModel;
import bg.softuni.dealer.models.service.UserServiceModel;
import bg.softuni.dealer.service.UserService;
@Controller
@RequestMapping(value = "/users")
public class SellerController {

	private final UserService service;
	private final ModelMapper mapper;
	@Autowired
	public SellerController(UserService service,ModelMapper mapper) {
		this.service = service;
		this.mapper = mapper;
	}
	
	@GetMapping("register")
	public String getRegister(@ModelAttribute("user") SellerModel user) {
		return "register";
	}

	@PostMapping("register")
	public String postRegister(@ModelAttribute("user") SellerModel user) {
		
		service.register(mapper.map(user,UserServiceModel.class));
		return "redirect:/";
	}

}
