package com.soham.springboot_transaction_demo.service;

import com.soham.springboot_transaction_demo.dto.OrderRequest;
import com.soham.springboot_transaction_demo.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);

}
