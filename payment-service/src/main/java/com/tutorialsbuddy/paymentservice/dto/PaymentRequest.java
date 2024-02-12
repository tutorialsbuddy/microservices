package com.tutorialsbuddy.paymentservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class PaymentRequest extends ApiRequest {
  private Long id;
  private double amount;
  private double fee;
  private Long senderId;
  private Long receiverId;
}
