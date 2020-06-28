package bg.softuni.dealer.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.dealer.persistence.entities.JpaOffer;

@Repository
public interface OfferRepository extends JpaRepository<JpaOffer, String> {

}
