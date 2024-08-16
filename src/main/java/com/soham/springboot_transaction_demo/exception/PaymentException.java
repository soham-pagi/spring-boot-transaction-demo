package com.soham.springboot_transaction_demo.exception;

import com.soham.springboot_transaction_demo.repository.PaymentRepository;

public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}
