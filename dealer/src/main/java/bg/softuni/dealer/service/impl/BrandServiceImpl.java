package bg.softuni.dealer.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.dealer.models.service.BrandServiceModel;
import bg.softuni.dealer.persistence.entities.JpaBrand;
import bg.softuni.dealer.persistence.repositories.BrandRepository;
import bg.softuni.dealer.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	private BrandRepository brandRepo;
	private ModelMapper mapper;

	@Autowired
	public BrandServiceImpl(BrandRepository brandRepo, ModelMapper mapper) {
		this.brandRepo = brandRepo;
		this.mapper = mapper;
	}

	@Override
	public BrandServiceModel createBrand(BrandServiceModel model) {

		JpaBrand toPersist = mapper.map(model, JpaBrand.class);
		toPersist.setModified(LocalDateTime.now());
		toPersist.setCreated(LocalDateTime.now());
		brandRepo.save(toPersist);
		return mapper.map(toPersist, BrandServiceModel.class);
	}

	@Override
	public List<BrandServiceModel> findAll() {
		return brandRepo.findAll().stream().map(b -> mapper.map(b, BrandServiceModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<String> findAllBrandsNames() {
		return this.findAll().stream().map(b -> b.getName()).collect(Collectors.toList());
	}

	@Override
	public BrandServiceModel findByName(String name) {
		return this.mapper.map(this.brandRepo.findByName(name),BrandServiceModel.class);
	}

}
