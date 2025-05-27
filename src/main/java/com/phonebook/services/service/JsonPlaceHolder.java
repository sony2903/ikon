package com.phonebook.services.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.phonebook.services.model.JsonPlaceOrder;
import com.phonebook.services.model.JsonPlaceOrderResponse;

@Service
public class JsonPlaceHolder {
    public List<JsonPlaceOrder> getDataFromJsonPlaceHolder() {
        String Url = "https://jsonplaceholder.typicode.com/posts";   
        RestTemplate restTemplate = new RestTemplate();
        // ResponseEntity<JsonPlaceOrderResponse> response = restTemplate.exchange(
        //     Url, HttpMethod.GET, null, new ParameterizedTypeReference<JsonPlaceOrderResponse>() {});
        // JsonPlaceOrderResponse jsonPlaceOrderResponse = response.getBody();
        // return jsonPlaceOrderResponse;

        ResponseEntity<List<JsonPlaceOrder>> res = restTemplate.exchange(Url, HttpMethod.GET, null, new ParameterizedTypeReference<List<JsonPlaceOrder>>() {});
        return res.getBody();
    }

    public JsonPlaceOrderResponse paginationData(int page, int size, List<JsonPlaceOrder> data) {
        JsonPlaceOrderResponse response = new JsonPlaceOrderResponse();
        int totalData = data.size();
        int totalPages = (int) Math.ceil((double) totalData / size);
        int currentPage = page;
        List<JsonPlaceOrder> dataPage = new ArrayList<>();

        //paginate here

        response.setData(dataPage);
        response.setCurrentPage(currentPage);
        response.setTotalPages(totalPages);
        return response;
    }
    
}
