package bg.kin4you.management.model.service;

import java.util.List;


public class PatientServiceModel {
	private String id;

	private String firstName;

	private String lastName;
	
	private List<VisitationServiceModel> visitations;

	public PatientServiceModel() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<VisitationServiceModel> getVisitations() {
		return visitations;
	}

	public void setVisitations(List<VisitationServiceModel> visitations) {
		this.visitations = visitations;
	}

	@Override
	public String toString() {
		return "PatientServiceModel [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", visitations=" + visitations + "]";
	}

	
	
	

}
