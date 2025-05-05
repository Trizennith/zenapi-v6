package com.trizennith.zenapi.datasources.jpa.repositories;

import com.trizennith.zenapi.datasources.jpa.entities.Sessions;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SessionsRepository extends CrudRepository<Sessions, Long> {
    List<Sessions> findByUserId(Integer userId);
}
