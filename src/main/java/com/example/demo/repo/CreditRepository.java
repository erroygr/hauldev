package com.example.demo.repo;

import com.example.demo.model.Client;
import com.example.demo.model.Credit;
import org.springframework.data.repository.CrudRepository;

public interface CreditRepository  extends CrudRepository<Credit, Long> {
    public Credit findByCreditLimit(float creditLimit);
}
