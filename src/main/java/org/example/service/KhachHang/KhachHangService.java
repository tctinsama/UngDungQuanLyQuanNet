package org.example.service.KhachHang;

import org.example.model.KhachHang;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface KhachHangService {
    List<KhachHang> findAll();
    Optional<KhachHang> findById(String id);
    KhachHang save(KhachHang khachHang);
    KhachHang update(String id, KhachHang khachHang);
    void deleteById(String id);

    Page<KhachHang> findAll(Pageable pageable);

}
