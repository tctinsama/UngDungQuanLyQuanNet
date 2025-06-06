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
@Table(name = "sudungmay")
public class SuDungMay {

    @EmbeddedId
    private SuDungMayId id;

    @Column(name = "ThoiGianSuDung",length = 20)
    private Integer thoiGianSuDung;

    @ManyToOne
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH", insertable = false, updatable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "MaMay", referencedColumnName = "MaMay", insertable = false, updatable = false)
    private May may;

    // Inner static class cho khóa chính phức hợp
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class SuDungMayId implements Serializable {
        @Column(name = "MaKH")
        private String maKH;

        @Column(name = "MaMay", length = 20)
        private String maMay;

        @Column(name = "NgayBatDauSuDung", length = 20)
        private String ngayBatDauSuDung;

        @Column(name = "GioBatDauSuDung", length = 20)
        private String gioBatDauSuDung;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SuDungMayId)) return false;
            SuDungMayId that = (SuDungMayId) o;
            return Objects.equals(maKH, that.maKH)
                    && Objects.equals(maMay, that.maMay)
                    && Objects.equals(ngayBatDauSuDung, that.ngayBatDauSuDung)
                    && Objects.equals(gioBatDauSuDung, that.gioBatDauSuDung);
        }

        @Override
        public int hashCode() {
            return Objects.hash(maKH, maMay, ngayBatDauSuDung, gioBatDauSuDung);
        }
    }
}
