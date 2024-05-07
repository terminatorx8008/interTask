package com.task.vasunamdevfliprinternshiptask.controller;

import com.task.vasunamdevfliprinternshiptask.dao.AdminRepo;
import com.task.vasunamdevfliprinternshiptask.entities.Admin;
import com.task.vasunamdevfliprinternshiptask.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Home - Vasu Namdev Flipr Internship Task");
        Admin admin = new Admin();
        model.addAttribute("admin", admin);
        return "index";
    }
    @PostMapping("/register")
    public String register(@ModelAttribute("admin") Admin admin, Model model){
        try {
            if(admin.getAdminEmail().trim().equals("") || admin.getAdminPassword().trim().equals("")){
                Message message = new Message("Please fill all the fields", "danger");
                model.addAttribute("message", message);
                return "index";
            }
            admin.setRole("ROLE_ADMIN");
            admin.setAdminPassword(bCryptPasswordEncoder.encode(admin.getAdminPassword()));
            adminRepo.save(admin);
            Message message = new Message("Admin registered successfully", "success");
            model.addAttribute("message", message);
        } catch (Exception e){
            Message message = new Message("Admin registration failed", "danger");
            model.addAttribute("message", message);
        }
        return "index";
    }
    @RequestMapping("/error-login")
    public String errorLogin(Model model){
        model.addAttribute("title", "Error - Vasu Namdev Flipr Internship Task");
        Message message = new Message("Invalid credentials", "danger");
        model.addAttribute("message", message);
        return "index";
    }
}
