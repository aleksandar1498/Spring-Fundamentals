package bg.kin4you.management.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import bg.kin4you.management.persistence.Admin;

@Entity
@Table(name = "admin")
public class JpaAdmin extends JpaUser implements Admin {
	public JpaAdmin() {
		// TODO Auto-generated constructor stub
	}
}
