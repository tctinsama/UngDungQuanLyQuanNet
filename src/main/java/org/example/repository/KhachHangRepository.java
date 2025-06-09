package org.example.repository;

import org.example.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

    Page<KhachHang> findByMaKHContainingOrTenKHContaining(String maKH, String tenKH, Pageable pageable);
}
