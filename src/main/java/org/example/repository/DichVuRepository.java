package org.example.repository;

import org.example.model.DichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DichVuRepository extends JpaRepository<DichVu, String> {

    Page<DichVu> findByMaDVContainingOrTenDVContaining(String maDV, String tenDV, Pageable pageable);
}
