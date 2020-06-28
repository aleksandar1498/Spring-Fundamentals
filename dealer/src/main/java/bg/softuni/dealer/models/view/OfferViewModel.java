package bg.softuni.dealer.models.view;

import bg.softuni.dealer.common.enums.EngineType;
import bg.softuni.dealer.models.binding.BrandModel;
import bg.softuni.dealer.models.binding.ModelModel;
import bg.softuni.dealer.models.binding.SellerModel;

public class OfferViewModel {
	private ModelModel model;
	private Integer year;
	private EngineType engine;
	private String id;
	private String imageUrl;
	private SellerModel seller;
	
	public OfferViewModel() {
		// TODO Auto-generated constructor stub
	}

	
	public ModelModel getModel() {
		return model;
	}

	public void setModel(ModelModel model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public EngineType getEngine() {
		return engine;
	}

	public void setEngine(EngineType engine) {
		this.engine = engine;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public SellerModel getSeller() {
		return seller;
	}


	public void setSeller(SellerModel seller) {
		this.seller = seller;
	}

	

	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public String toString() {
		return "OfferViewModel [model=" + model + ", year=" + year + ", engine=" + engine + ", id=" + id + ", seller="
				+ seller + "]";
	}
	
	
}
