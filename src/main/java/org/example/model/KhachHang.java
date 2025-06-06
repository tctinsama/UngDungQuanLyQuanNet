package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "khachhang")
public class KhachHang {
    @Id
    @Column(name = "MaKH",length = 20)
    private String maKH;

    @Column(name = "TenKH", length = 20)
    private String tenKH;

    @Column(name = "SoDienThoai", length = 20)
    private String sodt;

    @Column(name = "DiaChiEmail", length = 20)
    private String dcEmail;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<SuDungDichVu> sudungdichvus;

    @OneToMany(mappedBy = "khachHang", cascade = CascadeType.ALL)
    private List<SuDungMay> sudungmays;

}
