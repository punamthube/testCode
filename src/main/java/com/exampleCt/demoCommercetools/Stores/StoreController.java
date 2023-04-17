package com.exampleCt.demoCommercetools.Stores;


import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.store.Store;
import com.commercetools.api.models.store.StorePagedQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/store")
public class StoreController {

    @Autowired
    StoreService storeService;

    @Autowired
    ProjectApiRoot projectApiRoot;

    @PostMapping
     public Store createStore(@RequestBody StoreData storeData){

        return storeService.createStore(storeData);

    }

    @GetMapping

    public  StorePagedQueryResponse getAllStore(){
        return projectApiRoot.stores().get().executeBlocking().getBody();

    }
}

