package com.pdi.smart.farming.rest.endpoint;

import com.pdi.smart.farming.db.UserRepository;
import com.pdi.smart.farming.rest.dto.User;
import com.pdi.smart.farming.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * ionutciuta24@gmail.com on 26.04.2017.
 */
@RestController(value = "/mobile/api/user")
public class UserController {
    private final Logger log = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private UserService userService;

    public @RequestMapping(value = "/signup", method = RequestMethod.POST)
    ResponseEntity<User> signUp(@RequestBody User user) {
        log.info("Sing up: {} | {}", user.getUsername(), user.getPassword());
        Optional<User> newUser = Optional.ofNullable(userService.signUp(user));
        ResponseEntity<User> response;

        response = newUser.map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.FORBIDDEN));

        return response;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<User> signIn(@RequestBody User user) {
        log.info("Sing in: {} | {}", user.getUsername(), user.getPassword());
        boolean hasValidCredentials = userService.signIn(user.getUsername(), user.getPassword());
        ResponseEntity<User> response;

        if(hasValidCredentials) {
            response = new ResponseEntity<User>(userService.findAuthenticatedUser(user.getUsername()), HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return response;
    }
}
