package com.example.web_ban_sach_backend.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.Set;

@Configuration
public class MyRepositoryRestConfigurer implements RepositoryRestConfigurer {
// Phần này để hiển thị id khi test postman Start
    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(
            RepositoryRestConfiguration config, CorsRegistry cors) {
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        Class<?>[] entityClasses = entities.stream()
                .map(EntityType::getJavaType)
                .toArray(Class<?>[]::new);
        config.exposeIdsFor(entityClasses);
    }
    // Phần này để hiển thị id khi test postman End

}
