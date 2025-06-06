package org.example.service.ThongTinSuDung;

import org.example.dto.resp.ThongTinSuDungResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ThongTinSuDungService {
    Page<ThongTinSuDungResponse> getAllThongTin(Pageable pageable);
}
