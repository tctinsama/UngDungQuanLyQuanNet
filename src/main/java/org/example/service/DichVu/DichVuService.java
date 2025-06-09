package org.example.service.DichVu;

import org.example.model.DichVu;
import org.example.model.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DichVuService {
    List<DichVu> findAll();
    Optional<DichVu> findById(String id);
    DichVu save(DichVu dichVu);
    DichVu update(String id, DichVu dichVu);
    void deleteById(String id);

    Page<DichVu> findAll(Pageable pageable);

    Page<DichVu> search(String keyword, Pageable pageable);
}
