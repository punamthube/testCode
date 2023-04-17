package com.exampleCt.demoCommercetools.Commerce.Product;

import com.commercetools.api.client.ProjectApiRoot;


import com.commercetools.api.models.graph_ql.GraphQLRequest;
import com.commercetools.api.models.graph_ql.GraphQLResponse;
import com.commercetools.api.models.graph_ql.GraphQLVariablesMap;
import com.commercetools.api.models.product.Product;

import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.commercetools.api.models.product.ProductProjectionPagedSearchResponse;
import com.commercetools.api.models.product_type.ProductType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProjectApiRoot projectApiRoot;


    @PostMapping("/product-type")
    public ProductType createproductType(@RequestBody ProductData productData){
        return productService.createType(productData);

    }
    @PostMapping
    Product createproduct(@RequestBody ProductData productData){

        return productService.createProduct(productData);
    }

    @GetMapping("/")
    ProductPagedQueryResponse getAllProduct()
    {
        return projectApiRoot.products().get().executeBlocking().getBody();
    }
    @GetMapping("/productGraphQL")


    GraphQLResponse getAllProductByGraphQL()
    {
        return projectApiRoot.graphql().post(GraphQLRequest.builder().query("query Products($id:String){\n" +
                "  product(id:$id){\n" +
                "    id\n" +
                "  }  \n" +
                "}").variables(GraphQLVariablesMap.builder().addValue("id","baea2808-45b2-400c-9465-a9f706dba242").build()).build()).executeBlocking().getBody();
    }

    @GetMapping("/{id}")
    String getSKUBYid(@PathVariable String id){
        return projectApiRoot.products().withId(id).get().executeBlocking().getBody().getMasterData().getCurrent().getMasterVariant().getSku();
    }
    @GetMapping
    ProductPagedQueryResponse getAllProductById(@RequestParam (required = false,defaultValue = "5") int limit)
    {
        return projectApiRoot.products().get().withLimit(limit).executeBlocking().getBody();
    }

   @GetMapping("/products/{key}")
    ProductPagedQueryResponse getAllProductByIdKey(@RequestParam (required = false,defaultValue = "5") String Key) {

       return projectApiRoot.products().get().withLimit(Key).executeBlocking().getBody();
   }
    @GetMapping("/FilterByWhere")
    ProductPagedQueryResponse getAllProductByIdFilterByWhere(@RequestParam  String key)
    {
        return projectApiRoot.products().get().withWhere(key).executeBlocking().getBody();
    }
    @GetMapping("/products-filterSlug")
    ProductProjectionPagedSearchResponse productGetByfilter(@RequestParam String value){
        return projectApiRoot.productProjections().search().get().addFilter(value).executeBlocking().getBody();

    }
    @GetMapping("/products-multiplefilter")
    ProductProjectionPagedSearchResponse productGetByfilterr(@RequestParam String key,String val){
        return projectApiRoot.productProjections().search().get().addFilter(key).addFilter(val).executeBlocking().getBody();

    }
    @PostMapping("/type")
    ProductType createProductType(@RequestBody ProductData productData)
    {
        return productService.createType(productData);
    }
    @GetMapping("/at/{id}")

    String getAttBYid(@PathVariable String id) {
        return projectApiRoot.products().withId(id).get().executeBlocking().getBody().getMasterData().getCurrent().getMasterVariant().getSku();
    }
}
