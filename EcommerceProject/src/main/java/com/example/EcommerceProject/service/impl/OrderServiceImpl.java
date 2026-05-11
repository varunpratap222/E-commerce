package com.example.EcommerceProject.service.impl;

import com.example.EcommerceProject.entity.*;
import com.example.EcommerceProject.repository.*;
import com.example.EcommerceProject.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final UserRepository userRepo;
    private final CartRepository cartRepo;
    private final OrderRepository orderRepo;

    public OrderServiceImpl(UserRepository userRepo,
                            CartRepository cartRepo,
                            OrderRepository orderRepo) {

        this.userRepo = userRepo;
        this.cartRepo = cartRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    @Transactional
    public String placeOrder(String email) {

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Cart> cartItems = cartRepo.findByUser(user);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();

        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("CONFIRMED");

        List<OrderItem> orderItems = new ArrayList<>();

        double totalAmount = 0;

        for (Cart cart : cartItems) {

            Product product = cart.getProduct();

            // STOCK VALIDATION
            if (product.getStock() < cart.getQuantity()) {
                throw new RuntimeException(
                        product.getName() + " is out of stock"
                );
            }

            // REDUCE STOCK
            product.setStock(
                    product.getStock() - cart.getQuantity()
            );

            OrderItem item = new OrderItem();

            item.setOrder(order);

            item.setProduct(cart.getProduct());

            item.setQuantity(cart.getQuantity());

            item.setPrice(cart.getProduct().getPrice());

            totalAmount +=
                    cart.getProduct().getPrice()
                            * cart.getQuantity();

            orderItems.add(item);
        }

        order.setOrderItems(orderItems);

        order.setTotalAmount(totalAmount);

        orderRepo.save(order);

        cartRepo.deleteAll(cartItems);

        return "Order placed successfully ✅";
    }
}