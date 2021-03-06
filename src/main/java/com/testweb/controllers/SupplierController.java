package com.testweb.controllers;

import com.testweb.dto.SearchFormData;
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
    public String supplier(Model model) {

        // String messages = "Welcome Home Bestie";
        // model.addAttribute("msg", messages);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("suppliers", supplierService.findAll());

        return "supplier/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("supplier", new Supplier());
        return "supplier/add";
    }

    @PostMapping(value = "/save")
    public String save(Supplier supplier) {
        supplierService.addSupplier(supplier);

        return "redirect:/supplier";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        supplierService.deleteById(id);
        return "redirect:/supplier";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("supplier", supplierService.findById(id));
        return "supplier/update";
    }

    @PostMapping(value = "/update")
    public String update(Supplier supplier) {
        supplierService.updateSupplier(supplier);

        return "redirect:/supplier";
    }

}
