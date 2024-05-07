package com.task.vasunamdevfliprinternshiptask.dao;

import com.task.vasunamdevfliprinternshiptask.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
    public Optional<Admin> findByAdminEmail(String adminEmail);
    public Admin findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Admin a WHERE a.adminEmail = ?1")
    boolean existsByadminEmail(String adminEmail);
}
