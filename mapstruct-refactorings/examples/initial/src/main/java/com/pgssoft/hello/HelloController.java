package com.pgssoft.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pgssoft.service.Service;

@RestController
public class HelloController {

    @Autowired
    private Service defaultService;

    @RequestMapping("/")
    public String index() {


        return "Greetings from Spring Boot!" + defaultService.result();
    }
    
}
