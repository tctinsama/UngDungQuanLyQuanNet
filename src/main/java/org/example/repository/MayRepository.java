package org.example.repository;

import org.example.model.May;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MayRepository extends JpaRepository<May, String> {

    Page<May> findByMaMayContaining(String maMay, Pageable pageable);

}
