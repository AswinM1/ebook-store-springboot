package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.loginentity.*;

public interface LoginRepo extends JpaRepository<LoginEntity,Integer>{

}