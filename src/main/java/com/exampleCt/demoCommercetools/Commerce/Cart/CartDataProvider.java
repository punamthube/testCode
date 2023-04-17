package com.exampleCt.demoCommercetools.Commerce.Cart;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.Cart;
import com.commercetools.api.models.cart.CartDraft;
import com.commercetools.api.models.cart.CartUpdate;
import com.commercetools.api.models.cart_discount.CartDiscount;
import com.commercetools.api.models.cart_discount.CartDiscountDraft;
import com.commercetools.api.models.discount_code.DiscountCode;
import com.commercetools.api.models.discount_code.DiscountCodeDraft;
import com.exampleCt.demoCommercetools.Client;

public class CartDataProvider {

    ProjectApiRoot apiRoot = new Client().createApiClient();
    public Cart createCart(CartDraft cartDraft) {

        return apiRoot.carts().post(cartDraft).executeBlocking().getBody();
    }

    public Cart updateCart(String id, CartUpdate cartUpdate) {
        return apiRoot.carts().withId(id).post(cartUpdate).executeBlocking().getBody();
    }


    public Cart addLineItem(CartUpdate cartUpdate, String id) {
        return apiRoot.carts().withId(id).post(cartUpdate).executeBlocking().getBody();
    }

    public CartDiscount createCartDiscount(CartDiscountDraft cartDiscountDraft) {
        return  apiRoot.cartDiscounts().post(cartDiscountDraft).executeBlocking().getBody();
    }

    public DiscountCode createCodeDiscount(DiscountCodeDraft discountCodeDraft) {
        return apiRoot.discountCodes().post(discountCodeDraft).executeBlocking().getBody();
    }
}
