package com.exampleCt.demoCommercetools.Commerce.customer;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.type.Type;
import com.commercetools.api.models.type.TypeDraft;
import com.exampleCt.demoCommercetools.Client;

public class CustomerDataProvider {

    ProjectApiRoot apiRoot= new  Client().createApiClient();


    public Customer createCustomer(CustomerDraft CustomerDetails) {
        return apiRoot.customers().post(CustomerDetails).executeBlocking().getBody().getCustomer();
    }

    public Type createCustomType(TypeDraft typeDraft) {
        return apiRoot.types().post(typeDraft).executeBlocking().getBody();
    }

    public CustomerToken generateToken(CustomerCreatePasswordResetToken createPasswordResetToken) {
        return apiRoot.customers().passwordToken().post(createPasswordResetToken).executeBlocking().getBody();
    }

    public Customer resetPasswordToken(CustomerResetPassword customerResetPassword) {
        return apiRoot.customers().passwordReset().post(customerResetPassword).executeBlocking().getBody();
    }

    public Customer changepassword(CustomerChangePassword CustomerChangePassword) {
        return apiRoot.customers().password().post(CustomerChangePassword).executeBlocking().getBody();
    }


    public CustomerSignInResult login(CustomerSignin customerSignin) {
        return apiRoot.login().post(customerSignin).executeBlocking().getBody();
    }
}
