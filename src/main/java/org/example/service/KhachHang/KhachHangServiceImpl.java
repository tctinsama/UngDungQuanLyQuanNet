package org.example.service.KhachHang;

import org.example.model.KhachHang;
import org.example.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository repo;

    @Override
    public List<KhachHang> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<KhachHang> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public KhachHang save(KhachHang khachHang) {
        return repo.save(khachHang);
    }

    @Override
    public KhachHang update(String id, KhachHang khachHang) {
        if (repo.existsById(id)) {
            khachHang.setMaKH(id); // Đảm bảo đúng ID
            return repo.save(khachHang);
        } else {
            throw new RuntimeException("KhachHang not found!");
        }
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }

    @Override
    public Page<KhachHang> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Page<KhachHang> search(String keyword, Pageable pageable) {
        return repo.findByMaKHContainingOrTenKHContaining(keyword, keyword, pageable);
    }
}

