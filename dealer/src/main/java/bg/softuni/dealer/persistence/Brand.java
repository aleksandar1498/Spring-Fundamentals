package bg.softuni.dealer.persistence;

import java.time.LocalDateTime;
import java.util.List;

public interface Brand {
	String getId();
	String getName();
	LocalDateTime getCreated();
	LocalDateTime getModified();
	List<Model> getModels();
}
