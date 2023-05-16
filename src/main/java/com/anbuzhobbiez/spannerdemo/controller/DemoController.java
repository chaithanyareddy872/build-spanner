package com.anbuzhobbiez.spannerdemo.controller;

import com.anbuzhobbiez.spannerdemo.model.Orders;
import com.anbuzhobbiez.spannerdemo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

@RestController
public class DemoController {


    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/order/{orderitem}")
    public ResponseEntity<?> saveitem(@PathVariable String orderitem){
        employeeRepository.save(new Orders(
                UUID.randomUUID().toString(),
                orderitem
        ));
        return ResponseEntity.ok().body("order "+orderitem+" saved");
    }
    @GetMapping("/getorders")
    public ResponseEntity<?> getallorders(){
        ArrayList<Orders> ordersArrayList= (ArrayList<Orders>) employeeRepository.findAll();
        return  ResponseEntity.ok().body(ordersArrayList);
    }
    @GetMapping("/")
    public String greetings(){
        return "its working";
    }
}
