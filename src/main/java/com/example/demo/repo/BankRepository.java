package com.example.demo.repo;

import com.example.demo.model.Bank;
import com.example.demo.model.Credit;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<Bank, Long>  {
}
