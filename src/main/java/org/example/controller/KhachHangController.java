package org.example.controller;

import org.example.model.KhachHang;
import org.example.service.KhachHang.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Controller
@RequestMapping("/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachHangService;

    // Show form create
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("khachhang", new KhachHang());
        return "khachhang/KhachHangCreate";
    }

    // Handle create
    @PostMapping("/save")
    public String save(@ModelAttribute("khachhang") KhachHang khachHang) {
        khachHangService.save(khachHang);
        return "redirect:/khachhang";
    }

    // Show form edit
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Optional<KhachHang> kh = khachHangService.findById(id);
        if (kh.isPresent()) {
            model.addAttribute("khachhang", kh.get());
            return "khachhang/KhachHangEdit";
        } else {
            return "redirect:/khachhang";
        }
    }

    // Handle update
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, @ModelAttribute("khachhang") KhachHang khachHang) {
        khachHangService.update(id, khachHang);
        return "redirect:/khachhang";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        khachHangService.deleteById(id);
        return "redirect:/khachhang";
    }

    //page
    @GetMapping
    public String listKhachHang(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(name = "keyword", required = false) String keyword,
            Model model) {

        Page<KhachHang> khPage;
        if (keyword != null && !keyword.isEmpty()) {
            khPage = khachHangService.search(keyword, PageRequest.of(page - 1, size));
            model.addAttribute("keyword", keyword);
        } else {
            khPage = khachHangService.findAll(PageRequest.of(page - 1, size));
        }
        model.addAttribute("khachhangPage", khPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", khPage.getTotalPages());
        model.addAttribute("pageSize", size);
        return "khachhang/KhachHangList";
    }
}
