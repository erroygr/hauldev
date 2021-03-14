package com.example.demo.repo;

import com.example.demo.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    public Client findByFIO(String fio);
}
