package com.example.web_ban_sach_backend.repository;

import com.example.web_ban_sach_backend.model.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "hinh-thuc-thanh-toan")

public interface HinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan, Integer> {
}
