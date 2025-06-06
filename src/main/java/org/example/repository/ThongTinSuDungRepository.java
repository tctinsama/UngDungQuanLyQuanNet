package org.example.repository;

import org.example.model.SuDungMay; // import một entity thực sự!
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThongTinSuDungRepository extends JpaRepository<SuDungMay, Long> {
    @Query(
            value = "SELECT kh.makh, kh.tenkh, m.ma_may, m.vi_tri, m.trang_thai, " +
                    "sm.ngay_bat_dau_su_dung, sm.gio_bat_dau_su_dung, sm.thoi_gian_su_dung, " +
                    "dv.madv, sdv.ngay_su_dung, sdv.gio_su_dung, sdv.so_luong, tong.tong_tien " +
                    "FROM khachhang kh " +
                    "JOIN sudungmay sm ON kh.makh = sm.makh " +
                    "JOIN may m ON sm.ma_may = m.ma_may " +
                    "LEFT JOIN sudungdichvu sdv ON kh.makh = sdv.makh " +
                    "LEFT JOIN dichvu dv ON sdv.madv = dv.madv " +
                    "LEFT JOIN ( " +
                    "   SELECT sdv2.makh, SUM(sdv2.so_luong * dv2.don_gia) AS tong_tien " +
                    "   FROM sudungdichvu sdv2 " +
                    "   JOIN dichvu dv2 ON sdv2.madv = dv2.madv " +
                    "   GROUP BY sdv2.makh " +
                    ") tong ON kh.makh = tong.makh " +
                    "ORDER BY kh.makh, m.ma_may, dv.madv ",
            countQuery = "SELECT COUNT(*) FROM khachhang",
            nativeQuery = true
    )
    Page<Object[]> getAllThongTin(Pageable pageable);

}
