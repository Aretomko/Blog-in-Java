package com.example.sweater.repos;

import com.example.sweater.domain.Front;
import com.example.sweater.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepo  extends JpaRepository<Module, Long> {
    List<Module> findByFront (Front front);
    Module findAllById (Long id);
    void deleteAllByFront (Front front);
}