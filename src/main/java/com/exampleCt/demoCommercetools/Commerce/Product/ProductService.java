package com.exampleCt.demoCommercetools.Commerce.Product;


import com.commercetools.api.models.common.*;
import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductDraft;
import com.commercetools.api.models.product.ProductVariantDraftBuilder;
import com.commercetools.api.models.product_type.*;
import com.exampleCt.demoCommercetools.Commerce.Product.ProductData;
import com.exampleCt.demoCommercetools.Commerce.Product.ProductDataProvder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    ProductDataProvder pdp = new ProductDataProvder();

    public ProductType createType(ProductData productData) {
        List<AttributeDefinitionDraft> Atlist = productData.getAttributeData().stream()
                .map(attributeData -> {
                    return AttributeDefinitionDraft.builder()
                            .type(attributeData.getAttributeType())
                            .name(attributeData.getAttributename())
                            .label(LocalizedString.ofEnglish(attributeData.getAttributelabel()))
                            .attributeConstraint(attributeData.getAttributeconstraints())
                            .isRequired(attributeData.getIsRequired())
                            .isSearchable(attributeData.getIsSearchable())
                            .build();
                }).collect(Collectors.toList());

        ProductTypeDraft productTypeDraft = ProductTypeDraft
                .builder()
                .name(productData.getName())
                .description(productData.getDescription())
                .key(productData.getKey())
                .attributes(AttributeDefinitionDraft.builder()

                        .label(LocalizedString.builder().addValue(productData.getLang(),productData.getAttributeData().get(0).getAttributelabel()).build())
                        .name(productData.getName())
                        .type(AttributeType.textBuilder().build())
                        .isSearchable(productData.getIsSearchable())
                        .isRequired(productData.getIsRequired())
                        .build()).build();
        return pdp.createProductType(productTypeDraft);
    }

    public Product createProduct (ProductData productData) {
//        ProductType type =createType(productData);
        ProductDraft productDraft = ProductDraft
                .builder()
                .productType(ProductTypeResourceIdentifier.builder().id(productData.getId()).build())
                .name(LocalizedString.ofEnglish(productData.getProductname()))
                .key(productData.getKey())
                .description(LocalizedString.ofEnglish(productData.getDescription()))
                .slug(LocalizedString.ofEnglish(productData.getSlug()))
                .masterVariant(ProductVariantDraftBuilder.of()
                        .prices(PriceDraft.builder()
                                .value(Money.builder().centAmount(productData.getCentamount()).currencyCode(productData.getCurrencycode()).build())
                                .build())

                        .sku(productData.getSku())
                        .key(productData.getKey())
                        .images(Image.builder()
                                .url(productData.getUrl()).dimensions(ImageDimensions.builder().h(32).w(12).build()).build())


                        .build())
                .publish(productData.getPublish())
                .build();
        return pdp.createProduct(productDraft);



               /* .slug(LocalizedString.ofEnglish("product-slug-10567"))*//*
                .name(LocalizedString.builder()
                        .addValue("EN","new-demo")
                        .addValue("EN-US","new-demo")
                        .addValue("DE-DE","new-demo")
                        .build())*/


              /*  .description(LocalizedString.ofEnglish("just demo"))
                .masterVariant(ProductVariantDraft
                        .builder().sku("SKU-23").prices(PriceDraft
                                .builder()
                                .value(Money.builder()
                                        .currencyCode("INR")
                                        .centAmount(34L)
                                        .build())
                                .build())
                        .build())


                .build();*/
    }




}
