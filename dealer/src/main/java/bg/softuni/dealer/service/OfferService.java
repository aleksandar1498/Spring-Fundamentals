package bg.softuni.dealer.service;

import java.util.List;

import bg.softuni.dealer.models.binding.OfferModel;
import bg.softuni.dealer.models.service.OfferServiceModel;
import bg.softuni.dealer.models.view.OfferViewModel;

public interface OfferService {
	OfferServiceModel create(OfferServiceModel offer);

	List<OfferServiceModel> findAll();

	OfferServiceModel findById(String id);
}
