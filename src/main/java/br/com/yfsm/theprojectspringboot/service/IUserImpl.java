package br.com.yfsm.theprojectspringboot.service;

import br.com.yfsm.theprojectspringboot.domain.User;

import java.util.List;

public interface IUserImpl {

     List<User> getListAllUsers();
     User getUserById(Long id);
     User insertNewUser(User user);
     User updateUser(User user);
     void deleteUser(User user);
}
