package com.exampleCt.demoCommercetools.Commerce.Cart;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.Cart;
import com.commercetools.api.models.cart.CartPagedQueryResponse;

import com.commercetools.api.models.cart_discount.CartDiscount;
import com.commercetools.api.models.discount_code.DiscountCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ProjectApiRoot ProjectApiRoot;

    @PostMapping
    Cart createCart(@RequestBody CartData cartData){
        return cartService.createCart(cartData);

    }

    @GetMapping
    CartPagedQueryResponse getAllCarts(){

        return ProjectApiRoot.carts().get().executeBlocking().getBody();
    }

    @GetMapping("/{id}")
    Cart getCustomerById(@PathVariable String id){
        return ProjectApiRoot.carts().withId(id).get().executeBlocking().getBody();
    }
    @DeleteMapping("/{id}")
    String deleteCartById(@PathVariable String id,@RequestBody CartData cartData){
         ProjectApiRoot.carts().withId(id).delete().withVersion(cartData.getVersion()).executeBlocking();
         return  "Cart is deleted";
    }


    @PostMapping("/update/{id}")
        Cart updateCart(@PathVariable String id, @RequestBody CartData cartData){
        return cartService.updateCart(id,cartData);

    }
    @PostMapping("/Item/{id}")
    Cart addLineItem(@RequestBody CartData cartData,@PathVariable String id){
        return cartService.addLineItem(cartData,id);
    }

    @PostMapping("/cartDiscount")
    CartDiscount createCartDiscount(@RequestBody CartData cartData){
        return  cartService.createCartDiscount(cartData);
    }

    @PostMapping("/codeDiscount")
    DiscountCode createCodeDiscount(@RequestBody CartData cartData){
        DiscountCode discountCode =  cartService.createCodeDiscount(cartData);
        return discountCode;
    }





}
