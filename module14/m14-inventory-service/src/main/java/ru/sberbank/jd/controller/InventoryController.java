package ru.sberbank.jd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

    @GetMapping("inventory/hello")
    public String getInventoryHello() {
        return "Hello, I am inventory";
    }
}
