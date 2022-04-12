package com.testweb.controllers;

import com.testweb.dto.SearchFormData;
import com.testweb.entity.User;
import com.testweb.repo.UserRepo;
import com.testweb.service.ProductService;
import com.testweb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    private ProductService productService;

    @GetMapping
    public String welcome(Model model) {

        // String messages = "Welcome Home Bestie";
        // model.addAttribute("msg", messages);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("user", userService.findAll());

        return "user/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("searchForm", new SearchFormData());
        return "user/add";
    }

    @PostMapping(value = "/save")
    public String save(User user) {
        userService.addUser(user);

        return "redirect:/user";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("searchForm", new SearchFormData());
        return "user/edit";
    }

    @PostMapping(value = "/update")
    public String update(User user) {
        userService.updateUser(user);

        return "redirect:/user";
    }

    @PostMapping("/search")
    public String search(SearchFormData searchFormData, Model model) {
        model.addAttribute("searchForm", searchFormData);
        model.addAttribute("products", productService.findByName(searchFormData.getKeyword()));
        return "index";
    }

}
