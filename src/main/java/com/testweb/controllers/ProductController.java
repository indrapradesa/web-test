package com.testweb.controllers;

import com.testweb.dto.SearchFormData;
import com.testweb.entity.Product;
import com.testweb.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String welcome(Model model) {

        // String messages = "Welcome Home Bestie";
        // model.addAttribute("msg", messages);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("products", productService.findAll());

        return "product/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("searchForm", new SearchFormData());
        return "product/add";
    }

    @PostMapping(value = "/save")
    public String save(Product product) {
        productService.addProduct(product);

        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("searchForm", new SearchFormData());
        return "product/edit";
    }

    @PostMapping(value = "/update")
    public String update(Product product) {
        productService.updateProduct(product);

        return "redirect:/product";
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
