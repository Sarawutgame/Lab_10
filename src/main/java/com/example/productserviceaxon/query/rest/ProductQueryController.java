package com.example.productserviceaxon.query.rest;


import com.example.productserviceaxon.query.FindProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    @Autowired
    QueryGateway queryGateway;

    @GetMapping
    public List<ProductRestModel> getProduct(){
        FindProductsQuery findProductsQuery = new FindProductsQuery();
        List<ProductRestModel> product = queryGateway.query(findProductsQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return product;
    }
}