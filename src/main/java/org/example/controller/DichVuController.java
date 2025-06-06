package org.example.controller;


import org.example.model.DichVu;
import org.example.service.DichVu.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/dichvu")
public class DichVuController {
    @Autowired
    private DichVuService dichVuService;

    // Show form create
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("dichvu", new DichVu());
        return "dichvu/DichVuCreate";
    }

    // Handle create
    @PostMapping("/save")
    public String save(@ModelAttribute("dichvu") DichVu dichVu) {
        dichVuService.save(dichVu);
        return "redirect:/dichvu";
    }

    // Show form edit
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Optional<DichVu> kh = dichVuService.findById(id);
        if (kh.isPresent()) {
            model.addAttribute("dichvu", kh.get());
            return "dichvu/DichVuEdit";
        } else {
            return "redirect:/dichvu";
        }
    }

    // Handle update
    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") String id, @ModelAttribute("dichvu") DichVu dichVu) {
        dichVuService.update(id, dichVu);
        return "redirect:/dichvu";
    }

    // Delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
        dichVuService.deleteById(id);
        return "redirect:/dichvu";
    }

    //page
    @GetMapping
    public String listDichVu(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        Page<DichVu> dvPage = dichVuService.findAll(PageRequest.of(page - 1, size));
        model.addAttribute("dichvuPage", dvPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", dvPage.getTotalPages());
        model.addAttribute("pageSize", size);
        return "dichvu/DichVuList";
    }
}
