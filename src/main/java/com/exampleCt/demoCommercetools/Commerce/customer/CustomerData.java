package com.exampleCt.demoCommercetools.Commerce.customer;

import com.commercetools.api.models.common.LocalizedString;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerData {

    public String Email;

    public String password;

    public  String firstname;

    public String lastname;

    public String company;

    public String customernumber;

    public String externalId;

    public String fieldName;
    public String typeName;
    public String typeKey;
    public String fieldLabel;
    public String gender;
    public String value;

    public String newpassword;

    public Long version;
    public String Id;

    public String currentPassword;

    public boolean isEmailpreference;

    public boolean emailpreference;
    Object fieldValue;
    LocalizedString values;



}
