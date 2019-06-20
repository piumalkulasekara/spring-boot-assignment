package lk.piumalkulasekara.spring.boot.assignment.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping(value = "/",method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<String> index() {
        return new ResponseEntity<>("{\"message\" : \"Welcome to Spring Boot REST API Assignment!\"}", HttpStatus.OK);
    }
}