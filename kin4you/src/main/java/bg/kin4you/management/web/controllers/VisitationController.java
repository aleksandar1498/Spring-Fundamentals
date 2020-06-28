package bg.kin4you.management.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bg.kin4you.management.model.binding.VisitationModel;
import bg.kin4you.management.model.service.VisitationServiceModel;
import bg.kin4you.management.services.VisitationService;

@Controller
@RequestMapping("/visitations")
public class VisitationController {

	private ModelMapper mapper;
	private VisitationService visitService;

	public VisitationController(ModelMapper mapper, VisitationService visitService) {
		this.mapper = mapper;
		this.visitService = visitService;
	}

	@GetMapping("/{id}")
	public ModelAndView getVisitationDetails(@PathVariable("id") String id, ModelAndView mView) {
		VisitationServiceModel visitation = this.visitService.findVisitationById(id);
		System.out.println(visitation);
		mView.addObject("visitation", visitation);
		mView.setViewName("visitation-details");
		return mView;
	}
}
