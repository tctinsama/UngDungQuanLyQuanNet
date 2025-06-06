package org.example.service.ThongTinSuDung;

import org.example.dto.resp.ThongTinSuDungResponse;
import org.example.repository.ThongTinSuDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThongTinSuDungServiceImpl implements ThongTinSuDungService {

    @Autowired
    private ThongTinSuDungRepository thongTinSuDungRepository;

    @Override
    public Page<ThongTinSuDungResponse> getAllThongTin(Pageable pageable) {
        Page<Object[]> page = thongTinSuDungRepository.getAllThongTin(pageable);
        List<ThongTinSuDungResponse> dtos = page.getContent().stream()
                .map(obj -> new ThongTinSuDungResponse(
                        (String) obj[0],
                        (String) obj[1],
                        (String) obj[2],
                        (String) obj[3],
                        (String) obj[4],
                        (String) obj[5],
                        (String) obj[6],
                        obj[7] != null ? ((Number) obj[7]).intValue() : null,
                        (String) obj[8],
                        (String) obj[9],
                        (String) obj[10],
                        obj[11] != null ? ((Number) obj[11]).intValue() : null,
                        obj[12] != null ? ((Number) obj[12]).longValue() : null
                ))
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }
}
