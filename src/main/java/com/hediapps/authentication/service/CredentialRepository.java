package com.hediapps.authentication.service;

import com.hediapps.authentication.model.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CredentialRepository extends PagingAndSortingRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
