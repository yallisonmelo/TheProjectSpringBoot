package br.com.yfsm.theprojectspringboot.service;

import br.com.yfsm.theprojectspringboot.domain.User;
import br.com.yfsm.theprojectspringboot.exception.UserNotFoundException;
import br.com.yfsm.theprojectspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;

    public List<User> getListAllUsers(){
    return   Optional.ofNullable(userRepository.findAll()).orElseThrow(() ->(new UserNotFoundException()));
    }

    public User getUserById(Long id){
        return (userRepository.findById(id)).orElseThrow(UserNotFoundException::new);
    }


    public User InsertNewUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        if (userRepository.findById(user.getId()).isPresent()) {
            return userRepository.save(user);
        }else{
            return user;
        }
    }


    public void deleteUser(User user){
        userRepository.delete(user);
    }
}
