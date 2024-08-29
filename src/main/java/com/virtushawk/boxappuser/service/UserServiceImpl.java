package com.virtushawk.boxappuser.service;

import com.virtushawk.boxappuser.dao.UserRepository;
import com.virtushawk.boxappuser.model.User;
import com.virtushawk.boxappuser.service.message.RegistrationProducer;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

   private final UserRepository userRepository;
   private final RegistrationProducer registrationProducer;

    public UserServiceImpl(UserRepository userRepository, RegistrationProducer registrationProducer) {
        this.userRepository = userRepository;
        this.registrationProducer = registrationProducer;
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

    @Transactional
    @Override
    public void delete(String userId) {
        userRepository.findById(userId).ifPresent(user -> {
            String username = user.getUsername();
            userRepository.delete(user);
            registrationProducer.sendStringMessage("event.unregister", username);
        });
    }

}
