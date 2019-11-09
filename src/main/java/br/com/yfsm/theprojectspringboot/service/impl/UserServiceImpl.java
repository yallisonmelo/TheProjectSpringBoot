package br.com.yfsm.theprojectspringboot.service.impl;

import br.com.yfsm.theprojectspringboot.domain.User;
import br.com.yfsm.theprojectspringboot.exception.UserNotFoundException;
import br.com.yfsm.theprojectspringboot.repository.UserRepository;
import br.com.yfsm.theprojectspringboot.service.IUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserImpl {


    @Autowired
    UserRepository userRepository;

    public List<User> getListAllUsers() {
        return
                Optional.ofNullable(
                        userRepository.findAll())
                        .orElseThrow(UserNotFoundException::new
                        );
    }

    public User getUserById(Long id) {

        return (
                userRepository
                        .findById(id))
                .orElseThrow(UserNotFoundException::new
                );
    }

    public User insertNewUser(User user) {
        user.setActive(true);
        return userRepository.save(user);
    }


    public User updateUser(User user, Long id) {
        return userRepository.findById(id).map(obj -> {
            obj.setName(user.getName());
            obj.setEmail(user.getEmail());
            obj.setPassword(user.setHashPassword(user.getPassword()));
            return userRepository.save(obj);
        }).orElseGet(() -> {
            user.setId(id);
            return userRepository.save(user);
        });
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
