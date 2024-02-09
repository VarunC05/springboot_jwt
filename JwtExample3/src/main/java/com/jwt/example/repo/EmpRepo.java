package com.jwt.example.repo;

import com.jwt.example.models.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Emp, Integer> {
}
