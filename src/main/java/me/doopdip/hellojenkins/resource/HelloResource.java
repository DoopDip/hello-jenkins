package me.doopdip.hellojenkins.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hello")
public class HelloResource {

    @GetMapping
    public String hello() {
        return "Hello Jenkins";
    }

}
