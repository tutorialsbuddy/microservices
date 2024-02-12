package com.tutorialsbuddy.userservice.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import com.tutorialsbuddy.userservice.dto.ApiResponse;

@HttpExchange
public interface PaymentClient {

  @GetExchange("/payments/{senderId}")
  ApiResponse getPayments(@PathVariable(name = "senderId") Long senderId);

}
