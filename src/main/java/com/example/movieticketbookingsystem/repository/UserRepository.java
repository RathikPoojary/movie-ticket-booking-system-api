package com.example.movieticketbookingsystem.repository;

import com.example.movieticketbookingsystem.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDetails,String> {

    boolean existsByEmail(String email);
}
