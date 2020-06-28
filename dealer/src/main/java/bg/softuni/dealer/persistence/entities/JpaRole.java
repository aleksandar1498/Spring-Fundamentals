package bg.softuni.dealer.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import bg.softuni.dealer.common.enums.RoleType;
import bg.softuni.dealer.persistence.Role;

@Entity
@Table(name = "roles")
public class JpaRole extends BaseEntity implements Role {

	@Enumerated(EnumType.STRING)
	private RoleType role;

	public JpaRole() {
	}
	
	public void setRole(RoleType role) {
		this.role = role;
	}


	@Override
	public RoleType getRole() {
		return role;
	}

}
