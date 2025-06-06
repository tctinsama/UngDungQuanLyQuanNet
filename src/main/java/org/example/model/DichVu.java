package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "dichvu")
public class DichVu {
    @Id
    @Column(name = "MaDV", length = 20)
    private String maDV;

    @Column(name = "TenDV", length = 20)
    private String tenDV;

    @Column(name = "DonViTinh", length = 20)
    private String dvTinh;

    @Column(name = "DonGia", length = 20)
    private Long donGia;

    @OneToMany(mappedBy = "dichVu", cascade = CascadeType.ALL)
    private List<SuDungDichVu> sudungdichvus;

}
