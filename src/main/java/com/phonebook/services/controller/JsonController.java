package com.phonebook.services.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.services.model.JsonPlaceOrder;
import com.phonebook.services.model.ResponseMdl;
import com.phonebook.services.service.JsonPlaceHolder;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/json")
public class JsonController {

    @Autowired
    JsonPlaceHolder service;

    @RequestMapping("/")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }

    @RequestMapping("/json")
    public ResponseEntity<ResponseMdl> getJsonPlaceHolder(
        @RequestParam(value = "page", required = false) Integer page,
        @RequestParam(value = "size", required = false) Integer size
        ) {
        ResponseMdl response = new ResponseMdl();
        try {
            List<JsonPlaceOrder> data = service.getDataFromJsonPlaceHolder();
            response.setData(data);
            response.setMessage("Data fetched successfully");
            response.setCode(HttpStatus.OK.value());
        } catch (Exception e) {
            response.setMessage("Error fetching data: " + e.getMessage());
            response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    
    
}
