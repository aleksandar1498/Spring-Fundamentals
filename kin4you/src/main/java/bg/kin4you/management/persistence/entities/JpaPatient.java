package bg.kin4you.management.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import bg.kin4you.management.persistence.Patient;
import bg.kin4you.management.persistence.Visitation;


@Entity
@Table(name = "patients")
public class JpaPatient extends JpaUser implements Patient {
	
	@OneToMany(mappedBy = "patient",targetEntity = JpaVisitation.class,cascade = CascadeType.ALL)
	private List<Visitation> visitations;
	
	
	public JpaPatient() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Visitation> getVisitations() {
		return visitations;
	}

	public void setVisitations(List<Visitation> visitations) {
		this.visitations = visitations;
	}

	
	
	
	
	
}
