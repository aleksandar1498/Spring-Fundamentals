package bg.softuni.dealer.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.dealer.common.exceptions.BrandNotFoundException;
import bg.softuni.dealer.common.exceptions.ErrorMessages;
import bg.softuni.dealer.models.service.BrandServiceModel;
import bg.softuni.dealer.models.service.ModelServiceModel;
import bg.softuni.dealer.persistence.entities.JpaBrand;
import bg.softuni.dealer.persistence.entities.JpaModel;
import bg.softuni.dealer.persistence.repositories.BrandRepository;
import bg.softuni.dealer.persistence.repositories.ModelRepository;
import bg.softuni.dealer.service.BrandService;
import bg.softuni.dealer.service.ModelService;

@Service
public class ModelServiceImpl implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapper mapper;
	private BrandService brandService;

	@Autowired
	public ModelServiceImpl(ModelRepository modelRepository, ModelMapper mapper, BrandService brandService) {
		this.modelRepository = modelRepository;
		this.mapper = mapper;
		this.brandService = brandService;
	}

	@Override
	public ModelServiceModel createModel(ModelServiceModel model) {
		System.out.println(model.toString());
		BrandServiceModel brand = this.brandService.findByName(model.getBrand().getName());
		if (brand == null) {
			throw new BrandNotFoundException(ErrorMessages.BRAND_NOT_FOUND_BY_NAME.toString());
		}
		JpaModel modelToPersist = this.mapper.map(model, JpaModel.class);
		modelToPersist.setCreated(LocalDateTime.now());
		modelToPersist.setModified(LocalDateTime.now());
		modelToPersist.setBrand(mapper.map(brand, JpaBrand.class));
		System.out.println(modelToPersist.toString());
		return this.mapper.map(this.modelRepository.save(modelToPersist), ModelServiceModel.class);
	}

	@Override
	public List<ModelServiceModel> findAllModels() {
		return this.modelRepository.findAll().stream().map(m -> {
			ModelServiceModel model = this.mapper.map(m, ModelServiceModel.class);
			model.setBrand(this.mapper.map(m.getBrand(), BrandServiceModel.class));
			return model;
		}).collect(Collectors.toList());
	}

	@Override
	public ModelServiceModel findById(String id) {
		return this.modelRepository.findById(id).map(m -> {
			if (m == null) {
				return null;
			}
			return this.mapper.map(m, ModelServiceModel.class);
		}).orElse(null);
	}

}
