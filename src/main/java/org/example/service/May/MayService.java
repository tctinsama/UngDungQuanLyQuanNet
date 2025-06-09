package org.example.service.May;

import org.example.model.KhachHang;
import org.example.model.May;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MayService {
    List<May> findAll();
    Optional<May> findById(String id);
    May save(May may);
    May update(String id, May may);
    void deleteById(String id);
    Page<May> findAll(Pageable pageable);

    Page<May> search(String keyword, Pageable pageable);

}
