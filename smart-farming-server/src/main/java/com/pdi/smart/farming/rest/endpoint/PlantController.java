package com.pdi.smart.farming.rest.endpoint;

import com.pdi.smart.farming.db.PlantRepository;
import com.pdi.smart.farming.rest.dto.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
@RestController
public class PlantController {
    @Autowired
    private PlantRepository plantRepository;

    @GetMapping(value = "/mobile/api/plant")
    public @ResponseBody
    ResponseEntity<List<Plant>> getPlants(@RequestParam(value = "userId") String userId) {
        Optional<List<Plant>> plantsWrp = Optional.ofNullable(plantRepository.findByUserId(userId));

        if(plantsWrp.isPresent() && !plantsWrp.get().isEmpty()) {
            return new ResponseEntity<List<Plant>>(plantsWrp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
