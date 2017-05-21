package com.pdi.smart.farming;

import com.pdi.smart.farming.service.DummyDataService;
import com.pdi.smart.farming.service.SocketServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class PdiSmartFarmingApplication {
	public static void main(String[] args) {
		SpringApplication.run(PdiSmartFarmingApplication.class, args);
	}
}
