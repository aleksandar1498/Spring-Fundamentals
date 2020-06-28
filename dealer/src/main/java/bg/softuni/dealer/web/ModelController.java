package bg.softuni.dealer.web;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bg.softuni.dealer.models.binding.ModelModel;
import bg.softuni.dealer.models.service.ModelServiceModel;
import bg.softuni.dealer.service.BrandService;
import bg.softuni.dealer.service.ModelService;

@Controller
@RequestMapping("/models")
public class ModelController {
	
	private BrandService brandService;
	private ModelService modelService;
	private ModelMapper mapper;
	
	@Autowired
	public ModelController(BrandService brandService,ModelService modelService,ModelMapper mapper) {
		this.brandService = brandService;
		this.modelService = modelService;
		this.mapper = mapper;
	}

	@GetMapping("add")
	public ModelAndView getAddModel(@ModelAttribute("model") ModelModel model,ModelAndView mView) {
		mView.addObject("brands", this.brandService.findAll());
		mView.setViewName("model-add");
		return mView;
	}
	
	@PostMapping("add")
	public String postAddModel(@ModelAttribute("model") ModelModel model) {
		System.out.println(model.toString());
		System.out.println(this.mapper.map(model,ModelServiceModel.class).toString());
		modelService.createModel(this.mapper.map(model,ModelServiceModel.class));
		return "redirect:/all";
	}
}
