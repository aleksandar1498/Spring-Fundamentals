package bg.softuni.dealer.service;

import java.util.List;

import bg.softuni.dealer.models.service.BrandServiceModel;
import bg.softuni.dealer.persistence.entities.JpaBrand;

public interface BrandService {
	BrandServiceModel createBrand(BrandServiceModel model);
	List<BrandServiceModel> findAll();
	List<String> findAllBrandsNames();
	BrandServiceModel findByName(String name);
}
