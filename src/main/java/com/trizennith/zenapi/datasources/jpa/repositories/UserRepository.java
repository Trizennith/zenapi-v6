package com.trizennith.zenapi.datasources.jpa.repositories;

import com.trizennith.zenapi.datasources.jpa.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>, BaseJpaRepository {
    Optional<User> findByEmail(String email);
}