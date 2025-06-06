package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "may")
public class May {
    @Id
    @Column(name = "MaMay", length = 20)
    private String maMay;

    @Column(name = "ViTri", length = 20)
    private String viTri;

    @Column(name = "TrangThai", length = 20)
    private String trangThai;

    @OneToMany(mappedBy = "may", cascade = CascadeType.ALL)
    private List<SuDungMay> sudungmays;

}
