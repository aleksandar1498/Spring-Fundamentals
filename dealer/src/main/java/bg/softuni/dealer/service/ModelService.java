package bg.softuni.dealer.service;

import java.util.List;

import bg.softuni.dealer.models.service.ModelServiceModel;
import bg.softuni.dealer.persistence.entities.JpaModel;

public interface ModelService {

	ModelServiceModel createModel(ModelServiceModel map);

	List<ModelServiceModel> findAllModels();

	ModelServiceModel findById(String id);

}
