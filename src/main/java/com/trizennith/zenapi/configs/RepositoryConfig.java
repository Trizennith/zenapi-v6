package com.trizennith.zenapi.configs;

import com.trizennith.zenapi.datasources.jdbc.repositories.BaseJdbcRepository;
import com.trizennith.zenapi.datasources.jpa.repositories.BaseJpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = BaseJpaRepository.class)
@EnableJdbcRepositories(basePackageClasses = BaseJdbcRepository.class)
public class RepositoryConfig {
}
