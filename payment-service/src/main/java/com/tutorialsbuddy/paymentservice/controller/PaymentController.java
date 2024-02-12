package com.tutorialsbuddy.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tutorialsbuddy.paymentservice.dto.ApiResponse;
import com.tutorialsbuddy.paymentservice.dto.PaymentRequest;
import com.tutorialsbuddy.paymentservice.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/payments")
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @PostMapping(path = "/initiate")
  public ApiResponse intiate(@RequestBody PaymentRequest paymentRequest,
      HttpServletRequest httpRequest) {

    return paymentService.initiate(paymentRequest, httpRequest);

  }


  @GetMapping(path = "/{senderId}")
  public ApiResponse findPayments(@PathVariable(name = "senderId") Long senderId,
      HttpServletRequest httpRequest) {

    return paymentService.findPayments(senderId, httpRequest);

  }

}
