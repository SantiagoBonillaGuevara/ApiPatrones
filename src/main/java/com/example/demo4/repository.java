package com.example.demo4;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<UserEntity, Long> {
    
} 
