package com.example.btvalidation.repository;

import com.example.btvalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}