
package com.bank.service;

import org.springframework.stereotype.Service;

import com.bank.modal.BaseInterest;
import com.bank.modal.PenaltyFees;

@Service
public interface baseInterest {
	public String addBaseInterest(BaseInterest baseInt);
	public BaseInterest updatebaseInterest(BaseInterest baseInt) throws Exception;
	public void deleteBaseInterest(int id) throws Exception;
	public BaseInterest getLatestBaseInterest();
}
