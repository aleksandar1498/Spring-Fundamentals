package bg.kin4you.management.persistence;

import java.util.List;

public interface Patient {
	List<Visitation> getVisitations();
}
