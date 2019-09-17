package br.com.yfsm.theprojectspringboot.controller;

import br.com.yfsm.theprojectspringboot.domain.User;
import br.com.yfsm.theprojectspringboot.domain.dto.UserDto;
import br.com.yfsm.theprojectspringboot.response.Response;
import br.com.yfsm.theprojectspringboot.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    HttpHeaders headers;

    @GetMapping
    public ResponseEntity<Response> returnListAllUsers(){
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new Response(userService.getListAllUsers()),headers, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Response> returnUserById(@PathVariable Long id){
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(new Response(userService.getUserById(id)),headers, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Response> insertNewUser(@RequestBody @Valid UserDto userDto, BindingResult result){
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);
        return new ResponseEntity<>(new Response(userService.insertNewUser(user)),headers,HttpStatus.CREATED);
    }
}
