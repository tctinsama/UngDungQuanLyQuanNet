package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sudungdichvu")
public class SuDungDichVu {

    @EmbeddedId
    private SuDungDichVuId id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH", insertable = false, updatable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MaDV", referencedColumnName = "MaDV", insertable = false, updatable = false)
    private DichVu dichVu;

    // Inner static class cho khóa chính phức hợp
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class SuDungDichVuId implements Serializable {
        @Column(name = "MaKH",length = 20)
        private String maKH;

        @Column(name = "MaDV",length = 20)
        private String maDV;

        @Column(name = "NgaySuDung",length = 20)
        private String ngaySuDung;

        @Column(name = "GioSuDung",length = 20)
        private String gioSuDung;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SuDungDichVuId)) return false;
            SuDungDichVuId that = (SuDungDichVuId) o;
            return Objects.equals(maKH, that.maKH)
                    && Objects.equals(maDV, that.maDV)
                    && Objects.equals(ngaySuDung, that.ngaySuDung)
                    && Objects.equals(gioSuDung, that.gioSuDung);
        }

        @Override
        public int hashCode() {
            return Objects.hash(maKH, maDV, ngaySuDung, gioSuDung);
        }
    }
}
