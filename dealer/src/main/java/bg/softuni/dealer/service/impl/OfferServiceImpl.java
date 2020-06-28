package bg.softuni.dealer.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.softuni.dealer.models.service.ModelServiceModel;
import bg.softuni.dealer.models.service.OfferServiceModel;
import bg.softuni.dealer.models.service.UserServiceModel;
import bg.softuni.dealer.persistence.entities.JpaModel;
import bg.softuni.dealer.persistence.entities.JpaOffer;
import bg.softuni.dealer.persistence.entities.JpaUser;
import bg.softuni.dealer.persistence.repositories.OfferRepository;
import bg.softuni.dealer.service.ModelService;
import bg.softuni.dealer.service.OfferService;
import bg.softuni.dealer.service.UserService;

@Service
public class OfferServiceImpl implements OfferService {
	private OfferRepository offerRepo;
	private UserService userService;
	private ModelService modelService;
	private ModelMapper mapper;

	@Autowired
	public OfferServiceImpl(OfferRepository offerRepo, UserService userService, ModelService modelService,
			ModelMapper mapper) {
		this.offerRepo = offerRepo;
		this.userService = userService;
		this.modelService = modelService;
		this.mapper = mapper;
	}

	@Override
	public OfferServiceModel create(OfferServiceModel offer) {
		ModelServiceModel model = this.modelService.findById(offer.getModel().getId());
		if (model == null) {
			throw new EntityNotFoundException("Model does not exists");
		}

		UserServiceModel user = this.userService.findById(offer.getSeller().getId());
		if (user == null) {
			throw new EntityNotFoundException("User does not exists");
		}
		JpaOffer offerToPersist = this.mapper.map(offer, JpaOffer.class);
		offerToPersist.setCreated(LocalDateTime.now());
		offerToPersist.setModified(LocalDateTime.now());
		offerToPersist.setModel(this.mapper.map(model, JpaModel.class));
		offerToPersist.setSeller(this.mapper.map(user, JpaUser.class));

		return this.mapper.map(offerRepo.saveAndFlush(offerToPersist), OfferServiceModel.class);
	}

	@Override
	public List<OfferServiceModel> findAll() {
		return this.offerRepo.findAll().stream().map(o -> this.mapper.map(o, OfferServiceModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public OfferServiceModel findById(String id) {

		return this.offerRepo.findById(id).map(o -> {
			if (o == null) {
				return null;
			}

			return mapper.map(o, OfferServiceModel.class);
		}).orElse(null);
	}

}
