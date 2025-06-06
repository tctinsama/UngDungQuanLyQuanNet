package org.example.service.SuDungMay;

import org.example.model.SuDungMay;
import org.example.repository.SuDungMayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuDungMayServiceImpl implements SuDungMayService {
    @Autowired
    private SuDungMayRepository repo;

    @Override
    public List<SuDungMay> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<SuDungMay> findById(SuDungMay.SuDungMayId id) {
        return repo.findById(id);
    }

    @Override
    public SuDungMay save(SuDungMay suDungMay) {
        return repo.save(suDungMay);
    }

    @Override
    public SuDungMay update(SuDungMay.SuDungMayId id, SuDungMay suDungMay) {
        if (repo.existsById(id)) {
            suDungMay.setId(id);
            return repo.save(suDungMay);
        } else {
            throw new RuntimeException("SuDungMay not found!");
        }
    }

    @Override
    public void deleteById(SuDungMay.SuDungMayId id) {
        repo.deleteById(id);
    }
}
