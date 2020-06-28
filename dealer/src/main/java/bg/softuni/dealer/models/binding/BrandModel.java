package bg.softuni.dealer.models.binding;

public class BrandModel {
	private String name;
	private String id;
	public BrandModel() {
	
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BrandModel [name=" + name + ", id=" + id + "]";
	}

	

}
