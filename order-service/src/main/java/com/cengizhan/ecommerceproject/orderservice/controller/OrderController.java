package com.cengizhan.ecommerceproject.orderservice.controller;

import com.cengizhan.ecommerceproject.orderservice.dto.NewOrderRequest;
import com.cengizhan.ecommerceproject.orderservice.dto.OrderDto;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.OrderStateEnum;
import com.cengizhan.ecommerceproject.orderservice.entity.enums.PaymentStateEnum;
import com.cengizhan.ecommerceproject.orderservice.service.OrderService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/order")
public class OrderController {

    private final OrderService service;


    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/user/{userId}/start")
    public ResponseEntity<Void> start(@NotBlank @PathVariable("userId") Integer userId,@RequestBody NewOrderRequest newOrderRequest){
        service.start(userId, newOrderRequest);
        ResponseEntity.ok().build();
    }
    @GetMapping("/user/{userId}/active")
    public ResponseEntity<OrderDto> getActiveOrder(@NotBlank @PathVariable("userId") Integer userId){
        return ResponseEntity.ok(service.getActiveOrder(userId));
    }
    @GetMapping("user/{userId}/all")
    public ResponseEntity<List<OrderDto>> getAllOrders(@NotBlank Integer userId){
        return ResponseEntity.ok(service.getAllOrders(userId));
    }

    @PostMapping("/{orderId}/orderState/{orderState}")
    public ResponseEntity<Void> updateOrderState(@NotBlank @PathVariable("orderId") Long orderId,
                                                 @NotBlank @PathVariable("orderState") OrderStateEnum orderState){
        service.updateOrderState(orderId, orderState);
        ResponseEntity.ok().build();
    }
    @PostMapping("/{orderId}/paymentState/{paymentState}")
    public ResponseEntity<Void> updatePaymentState(@NotBlank @PathVariable("orderId") Long orderId,
                                                   @NotBlank @PathVariable("paymentState") PaymentStateEnum paymentState){
        service.updatePaymentState(orderId, paymentState);
        ResponseEntity.ok().build();
    }
}
