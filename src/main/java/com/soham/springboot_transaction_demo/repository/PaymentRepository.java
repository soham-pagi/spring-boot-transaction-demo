package com.soham.springboot_transaction_demo.repository;

import com.soham.springboot_transaction_demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
