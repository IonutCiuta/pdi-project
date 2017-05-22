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
    private Plant plant1, plant2, plant3, plant4, plant5, plant6;

    @PostConstruct
    private void init() {
        //this.user = new User("u1", "ion", "pass");
        this.plant1 = new Plant("101", "u1", "Rosie 1");
        this.plant2 = new Plant("102", "u1", "Castravete 1");
        this.plant3 = new Plant("103", "u1", "Trandafir 1");
        this.plant4 = new Plant("201", "u1", "Rosie 2");
        this.plant5 = new Plant("202", "u1", "Castravete 2");
        this.plant6 = new Plant("203", "u1", "Trandafir 2");
     }

    public void setup() {
        log.info("Setup: " + initData);
        if(initData) {
            //userRepository.save(user);
            plantRepository.save(Arrays.asList(plant1, plant2, plant3, plant4, plant5, plant6));
        }
    }
}
