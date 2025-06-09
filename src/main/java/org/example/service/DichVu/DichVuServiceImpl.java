package org.example.service.DichVu;

import org.example.model.DichVu;
import org.example.model.KhachHang;
import org.example.repository.DichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DichVuServiceImpl implements DichVuService {
    @Autowired
    private DichVuRepository repo;

    @Override
    public List<DichVu> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<DichVu> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public DichVu save(DichVu dichVu) {
        return repo.save(dichVu);
    }

    @Override
    public DichVu update(String id, DichVu dichVu) {
        if (repo.existsById(id)) {
            dichVu.setMaDV(id);
            return repo.save(dichVu);
        } else {
            throw new RuntimeException("DichVu not found!");
        }
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }

    @Override
    public Page<DichVu> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Page<DichVu> search(String keyword, Pageable pageable) {
        return repo.findByMaDVContainingOrTenDVContaining(keyword, keyword, pageable);
    }

}
