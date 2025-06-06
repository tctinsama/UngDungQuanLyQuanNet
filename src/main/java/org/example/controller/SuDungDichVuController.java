package org.example.controller;

import org.example.model.SuDungDichVu;
import org.example.service.KhachHang.KhachHangService;
import org.example.service.DichVu.DichVuService;
import org.example.service.SuDungDichVu.SuDungDichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sudungdichvu")
public class SuDungDichVuController {
    @Autowired
    private SuDungDichVuService suDungDichVuService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private DichVuService dichVuService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("suDungDichVu", new SuDungDichVu());
        model.addAttribute("khachHangs", khachHangService.findAll());
        model.addAttribute("dichVus", dichVuService.findAll());
        return "sudungdichvu/SuDungDichVuCreate";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("suDungDichVu") SuDungDichVu suDungDichVu) {
        suDungDichVuService.save(suDungDichVu);
        return "redirect:/sudungdichvu/create?success";
    }
}
