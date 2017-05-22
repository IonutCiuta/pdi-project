package com.pdi.smart.farming.service;

import com.pdi.smart.farming.db.PlantRepository;
import com.pdi.smart.farming.db.UserRepository;
import com.pdi.smart.farming.rest.dto.Plant;
import com.pdi.smart.farming.rest.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
@Component
public class DummyDataService{
    private Logger log = LoggerFactory.getLogger(getClass().getName());

    @Value("${data.init}")
    private Boolean initData;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlantRepository plantRepository;

    private User user;
    private Plant plant1, plant2, plant3, plant4, plant5;

    @PostConstruct
    private void init() {
        this.user = new User("u1", "ion", "pass");
        this.plant1 = new Plant("p1", "u1", "Plant 1");
        this.plant2 = new Plant("p2", "u1", "Plant 2");
        this.plant3 = new Plant("p3", "u1", "Plant 3");
        this.plant4 = new Plant("p4", "u1", "Plant 4");
        this.plant5 = new Plant("p5", "u1", "Plant 5");
     }

    public void setup() {
        log.info("Setup: " + initData);
        if(initData) {
            userRepository.save(user);
            plantRepository.save(Arrays.asList(plant1, plant2, plant3, plant4, plant5));
        }
    }
}
