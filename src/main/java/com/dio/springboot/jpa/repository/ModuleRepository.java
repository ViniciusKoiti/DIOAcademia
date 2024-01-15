package com.dio.springboot.jpa.repository;

import com.dio.springboot.jpa.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Long> {
}
