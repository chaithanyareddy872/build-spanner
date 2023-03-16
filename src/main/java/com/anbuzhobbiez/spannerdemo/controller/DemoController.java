package com.anbuzhobbiez.spannerdemo.controller;

import com.anbuzhobbiez.spannerdemo.model.Orders;
import com.anbuzhobbiez.spannerdemo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DemoController {


    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/greet/{orderitem}")
    public String greet(@PathVariable String orderitem){
        employeeRepository.save(new Orders(
                UUID.randomUUID().toString(),
                orderitem
        ));
        return "you have ordered "+orderitem;
    }
    @GetMapping("/")
    public String greetings(){
        return "hello";
    }
}
