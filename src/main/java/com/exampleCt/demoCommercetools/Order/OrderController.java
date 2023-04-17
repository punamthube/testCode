package com.exampleCt.demoCommercetools.Order;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.order.Order;
import com.commercetools.api.models.project.Project;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ProjectApiRoot projectApiRoot;

    @PostMapping
    public Order createOder(@RequestBody OrderData orderData)
    {
        return orderService.createOder(orderData);
    }


    @GetMapping
    public Project getAllOrder()
    {
        return projectApiRoot.get().executeBlocking().getBody();
    }

  /*  @PostMapping("/{id}")
    public Order getOrderById(@PathVariable String id){
        return projectApiRoot.orders().withId(id).get().executeBlocking().getBody();
    }*/

    @GetMapping("/{orderNumber}")
    public Order getOrderByOrderNumber(@PathVariable String orderNumber)
    {
        return projectApiRoot.orders().withOrderNumber(orderNumber).get().executeBlocking().getBody();
    }
    @GetMapping("/{orderNumber}/lineItemID/{lineItemID}")
    public Order getOrderByOrderNumber(@PathVariable String orderNumber,@PathVariable String  lineItemID)
    {
        return projectApiRoot.orders().withOrderNumber(orderNumber).get().executeBlocking().getBody();
    }

}
