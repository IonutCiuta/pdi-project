package com.pdi.smart.farming.db;

import com.pdi.smart.farming.rest.dto.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * ionutciuta24@gmail.com on 30.04.2017.
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
