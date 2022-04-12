package com.testweb.controllers;

import com.testweb.entity.Supplier;
import com.testweb.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public String welcome(Model model) {

        String messages = "Welcome Home Bestie";
        model.addAttribute("msg", messages);
        // model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("categories", supplierService.findAll());

        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("supplier", new Supplier());
        return "add";
    }

    @PostMapping(value = "/save")
    public String save(Supplier supplier) {
        supplierService.addSupplier(supplier);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        supplierService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("supplier", supplierService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String update(Supplier supplier) {
        supplierService.updateSupplier(supplier);

        return "redirect:/";
    }

}
