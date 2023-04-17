package com.exampleCt.demoCommercetools.Commerce.Cart;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartData {

    public String discountCode;
    public  String currency;

    public Long version;

    public long quantity;

    public List<bcc> lineItems;

    //Create cart discount

    public String name;

    public  String key;

    public String description;

    public Boolean isActive;

    public String value;

    public String money;

    public String cartPredicate;

    public  String sortOrder;

    public String target;

    public String giftLineItem;

    public Boolean requiresDiscountCode;
    //create codeDiscount

    public String code;
    public String cartId;

    //Custome Type for LineItem


    public String image;
    public Number longitude;
    public  Number latitude;
    public  String reason;





}
