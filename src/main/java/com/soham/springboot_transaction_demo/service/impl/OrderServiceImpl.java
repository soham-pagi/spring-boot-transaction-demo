package com.soham.springboot_transaction_demo.service.impl;

import com.soham.springboot_transaction_demo.dto.OrderRequest;
import com.soham.springboot_transaction_demo.dto.OrderResponse;
import com.soham.springboot_transaction_demo.entity.Order;
import com.soham.springboot_transaction_demo.entity.Payment;
import com.soham.springboot_transaction_demo.exception.PaymentException;
import com.soham.springboot_transaction_demo.repository.OrderRepository;
import com.soham.springboot_transaction_demo.repository.PaymentRepository;
import com.soham.springboot_transaction_demo.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if (!payment.getType().equals(("DEBIT"))) {
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");

        return orderResponse;
    }
}
