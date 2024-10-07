package com.example.creche.controllers;

import com.example.creche.modele.Admin;
import com.example.creche.modele.Employé;
import com.example.creche.modele.parent;
import com.example.creche.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admins")

public class ControllerAdmin {
    private AdminService adminService;

    public ControllerAdmin(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/saveAdmin")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @GetMapping()
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @DeleteMapping("/id")
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }

    @PutMapping("/id")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        return adminService.updateAdmin(id, adminDetails);
    }
}