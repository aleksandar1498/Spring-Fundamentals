package bg.softuni.dealer.models.view;

import java.util.List;

import bg.softuni.dealer.models.binding.OfferModel;

public class AllOffersViewModel {
	private List<OfferModel> offers;

	public AllOffersViewModel() {
	}
	public AllOffersViewModel(List<OfferModel> offers) {
		this.offers = offers;
	}
	public List<OfferModel> getOffers() {
		return offers;
	}
	public void setOffers(List<OfferModel> offers) {
		this.offers = offers;
	}
	
	
}
