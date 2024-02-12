package com.tutorialsbuddy.paymentservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tutorialsbuddy.paymentservice.dto.ApiResponse;
import com.tutorialsbuddy.paymentservice.dto.PaymentRequest;
import com.tutorialsbuddy.paymentservice.dto.PaymentResponse;
import com.tutorialsbuddy.paymentservice.entity.Payment;
import com.tutorialsbuddy.paymentservice.repository.PaymentRepository;
import com.tutorialsbuddy.paymentservice.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class PaymentServiceImpl implements PaymentService {
  private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

  @Autowired
  private PaymentRepository paymentRepository;

  @Override
  public ApiResponse initiate(PaymentRequest paymentRequest, HttpServletRequest httpRequest) {
    LOGGER.info("initiate: paymentRequest={}", paymentRequest);
    
    Payment payment = Payment.builder().amount(paymentRequest.getAmount())
        .fee(paymentRequest.getFee()).senderId(paymentRequest.getSenderId())
        .receiverId(paymentRequest.getReceiverId()).success(true).build();
    payment = paymentRepository.save(payment);

    PaymentResponse paymentResponse = PaymentResponse.builder().id(payment.getId())
        .amount(payment.getAmount()).fee(payment.getFee()).senderId(payment.getSenderId())
        .receiverId(payment.getReceiverId()).createdBy(payment.getCreatedBy())
        .createdDate(payment.getCreatedDate()).modifiedBy(payment.getModifiedBy())
        .modifiedDate(payment.getModifiedDate()).success(payment.isSuccess()).build();

    return ApiResponse.builder().data(paymentResponse).success(true).errorCode(0)
        .message("Payment completed successfully.").build();
  }

  @Override
  public ApiResponse findPayments(Long senderId, HttpServletRequest httpRequest) {
    LOGGER.info("findPayments: senderId={}", senderId);
    
    List<Payment> payments = paymentRepository.findBySenderId(senderId);

    List<PaymentResponse> paymentResponseList = new ArrayList<PaymentResponse>();
    payments.forEach(payment -> {
      PaymentResponse paymentResponse = PaymentResponse.builder().id(payment.getId())
          .amount(payment.getAmount()).fee(payment.getFee()).senderId(payment.getSenderId())
          .receiverId(payment.getReceiverId()).createdBy(payment.getCreatedBy())
          .createdDate(payment.getCreatedDate()).modifiedBy(payment.getModifiedBy())
          .modifiedDate(payment.getModifiedDate()).build();

      paymentResponseList.add(paymentResponse);
    });

    return ApiResponse.builder().data(paymentResponseList).success(true).errorCode(0)
        .message("Data found.").build();
  }

}
