package bg.kin4you.management.model.service;

import java.time.LocalDateTime;

public class VisitationServiceModel {
	private String id;
	private PatientServiceModel patient;
	private LocalDateTime date;
	private String description;
	
	public VisitationServiceModel() {
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PatientServiceModel getPatient() {
		return patient;
	}
	public void setPatient(PatientServiceModel patient) {
		this.patient = patient;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
