package manna.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TextTask {

    @Scheduled(fixedDelay = 5000)
    public void text() {
        System.out.println("Hello world!");
    }
}