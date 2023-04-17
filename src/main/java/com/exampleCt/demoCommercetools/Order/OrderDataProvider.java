package com.exampleCt.demoCommercetools.Order;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.order.OrderFromCartDraft;
import com.exampleCt.demoCommercetools.Client;

public class OrderDataProvider {

    ProjectApiRoot apiRoot = new Client().createApiClient();

    public Order createOder(OrderFromCartDraft orderFromCartDraft) {
        return apiRoot.orders().post(orderFromCartDraft).executeBlocking().getBody();
    }
}
