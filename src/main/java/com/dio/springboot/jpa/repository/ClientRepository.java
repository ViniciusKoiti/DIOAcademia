package com.dio.springboot.jpa.repository;

import com.dio.springboot.jpa.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
