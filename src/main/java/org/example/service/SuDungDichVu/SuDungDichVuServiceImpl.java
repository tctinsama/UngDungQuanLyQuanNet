package org.example.service.SuDungDichVu;

import org.example.model.SuDungDichVu;
import org.example.repository.SuDungDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuDungDichVuServiceImpl implements SuDungDichVuService {
    @Autowired
    private SuDungDichVuRepository repo;

    @Override
    public List<SuDungDichVu> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<SuDungDichVu> findById(SuDungDichVu.SuDungDichVuId id) {
        return repo.findById(id);
    }

    @Override
    public SuDungDichVu save(SuDungDichVu suDungDichVu) {
        return repo.save(suDungDichVu);
    }

    @Override
    public SuDungDichVu update(SuDungDichVu.SuDungDichVuId id, SuDungDichVu suDungDichVu) {
        if (repo.existsById(id)) {
            suDungDichVu.setId(id);
            return repo.save(suDungDichVu);
        } else {
            throw new RuntimeException("SuDungDichVu not found!");
        }
    }

    @Override
    public void deleteById(SuDungDichVu.SuDungDichVuId id) {
        repo.deleteById(id);
    }
}
