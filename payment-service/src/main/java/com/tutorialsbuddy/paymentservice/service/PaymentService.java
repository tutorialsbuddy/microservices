package com.tutorialsbuddy.paymentservice.service;

import com.tutorialsbuddy.paymentservice.dto.ApiResponse;
import com.tutorialsbuddy.paymentservice.dto.PaymentRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface PaymentService {

  ApiResponse initiate(PaymentRequest paymentRequest, HttpServletRequest httpRequest);

  ApiResponse findPayments(Long senderId, HttpServletRequest httpRequest);

}
