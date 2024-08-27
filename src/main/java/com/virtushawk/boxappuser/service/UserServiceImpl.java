package com.virtushawk.boxappuser.service;

import com.virtushawk.boxappuser.dao.UserRepository;
import com.virtushawk.boxappuser.model.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

   private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public List<User> fetchUserData(List<String> userNames) {
        return userRepository.findAllByUsernameIn(userNames);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
       return userRepository.save(user);
    }

}
