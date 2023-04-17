package com.exampleCt.demoCommercetools.Commerce.Product;


import lombok.Getter;

import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ProductData {

    public String Id;
    public String name;

    public String description;

    public String key;



    public  String slug;


    public Boolean isSearchable;

    public  Boolean isRequired;

    public String productname;

    public  String type;
    public String lang;
    public String lableName;


    public Long centamount;

    public  String currencycode;
    public  String sku;

    public String url;

    public Boolean publish;

    List<AttributeData> attributeData;

}
