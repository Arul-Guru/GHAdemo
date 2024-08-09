package com.userproject.crud.services;

import com.userproject.crud.dao.UserRepository;
import com.userproject.crud.exceptions.UserNotFoundException;
import com.userproject.crud.models.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Transactional(propagation = Propagation.NESTED)
    public User addUser(User user){
        userRepository.save(user);
        return user;
    }


    public User getUserById(Long id) throws UserNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if( user.isEmpty()){
            throw new UserNotFoundException("The user "+ id+" not found");
        }

        return user.get();

    }

    public User updateUser(User user){
        userRepository.save(user);
        return user;
    }

    public User deleteUser(Long id) throws UserNotFoundException{
        User user = getUserById(id);

        userRepository.deleteById(id);
        return user;

    }

    public List<User> getUserByPassword(String pass){
        return userRepository.findByPassword(pass);
    }



}
