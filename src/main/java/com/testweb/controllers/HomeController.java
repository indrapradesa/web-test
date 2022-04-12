package com.testweb.controllers;

import com.testweb.dto.SearchFormData;
import com.testweb.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String welcome(Model model) {

        String messages = "Welcome Home Bestie";
        model.addAttribute("msg", messages);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("products", productService.findAll());

        return "index";
    }

    @PostMapping("/search")
    public String search(SearchFormData searchFormData, Model model) {
        String messages = "Welcome Home Bestie";
        model.addAttribute("msg", messages);
        model.addAttribute("searchForm", searchFormData);
        model.addAttribute("products", productService.findByName(searchFormData.getKeyword()));
        return "index";
    }

}
