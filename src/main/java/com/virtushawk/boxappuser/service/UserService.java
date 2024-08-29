package com.virtushawk.boxappuser.service;

import com.virtushawk.boxappuser.model.User;
import java.util.List;

public interface UserService {

    List<User> findAll();

    List<User> fetchUserData(List<String> userNames);

    User findById(String id);

    User create(User user);

    void delete(String userId);
}
