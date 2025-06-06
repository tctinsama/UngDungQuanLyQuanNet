package org.example.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ThongTinSuDungResponse {
    private String maKH;
    private String tenKH;
    private String maMay;
    private String viTri;
    private String trangThai;
    private String ngayBatDauSuDungMay;
    private String gioBatDauSuDungMay;
    private Integer thoiGianSuDungMay;
    private String maDV;
    private String ngaySuDungDV;
    private String gioSuDungDV;
    private Integer soLuong;
    private Long tongTien;
}
