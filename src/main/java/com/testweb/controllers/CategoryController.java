package com.testweb.controllers;

import com.testweb.dto.SearchFormData;
import com.testweb.entity.Category;
import com.testweb.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String category(Model model) {

        // String messages = "Welcome Home Bestie";
        // model.addAttribute("msg", messages);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("categories", categoryService.findAll());

        return "category/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping(value = "/save")
    public String save(Category category) {
        categoryService.addCategory(category);

        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        categoryService.deleteById(id);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("category", categoryService.findById(id));
        return "category/update";
    }

    @PostMapping(value = "/update")
    public String update(Category category) {
        categoryService.updateCategory(category);

        return "redirect:/category";
    }

}
