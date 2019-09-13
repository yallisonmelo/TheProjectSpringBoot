package br.com.yfsm.theprojectspringboot.controller;

import br.com.yfsm.theprojectspringboot.response.Response;
import br.com.yfsm.theprojectspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;

    HttpHeaders headers;

    @GetMapping
    public ResponseEntity<Response> returnListAllUsers(){
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Response>(new Response(userService.getListAllUsers()),headers, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response> returnUserById(@PathVariable Long id){
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Response>(new Response(userService.getUserById(id)),headers, HttpStatus.OK);

    }
}
