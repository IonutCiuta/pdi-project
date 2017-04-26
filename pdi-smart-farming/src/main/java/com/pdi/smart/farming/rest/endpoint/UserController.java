package com.pdi.smart.farming.rest.endpoint;

import com.pdi.smart.farming.rest.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * ionutciuta24@gmail.com on 26.04.2017.
 */
@RestController(value = "/mobile/api/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@RequestParam(value = "name") String username) {
        return new User(username, "some pass");
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody User registerUser(@RequestBody User user) {
        user.setId("id");
        return user;
    }
}
