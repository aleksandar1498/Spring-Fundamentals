package bg.softuni.dealer.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bg.softuni.dealer.models.binding.BrandModel;
import bg.softuni.dealer.models.service.BrandServiceModel;
import bg.softuni.dealer.service.BrandService;

@Controller
@RequestMapping("/brands")
public class BrandController {
	private BrandService brandService;
	private ModelMapper mapper;

	@Autowired
	public BrandController(BrandService brandService, ModelMapper mapper) {
		this.brandService = brandService;
		this.mapper = mapper;
	}

	@GetMapping("add")
	public String getBrandForm(@ModelAttribute("brand") BrandModel brand) {
		return "brand-add";
	}

	@PostMapping("add")
	public String postBrandForm(@ModelAttribute("brand") BrandModel brand) {
		System.out.println(brand.toString());
		this.brandService.createBrand(mapper.map(brand, BrandServiceModel.class));
		return "redirect:/";
	}
}
