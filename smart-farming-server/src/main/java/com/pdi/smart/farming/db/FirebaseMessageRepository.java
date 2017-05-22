package com.pdi.smart.farming.db;

import com.pdi.smart.farming.fcm.FirebaseMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ionutciuta24@gmail.com on 22.05.2017.
 */
public interface FirebaseMessageRepository extends MongoRepository<FirebaseMessage, String> {
}
