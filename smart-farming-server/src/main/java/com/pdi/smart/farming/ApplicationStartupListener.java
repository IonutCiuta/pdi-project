package com.pdi.smart.farming;

import com.pdi.smart.farming.service.DummyDataService;
import com.pdi.smart.farming.service.SocketServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * ionutciuta24@gmail.com on 21.05.2017.
 */
@Component
public class ApplicationStartupListener implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    public DummyDataService dummyDataService;

    @Autowired
    public SocketServerService socketServerService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        dummyDataService.setup();
        openSocketServer();
    }

    private void openSocketServer() {
        new Thread(() -> {
            try {
               socketServerService.startServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
