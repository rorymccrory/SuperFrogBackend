package com.example.backend.service;

import com.example.backend.dao.UserDao;
import com.example.backend.domain.MyUserPrincipal;
import com.example.backend.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements UserDetailsService {
    private UserDao userDao;
    private BCryptPasswordEncoder encoder;

    public UserService(UserDao userDao, BCryptPasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.save(user);
    }

    public void update(Integer id, User user) {
        user.setId(id);
        userDao.save(user);
    }

    public void deleteById(Integer id) {
        userDao.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Step 1, we need to find this user from DB
        User user = userDao.findByUsername(username);
        // Step 2, if the user does exist
        if (user == null) {
            throw new UsernameNotFoundException("username " + username + " is not found");
        }
        // Otherwise, wrap the returned user instance in a MyUserPrincipal instance
        return new MyUserPrincipal(user); // return the principal-
    }
}

