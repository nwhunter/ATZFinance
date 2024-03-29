package com.example.atz.repository;

import com.example.atz.model.Application;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

}