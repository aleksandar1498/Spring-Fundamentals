package bg.kin4you.management.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import bg.kin4you.management.persistence.Employee;
import bg.kin4you.management.persistence.Patient;

public class JpaEmployee extends JpaUser implements Employee {
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = JpaPatient.class,fetch = FetchType.LAZY)
	private List<Patient> patients;
	
	public JpaEmployee() {
		// TODO Auto-generated constructor stub
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	
}
