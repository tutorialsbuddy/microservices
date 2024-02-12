package com.tutorialsbuddy.paymentservice.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tutorialsbuddy.paymentservice.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

  List<Payment> findBySenderId(Long senderId);

}
