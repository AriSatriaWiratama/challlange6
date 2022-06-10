package com.example.demo.serviceImpl;

import com.example.demo.entity.User;
import com.example.demo.repo.userRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
public class UserLoginServiceImpl implements UserDetailsService {
    @Autowired
    private userRepository user_repo;

//    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    private final Logger logger = LogManager.getLogger(UserLoginServiceImpl.class);

//    @Override
    public User saveUser(User userLogin) {
        userLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
        return user_repo.save(userLogin);
    }

//    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = user_repo.findByUsername(username);
        if (user == null) {
            logger.error("user not found");
        } else {
            logger.info(username + "found .!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);
    }
}
