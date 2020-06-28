package bg.softuni.shopping.web.controllers;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bg.softuni.shopping.common.utils.ObjectMapper;
import bg.softuni.shopping.domain.binding.LoggedInUser;
import bg.softuni.shopping.domain.binding.LoginUserModel;
import bg.softuni.shopping.domain.binding.RegisterUserModel;
import bg.softuni.shopping.domain.service.UserLoginServiceModel;
import bg.softuni.shopping.domain.service.UserRegisterServiceModel;
import bg.softuni.shopping.domain.service.UserServiceModel;
import bg.softuni.shopping.service.UserService;

@Controller
@RequestMapping("/user")
public class AuthController {

	private final UserService userService;

	@Autowired
	public AuthController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping("login")
	public ModelAndView getLogin(@ModelAttribute("user") LoginUserModel user, @RequestParam(value = "redirectURL",required = false,defaultValue = "/") String redirectURL,ModelAndView mView) {
		if(!redirectURL.equals("/")) {
			mView.addObject("redirectURL",redirectURL);
		}
		mView.setViewName("login");
		return mView;
	}

	@PostMapping("login")
	public String postLogin(@Valid @ModelAttribute("user") LoginUserModel user, BindingResult bindingResult,
			HttpSession session, @RequestParam(value = "redirectURL",required = false,defaultValue = "/") String redirectURL) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		try {
			UserServiceModel loginUser = this.userService.login(ObjectMapper.map(user, UserLoginServiceModel.class));
			LoggedInUser sessionUser =   ObjectMapper.map(loginUser, LoggedInUser.class);
			session.setAttribute("user", sessionUser);
		} catch (IllegalArgumentException | NoSuchElementException | EntityNotFoundException e) {
			bindingResult.reject("failedLogin", e.getMessage());
			return "login";
		}
		return "redirect:" + redirectURL;
	}

	@GetMapping("register")
	public String getRegister(@ModelAttribute("user") RegisterUserModel user) {
		return "register";
	}

	@PostMapping("register")
	public String postRegister(@Valid @ModelAttribute("user") RegisterUserModel user, BindingResult binding) {
		if (!user.getPassword().equals(user.getConfirmPassword()) && user.getConfirmPassword() != null
				&& user.getPassword() != null) {
			binding.rejectValue("confirmPassword", "confirmPassword", "Passwords are mismatched");
		}
		if (binding.hasErrors()) {
			return "register";
		}
		try {
			this.userService.register(ObjectMapper.map(user, UserRegisterServiceModel.class));
		} catch (IllegalArgumentException exception) {
			binding.reject("failedRegistration", "Something went wrong , please contact the IT support.");
			return "register";
		}

		return "redirect:/user/login";
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}
}
