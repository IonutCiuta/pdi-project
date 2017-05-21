package com.pdi.smart.farming.service;

import com.pdi.smart.farming.db.UserRepository;
import com.pdi.smart.farming.rest.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ionutciuta24@gmail.com on 30.04.2017.
 */
@Component
public class UserService {
    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    public User signUp(User user) {
        user.setPassword(encryptionService.encrypt(user.getPassword()));

        return userRepository.save(user);
    }

    public Boolean signIn(String username, String pasword) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        //String safePass = encryptionService.encrypt(pasword);
        //return user.isPresent() && safePass.equals(user.get().getPassword());
        return user.isPresent() && user.get().getPassword().equals(pasword);
    }

    public User findAuthenticatedUser(String username) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));

        if(user.isPresent()) {
            user.get().setPassword(null);
        }

        return user.get();
    }

    public boolean addToken(String userId, String token) {
        Optional<User> userWrp = Optional.ofNullable(userRepository.findOne(userId));
        if(userWrp.isPresent()) {
            User user = userWrp.get();
            if(user.containsDeviceId(token)) {
                log.warn("Token already registered {}", token);
            } else {
                log.warn("New token added!");
                user.addDeviceId(token);
                userRepository.save(user);
            }

            return true;
        }

        return false;
    }
}
