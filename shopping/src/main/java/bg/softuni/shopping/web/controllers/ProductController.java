package bg.softuni.shopping.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bg.softuni.shopping.common.utils.ObjectMapper;
import bg.softuni.shopping.domain.binding.ProductAddModel;
import bg.softuni.shopping.domain.service.ProductServiceModel;
import bg.softuni.shopping.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	@GetMapping("add")
	public String addProductForm(@ModelAttribute("product") ProductAddModel product) {
		return "product-add";
	}
	@PostMapping("add")
	public String addProduct(@Valid @ModelAttribute("product") ProductAddModel product,BindingResult result) {
		if(result.hasErrors()) {
			return "product-add";
		}
		try {
			this.productService.add(ObjectMapper.map(product,ProductServiceModel.class));
		}catch (Exception e) {
			result.reject("failure", e.getMessage());
			return "product-add";
		}
		return "redirect:/";
	}
	@GetMapping("buy/{id}")
	public String buyOneProduct(@PathVariable("id") String productId) {
		this.productService.buy(productId);
		return "redirect:/";
	}
	
	@GetMapping("buy")
	public String buyAllProducts() {
		this.productService.buyAll();
		return "redirect:/";
	}
	
}
