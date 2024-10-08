package com.virtushawk.boxappuser.dao;

import com.virtushawk.boxappuser.model.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

    List<User> findAllByUsernameIn(List<String> usernames);
}
