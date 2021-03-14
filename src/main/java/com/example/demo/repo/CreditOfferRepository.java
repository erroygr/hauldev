package com.example.demo.repo;

import com.example.demo.model.CreditOffer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface CreditOfferRepository extends CrudRepository<CreditOffer, Long> {
   /* @Query(value = "select * from CreditOffer inner join Client on (CreditOffer.id = Client.id)",
            nativeQuery=true)
    Collection<CreditOffer> findCreditOfferById();*/
}
