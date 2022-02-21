package com.example.makedeveloper_fastcampus.repository;

import com.example.makedeveloper_fastcampus.entity.Developer;
import com.example.makedeveloper_fastcampus.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiredDeveloperRepository extends JpaRepository<RetiredDeveloper, Long> {
}
