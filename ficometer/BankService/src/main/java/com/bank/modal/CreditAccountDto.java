////package com.bank.modal;
////
////import java.time.LocalDate;
////
////import jakarta.persistence.Entity;
////import lombok.AllArgsConstructor;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////public class CreditAccountDto {
////	private int id;
////	private LocalDate createdAt;
////	private typeOfCreditDto typeOfCredit;
////	private long creditLimit;
////	private long creditUsed;
////	private paymentHistoryDto paymentHistory;
////}
//
//
//
//package com.bank.modal;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class CreditAccountDto implements Serializable {  
//    private int id;  
//    private LocalDate createdAt;  
//    private TypeOfCreditDto typeOfCredit;  
//    private long creditLimit;  
//    private long creditUsed;  
//    private PaymentHistoryDto paymentHistory;  
//}



package com.bank.modal;

import java.io.Serializable;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditAccountDto implements Serializable {  
    private int id;  
    private LocalDate createdAt;  
    private TypeOfCreditDto typeOfCredit;  
    private long creditLimit;  
    private long creditUsed;  
    private PaymentHistoryDto paymentHistory;  
}
