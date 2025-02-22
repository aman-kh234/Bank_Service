//package com.bank.modal;
//
//import java.time.LocalDate;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class CreditEnquiriesDto {
//	private int id;
//	private int score;
//	private LocalDate checkedOn;
//	private String reportLink;
//	private String review;
//	private String improvementTips;
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
public class CreditEnquiriesDto implements Serializable {  
    private int id;  
    private int score;  
    private LocalDate checkedOn;  
    private String reportLink;  
    private String review;  
    private String improvementTips;  
}
