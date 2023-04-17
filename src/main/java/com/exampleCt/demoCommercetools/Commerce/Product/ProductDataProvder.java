package com.exampleCt.demoCommercetools.Commerce.Product;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypeDraft;
import com.exampleCt.demoCommercetools.Client;
public class ProductDataProvder {


    ProjectApiRoot apiRoot = new Client().createApiClient();


    public Product createProduct(ProductDraft productDraft) {
        return apiRoot.products().post(productDraft).executeBlocking().getBody();

    }

    public ProductType createProductType(ProductTypeDraft productTypeDraft) {
//        return  apiRoot.productTypes().post(productTypeDraft).executeBlocking().getBody();
        return apiRoot.productTypes().post(productTypeDraft).executeBlocking().getBody();
    }
}
