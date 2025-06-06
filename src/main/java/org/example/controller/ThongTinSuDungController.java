package org.example.controller;

import org.example.dto.resp.ThongTinSuDungResponse;
import org.example.service.ThongTinSuDung.ThongTinSuDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThongTinSuDungController {

    @Autowired
    private ThongTinSuDungService thongTinSuDungService;

    @GetMapping("/thongtinsd")
    public String thongTinSuDung(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model
    ) {
        Page<ThongTinSuDungResponse> thongTinPage = thongTinSuDungService.getAllThongTin(PageRequest.of(page - 1, size));
        model.addAttribute("thongTinPage", thongTinPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", thongTinPage.getTotalPages());
        model.addAttribute("pageSize", size);
        return "thongtinsudung/thongtinsudung";
    }
}
