package com.example.web_ban_sach_backend.repository;

import com.example.web_ban_sach_backend.model.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
}
