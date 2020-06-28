package bg.softuni.andreys.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bg.softuni.andreys.domain.service.ItemServiceModel;
import bg.softuni.andreys.service.ItemService;

@Controller
@RequestMapping("/")
public class HomeController {

	ModelMapper mapper;
	ItemService itemService;
	
	@Autowired
	public HomeController(ModelMapper mapper, ItemService itemService) {
		this.mapper = mapper;
		this.itemService = itemService;
	}

	@GetMapping
	public String showIndex(HttpSession session) {
		return session.getAttribute("user") != null ? "redirect:home" :"index";
	}
	
	@GetMapping("/home")
	public ModelAndView showHome(ModelAndView mView) {
		List<ItemServiceModel> items = this.itemService.findAll();
		System.out.println(items);
		mView.addObject("items", items);
		mView.setViewName("home");
		return mView;
	}
}
