package com.tutorialsbuddy.paymentservice.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponse {
  private Long id;
  private double amount;
  private double fee;
  private Long senderId;
  private Long receiverId;
  private int status;
  private boolean success;
  private Date createdDate;
  private Date modifiedDate;
  private String createdBy;
  private String modifiedBy;
  
}
