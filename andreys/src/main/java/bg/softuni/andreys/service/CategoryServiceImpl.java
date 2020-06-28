package bg.softuni.andreys.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.andreys.common.enums.CategoryType;
import bg.softuni.andreys.domain.service.CategoryServiceModel;
import bg.softuni.andreys.persistence.entities.JpaCategory;
import bg.softuni.andreys.persistence.repositories.CategoryRepository;
import bg.softuni.andreys.utils.CategoryToEntity;

@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository categoryRepo;
	private ModelMapper mapper;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepo, ModelMapper mapper) {
		this.categoryRepo = categoryRepo;
		this.mapper = mapper;
	}

	@Override
	public CategoryServiceModel findCategoryBy(CategoryType cat) {
		JpaCategory category = this.categoryRepo.findByCategoryType(cat).orElseThrow(() -> {
			return new EntityNotFoundException("A Category with this type does not exists");
		});
		return this.mapper.map(category, CategoryServiceModel.class);
	}

}
