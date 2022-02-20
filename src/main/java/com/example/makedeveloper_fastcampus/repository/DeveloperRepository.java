package com.example.makedeveloper_fastcampus.repository;

import com.example.makedeveloper_fastcampus.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
