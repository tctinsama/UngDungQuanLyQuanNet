package org.example.service.SuDungMay;

import org.example.model.SuDungMay;
import java.util.List;
import java.util.Optional;

public interface SuDungMayService {
    List<SuDungMay> findAll();
    Optional<SuDungMay> findById(SuDungMay.SuDungMayId id);
    SuDungMay save(SuDungMay suDungMay);
    SuDungMay update(SuDungMay.SuDungMayId id, SuDungMay suDungMay);
    void deleteById(SuDungMay.SuDungMayId id);
}
