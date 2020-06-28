package bg.softuni.shopping.web.controllers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import bg.softuni.shopping.common.enums.CategoryType;
import bg.softuni.shopping.domain.service.ProductServiceModel;
import bg.softuni.shopping.service.ProductService;

@Controller("/")
public class HomeController {
	
	private ProductService productService;
	
	@Autowired
	public HomeController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public String showHome(HttpSession session) {
		return session.getAttribute("user") == null ? "index" : "redirect:/home";
	}
	
	@GetMapping("home")
	public ModelAndView viewHome(ModelAndView modelAndView) {
		List<ProductServiceModel> products = this.productService.getAllProducts();
		System.out.println(products);
		Arrays.stream(CategoryType.values()).forEach(c -> {
			modelAndView.addObject((c.toString()+"s").toLowerCase(), products.stream().filter(p -> p.getCategory().equals(c)).collect(Collectors.toList()));
		});
		modelAndView.addObject("totPrice", products.stream().map(ProductServiceModel::getPrice).reduce(BigDecimal.ZERO,(a,b) -> a.add(b)));
		System.out.println(modelAndView);
		modelAndView.setViewName("home");
		return modelAndView;
	}
}
