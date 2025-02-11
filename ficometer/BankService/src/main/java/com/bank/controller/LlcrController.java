package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.modal.Llcr;
import com.bank.service.LlcrService;

@RestController
@RequestMapping("/")
public class LlcrController {

    @Autowired
    private LlcrService llcrServiceImpl;

    @PostMapping("/add/llcr")
    public Llcr addLlcr(@RequestBody Llcr llcr) {
        return llcrServiceImpl.addLlcr(llcr);
    }

    @GetMapping("/get/llcrByPeriod")
    public Llcr getByPeriod() {
        return llcrServiceImpl.getLlcrByPeriod();
    }

    @GetMapping("/calculate/llcr/latest")
    public double calculateLlcrLatest() {
        return llcrServiceImpl.calculateLlcr(getByPeriod());
    }

    @DeleteMapping("/delete/llcr/{id}")
    public void deleteLlcr(@PathVariable int id) {
        llcrServiceImpl.deleteLlcr(id);
    }
}
