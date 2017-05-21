package com.pdi.smart.farming.db;

import com.pdi.smart.farming.rest.dto.Plant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
public interface PlantRepository extends MongoRepository<Plant, String> {
    List<Plant> findByUserId(String userId);
}
