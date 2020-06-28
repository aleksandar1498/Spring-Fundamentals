package bg.kin4you.management.web.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bg.kin4you.management.model.binding.PatientModel;
import bg.kin4you.management.model.binding.VisitationModel;
import bg.kin4you.management.model.service.PatientServiceModel;
import bg.kin4you.management.model.service.VisitationServiceModel;
import bg.kin4you.management.services.PatientService;
import bg.kin4you.management.services.VisitationService;
import bg.kin4you.management.utils.ImageManager;

@Controller
@RequestMapping("/patients")
public class PatientController {

	private ModelMapper mapper;
	private PatientService patientService;
	private VisitationService visitService;

	@Autowired
	public PatientController(ModelMapper mapper, PatientService patientService, VisitationService visitService) {
		this.mapper = mapper;
		this.patientService = patientService;
		this.visitService = visitService;
	}

	@GetMapping
	public ModelAndView getAllUsers(ModelAndView mView) {
		List<PatientServiceModel> patients = this.patientService.findAll();
		mView.addObject("patients", patients);
		mView.setViewName("all-patients");
		return mView;
	}

	@GetMapping("/delete/{id}")
	public String removeUserById(@PathVariable("id") String id) {
		this.patientService.remove(id);
		return "redirect:/patients";
	}

	@GetMapping("/details/{id}")
	public ModelAndView getUserDetails(@PathVariable("id") String id, ModelAndView mView) {
		PatientServiceModel patient = this.patientService.findById(id);
		mView.addObject("patient", patient);
		mView.setViewName("patient-details");
		return mView;
	}

	@GetMapping("/register")
	public ModelAndView getPatientRegister(@ModelAttribute("patient") PatientModel patient, ModelAndView mView) {

		mView.setViewName("register");
		return mView;
	}

	@PostMapping("/register")
	public String postPatientRegister(@RequestParam("profileImg") MultipartFile profileImg,
			@ModelAttribute("patient") PatientModel patient) throws IOException {
		PatientServiceModel created = this.patientService.create(this.mapper.map(patient, PatientServiceModel.class));
		ImageManager.saveImage(profileImg, created.getId());
		return "redirect:/patients";
	}

	@GetMapping("/{id}/visitation")
	public ModelAndView getVisitPatient(@PathVariable("id") String id,
			@ModelAttribute("visitation") VisitationModel visitation, ModelAndView mView) {
		visitation.setDate(LocalDateTime.now());
		visitation.setPatient(this.patientService.findById(id));
		mView.setViewName("visitation-add");
		return mView;
	}

	@PostMapping("/{id}/visitation")
	public ModelAndView postVisitPatient(@PathVariable("id") String id,
			@ModelAttribute("visitation") VisitationModel visitation, ModelAndView mView) {
		System.out.println(
				visitation.getDescription() + " date " + visitation.getDate() + " " + visitation.getPatient().getId());
		this.visitService.create(this.mapper.map(visitation, VisitationServiceModel.class));
		mView.setViewName("redirect:/patients/details/" + id);
		return mView;
	}
}
