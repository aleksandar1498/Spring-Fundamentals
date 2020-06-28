package bg.softuni.dealer.web;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bg.softuni.dealer.common.enums.CategoryType;
import bg.softuni.dealer.common.enums.EngineType;
import bg.softuni.dealer.common.enums.TransmissionType;
import bg.softuni.dealer.models.binding.OfferModel;
import bg.softuni.dealer.models.service.ModelServiceModel;
import bg.softuni.dealer.models.service.OfferServiceModel;
import bg.softuni.dealer.models.service.UserServiceModel;
import bg.softuni.dealer.models.view.OfferViewModel;
import bg.softuni.dealer.service.ModelService;
import bg.softuni.dealer.service.OfferService;
import bg.softuni.dealer.service.UserService;

@Controller
@RequestMapping("/offers")
public class OfferController {
	private OfferService offerService;
	private ModelService modelService;
	private ModelMapper mapper;
	private UserService userService;
	
	@Autowired
	public OfferController(OfferService offerService, ModelMapper mapper, UserService userService,ModelService modelService) {
		this.offerService = offerService;
		this.mapper = mapper;
		this.userService = userService;
		this.modelService = modelService;
	}
	
	@GetMapping("all")
	public ModelAndView getAll(ModelAndView mView) {
		List<OfferViewModel> offers = this.offerService.findAll().stream().map(o -> mapper.map(o,OfferViewModel.class)).collect(Collectors.toList());
		System.out.println(offers.size());
		offers.forEach(o -> {
			System.out.println(o.toString());
		});
		mView.addObject("offers",offers);
		mView.setViewName("all");
		return mView;
	}
	
	@GetMapping("/details/{id}")
	public ModelAndView getDetails(ModelAndView model,@PathVariable("id") String id) {
		OfferModel offer = mapper.map(this.offerService.findById(id),OfferModel.class);
		System.out.println(offer.toString());
		model.addObject("offer", offer);
		model.setViewName("details");
		return model;
	}

	@GetMapping("add")
	public ModelAndView getOfferAdd(@ModelAttribute("offer") OfferModel offer,ModelAndView model) {
		List<ModelServiceModel> models = this.modelService.findAllModels();
		List<UserServiceModel> users = this.userService.findAllUsers();
		model.addObject("models",models);
		model.addObject("users",users);
		model.addObject("categories",CategoryType.values());
		model.addObject("transmissions",TransmissionType.values());
		model.addObject("engines",EngineType.values());
		model.setViewName("offer-add");
		return model;
	}
	
	@PostMapping("add")
	public String postOfferAdd(@ModelAttribute("offer") OfferModel offer) {
		this.offerService.create(this.mapper.map(offer,OfferServiceModel.class));
		return "redirect:/offers/add";
	}
}
