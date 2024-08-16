package com.soham.springboot_transaction_demo.dto;

import com.soham.springboot_transaction_demo.entity.Order;
import com.soham.springboot_transaction_demo.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
