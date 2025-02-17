package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bank.modal.Llcr;
import com.bank.modal.Npa;
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
    
    @GetMapping("/calculate/Llcr/months/{n}")
    public List<Llcr> calculateAllLlcr(@PathVariable int n) {
        return llcrServiceImpl.allLlcr(n);
    }
}
