package com.pdi.smart.farming;

import com.pdi.smart.farming.service.SocketServerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;

import static java.lang.Thread.sleep;

@SpringBootApplication
public class PdiSmartFarmingApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PdiSmartFarmingApplication.class, args);

		Runnable server = new Runnable() {
			@Override
			public void run() {
				try {
					new SocketServerService("localhost", 8090).startServer();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		};

		new Thread(server).start();


	}
}
