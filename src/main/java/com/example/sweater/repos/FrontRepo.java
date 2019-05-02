package com.example.sweater.repos;

import com.example.sweater.domain.Front;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FrontRepo extends JpaRepository<Front, Long> {
    List<Front> findByStatus (String status);
    Front findAllById (Long id);
    List<Front> findByTechnology (String Technology);
    List<Front> findByOrderNumber (Integer orderNumber);
    List<Front> findByHeading (@Param("heading") String heading);
}
