package com.dio.springboot.jpa.repository;

import com.dio.springboot.jpa.entity.UserPersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPersonRepository extends JpaRepository<UserPersonDetails, Long> {

    Optional<UserPersonDetails> findByUsername(String username);
}
