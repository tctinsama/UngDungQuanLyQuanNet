package org.example.controller;

import org.example.model.SuDungMay;
import org.example.service.KhachHang.KhachHangService;
import org.example.service.May.MayService;
import org.example.service.SuDungMay.SuDungMayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sudungmay")
public class SuDungMayController {
    @Autowired
    private SuDungMayService suDungMayService;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private MayService mayService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("suDungMay", new SuDungMay());
        model.addAttribute("khachHangs", khachHangService.findAll());
        model.addAttribute("mays", mayService.findAll());
        return "sudungmay/SuDungMayCreate";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("suDungMay") SuDungMay suDungMay) {
        suDungMayService.save(suDungMay);
        return "redirect:/sudungmay/create?success";
    }
}
