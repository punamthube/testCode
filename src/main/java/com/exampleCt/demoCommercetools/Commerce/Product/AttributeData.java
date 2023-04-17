package com.exampleCt.demoCommercetools.Commerce.Product;

import com.commercetools.api.models.product_type.AttributeConstraintEnum;
import com.commercetools.api.models.product_type.AttributeType;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class AttributeData {
    public  String attributename;
    public String attributelabel;
    public AttributeType attributeType;

    public String attributedescription;

    public AttributeConstraintEnum attributeconstraints;

    public  Boolean isRequired;
    public  Boolean isSearchable;


}
