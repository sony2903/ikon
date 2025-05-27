package com.phonebook.services.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsonPlaceOrderResponse {
    List<JsonPlaceOrder> data;
    int currentPage;
    int totalPages;
}
