package com.exampleCt.demoCommercetools.Stores;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.store.Store;
import com.commercetools.api.models.store.StoreDraft;
import com.exampleCt.demoCommercetools.Client;

public class StoreDataProvider {

    ProjectApiRoot apiRoot = new Client().createApiClient();
    public Store createStore(StoreDraft storeDraft) {
        return apiRoot.stores().post(storeDraft).executeBlocking().getBody();
    }
}
