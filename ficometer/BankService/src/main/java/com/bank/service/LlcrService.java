package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.bank.modal.Llcr;

@Service
public interface LlcrService {
    public Llcr addLlcr(Llcr llcr);
    public double calculateLlcr(Llcr llcr);
    public Llcr getLlcrByPeriod();
    public void deleteLlcr(int id);
    public List<Llcr> allLlcr(int n);
}
