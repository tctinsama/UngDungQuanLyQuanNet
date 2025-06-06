package org.example.service.SuDungDichVu;

import org.example.model.SuDungDichVu;
import java.util.List;
import java.util.Optional;

public interface SuDungDichVuService {
    List<SuDungDichVu> findAll();
    Optional<SuDungDichVu> findById(SuDungDichVu.SuDungDichVuId id);
    SuDungDichVu save(SuDungDichVu suDungDichVu);
    SuDungDichVu update(SuDungDichVu.SuDungDichVuId id, SuDungDichVu suDungDichVu);
    void deleteById(SuDungDichVu.SuDungDichVuId id);
}
