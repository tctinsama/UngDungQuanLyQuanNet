package org.example.service.May;

import org.example.model.May;
import org.example.repository.MayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MayServiceImpl implements MayService {
    @Autowired
    private MayRepository repo;

    @Override
    public List<May> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<May> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public May save(May may) {
        return repo.save(may);
    }

    @Override
    public May update(String id, May may) {
        if (repo.existsById(id)) {
            may.setMaMay(id);
            return repo.save(may);
        } else {
            throw new RuntimeException("May not found!");
        }
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }


    @Override
    public Page<May> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
