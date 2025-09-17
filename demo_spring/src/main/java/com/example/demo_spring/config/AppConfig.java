package com.example.demo_spring.config;

import com.example.demo_spring.repository.IStudentRepository;
import com.example.demo_spring.repository.StudentRepository;
import com.example.demo_spring.service.IStudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public StudentRepository studentRepository() {
        return new StudentRepository();
    }
}
