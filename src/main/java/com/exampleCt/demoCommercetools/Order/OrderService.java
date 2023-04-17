package com.exampleCt.demoCommercetools.Order;


import com.commercetools.api.models.cart.CartResourceIdentifier;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.order.OrderFromCartDraft;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    OrderDataProvider odp = new OrderDataProvider();

    public Order createOder(OrderData orderData) {
        OrderFromCartDraft orderFromCartDraft = OrderFromCartDraft
                .builder()
                .cart(CartResourceIdentifier.builder().id(orderData.getCartId()).build())
                .orderNumber(orderData.getOrderNumber())
                .version(orderData.getVersion())
                .build();
        return odp.createOder(orderFromCartDraft);
    }
}
