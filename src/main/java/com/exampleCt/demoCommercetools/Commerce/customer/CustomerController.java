package com.exampleCt.demoCommercetools.Commerce.customer;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.customer.*;
import com.commercetools.api.models.graph_ql.GraphQLRequest;
import com.commercetools.api.models.graph_ql.GraphQLResponse;
import com.commercetools.api.models.graph_ql.GraphQLVariablesMap;
import com.commercetools.api.models.type.Type;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    ProjectApiRoot projectApiRoot;
    @PostMapping
    Customer Createcustomer(@RequestBody CustomerData customerData){

       // log.info("customerData={}",customerData.isEmailpreference());
        return customerService.createCustomer(customerData);
    }
    @GetMapping
    CustomerPagedQueryResponse getAllCustomer(){

        return projectApiRoot.customers().get().executeBlocking().getBody();
    }


    @GetMapping("/GraphQl/{id}")
    GraphQLResponse getAllCustomerByGraphQl(@PathVariable String id){

        return projectApiRoot.graphql().post(GraphQLRequest.builder().query(
                "query customers($id:String){\n" +
                "  customer(id:$id){\n" +
                "      email\n" +
                "      id\n" +
                "      firstName\n"+
                "      lastName\n"+
                "    }\n" +
                "  }"
                ).variables(GraphQLVariablesMap.builder().addValue("id",id).build()).build()).executeBlocking().getBody();
    }
    @GetMapping("/{id}")
    Customer getCustomerById(@PathVariable String id){
        return projectApiRoot.customers().withId(id).get().executeBlocking().getBody();
    }
    @DeleteMapping("/{id}")
    Customer DeleteCustomerById(@PathVariable String id){
        return projectApiRoot.customers().withId(id).delete().addVersion(2).executeBlocking().getBody();
    }
    @PostMapping("/update/{id}")
    Customer updateCustomer(@PathVariable String id, @RequestBody CustomerUpdate customerUpdate)
    {
        return  projectApiRoot.customers().withId(id).post(customerUpdate).executeBlocking().getBody();
    }
    @PostMapping("/custom-type")
    Type createCustomType(@RequestBody CustomerData customerData)
    {
        return customerService.createCustomType(customerData);
    }
    @PostMapping("/Token-resetpass")
    public CustomerToken generateToken(@RequestBody CustomerData customerData)
    {
        return customerService.generateToken(customerData);
    }
    @PostMapping("/rest-Password")
    public  Customer resetPasswordToken(@RequestBody CustomerData customerData)
    {
        return customerService.resetPasswordToken(customerData);
    }
   @PostMapping("/change-password")
    public Customer changepassword(@RequestBody CustomerData customerData)
   {
       return customerService.changepassword(customerData);

   }
   @PostMapping("/log-in")
    public CustomerSignInResult login(@RequestBody CustomerData customerData)
   {
       log.info("this is controller");
       return customerService.login(customerData);
   }
    @GetMapping("/where")
    CustomerPagedQueryResponse customerByIdFilterByWhere(@RequestParam  String key)
    {
        return projectApiRoot.customers().get().withWhere(key).executeBlocking().getBody();
    }
}
