package bg.kin4you.management.model.binding;

import java.time.LocalDateTime;

import bg.kin4you.management.model.service.PatientServiceModel;

public class VisitationModel {
	private LocalDateTime date;
	private String description;
	private PatientServiceModel patient;

	public VisitationModel() {
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
