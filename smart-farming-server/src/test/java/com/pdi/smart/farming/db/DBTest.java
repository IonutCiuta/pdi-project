package com.pdi.smart.farming.db;

import com.pdi.smart.farming.db.UserRepository;
import com.pdi.smart.farming.rest.dto.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * ionutciuta24@gmail.com on 30.04.2017.
 */
@RunWith(SpringRunner.class)
public class DBTest {

    private User user;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        user = new User("John", "pass");
    }

    @Test
    public void test_success_userRepo() {
        userRepository.save(user);
        User result = userRepository.findByUsername(user.getUsername());
        assertTrue(result.getPassword().equals(user.getPassword()));
    }
}
