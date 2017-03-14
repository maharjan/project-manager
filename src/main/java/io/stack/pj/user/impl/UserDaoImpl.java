package io.stack.pj.user.impl;

import io.stack.pj.user.UserDao;
import io.stack.pj.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Prajin Maharjan
 * @since 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
